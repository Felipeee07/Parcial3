/**
 * Controlador principal del formulario de gestión de producciones audiovisuales.
 * Maneja las operaciones CRUD, la carga en tabla, la interacción con el usuario
 * y la comunicación con el servicio de almacenamiento.
 *
 * @author Felipe Parra
 */

package co.edu.poli.parcial.controlador;

import co.edu.poli.parcial.model.*;
import co.edu.poli.parcial.servicios.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class FormularioControlador {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtDuracion;
    @FXML private TextField txtDirector;
    @FXML private TextField txtGenero;
    @FXML private TextField txtTemporadas;
    @FXML private ComboBox<String> cmbTipo;

    @FXML private TableView<ProduccionAudiovisual> tabla;
    @FXML private TableColumn<ProduccionAudiovisual, String> colCodigo;
    @FXML private TableColumn<ProduccionAudiovisual, String> colTitulo;
    @FXML private TableColumn<ProduccionAudiovisual, String> colAnio;
    @FXML private TableColumn<ProduccionAudiovisual, String> colDirector;
    @FXML private TableColumn<ProduccionAudiovisual, String> colTipo;
    @FXML private TableColumn<ProduccionAudiovisual, String> colExtra;

    private ObservableList<ProduccionAudiovisual> datos;
    private ImplOperacionCrud servicio;

    // -------------------------------------------------------------------------
    //  INITIALIZE
    // -------------------------------------------------------------------------

    /**
     * Inicializa el controlador, configurando la tabla, los combos,
     * las columnas y el servicio CRUD interno.
     */
    @FXML
    public void initialize() {
        servicio = new ImplOperacionCrud();
        datos = FXCollections.observableArrayList();
        tabla.setItems(datos);

        cmbTipo.setItems(FXCollections.observableArrayList("Película", "Serie"));
        cmbTipo.getSelectionModel().selectFirst();

        colCodigo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCodigo()));
        colTitulo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitulo()));
        colAnio.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getFechaEstreno())));

        colDirector.setCellValueFactory(c -> {
            Director d = c.getValue().getDirector();
            return new SimpleStringProperty(d != null ? d.getNombre() : "");
        });

        colTipo.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue() instanceof Pelicula ? "Película" : "Serie"));

        colExtra.setCellValueFactory(c -> {
            ProduccionAudiovisual obj = c.getValue();
            if (obj instanceof Pelicula p) {
                return new SimpleStringProperty("Género: " + p.getGenero() + " / " + p.getDuracionMin() + "m");
            } else if (obj instanceof Serie s) {
                return new SimpleStringProperty("Temp: " + s.getNumeroTemporadas() + " / Dur: " + s.getDuracionMin() + "m");
            }
            return new SimpleStringProperty("");
        });

        tabla.setOnMouseClicked(this::displaySelected);
    }

    // -------------------------------------------------------------------------
    //  CREAR
    // -------------------------------------------------------------------------

    /**
     * Crea una nueva producción audiovisual a partir de los datos del formulario.
     * Valida que el código no exista previamente y agrega el objeto tanto a la tabla
     * como al servicio interno.
     */
    @FXML
    void accionCrear() {
        try {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) { alerta("Código requerido"); return; }
            if (servicio.buscarPorCodigo(codigo) != null) { alerta("Código ya existe"); return; }

            String titulo = txtTitulo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            String tipo = cmbTipo.getValue();
            String directorNombre = txtDirector.getText().trim();

            Director director = new Director("DIR-" + codigo, directorNombre, "Desconocida");

            ProduccionAudiovisual pa;
            if ("Película".equals(tipo)) {
                int dur = Integer.parseInt(txtDuracion.getText().trim());
                String genero = txtGenero.getText().trim();
                pa = new Pelicula(codigo, titulo, anio, dur, director, genero);
            } else {
                int dur = txtDuracion.getText().trim().isEmpty() ? 0 :
                        Integer.parseInt(txtDuracion.getText().trim());
                int temp = Integer.parseInt(txtTemporadas.getText().trim());
                pa = new Serie(codigo, titulo, anio, dur, director, temp);
            }

            datos.add(pa);
            servicio.crear(pa);
            clear();
            info("Creado correctamente");

        } catch (Exception ex) {
            alerta("Error en los datos: " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  BUSCAR
    // -------------------------------------------------------------------------

    /**
     * Busca una producción audiovisual según el código ingresado.
     * Si la encuentra, rellena los campos del formulario.
     */
    @FXML
    void accionBuscar() {
        String codigo = txtCodigo.getText().trim();
        if (codigo.isEmpty()) { alerta("Ingrese un código para buscar"); return; }

        ProduccionAudiovisual p = servicio.buscarPorCodigo(codigo);
        if (p == null) { alerta("No encontrado"); return; }

        fillFields(p);
    }

    // -------------------------------------------------------------------------
    //  MODIFICAR
    // -------------------------------------------------------------------------

    /**
     * Modifica el registro seleccionado en la tabla con los nuevos valores del formulario.
     * También actualiza el servicio interno.
     */
    @FXML
    void accionModificar() {
        try {
            ProduccionAudiovisual seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) { alerta("Seleccione un registro"); return; }

            String codigoNuevo = txtCodigo.getText().trim();
            if (codigoNuevo.isEmpty()) { alerta("El código no puede estar vacío"); return; }

            if (!codigoNuevo.equals(seleccionado.getCodigo()) &&
                    servicio.buscarPorCodigo(codigoNuevo) != null) {
                alerta("El nuevo código ya existe");
                return;
            }

            String titulo = txtTitulo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            String directorNombre = txtDirector.getText().trim();
            Director director = new Director("DIR-" + codigoNuevo, directorNombre, "Desconocida");

            ProduccionAudiovisual pa;
            if (cmbTipo.getValue().equals("Película")) {
                int dur = Integer.parseInt(txtDuracion.getText().trim());
                String genero = txtGenero.getText().trim();
                pa = new Pelicula(codigoNuevo, titulo, anio, dur, director, genero);
            } else {
                int dur = txtDuracion.getText().trim().isEmpty() ? 0 :
                        Integer.parseInt(txtDuracion.getText().trim());
                int temp = Integer.parseInt(txtTemporadas.getText().trim());
                pa = new Serie(codigoNuevo, titulo, anio, dur, director, temp);
            }

            int index = datos.indexOf(seleccionado);
            datos.set(index, pa);

            servicio.modificar(seleccionado.getCodigo(), pa);

            clear();
            info("Modificado correctamente");

        } catch (Exception ex) {
            alerta("Error al modificar: " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  ELIMINAR
    // -------------------------------------------------------------------------

    /**
     * Elimina el registro seleccionado de la tabla y del servicio interno.
     * Solicita confirmación al usuario antes de eliminar.
     */
    @FXML
    void accionEliminar() {
        try {
            ProduccionAudiovisual seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) { alerta("Seleccione un registro"); return; }

            Alert a = new Alert(Alert.AlertType.CONFIRMATION,
                    "¿Desea eliminar el registro?",
                    ButtonType.OK,
                    ButtonType.CANCEL);

            Optional<ButtonType> r = a.showAndWait();
            if (r.isPresent() && r.get() == ButtonType.OK) {

                servicio.eliminar(seleccionado.getCodigo());
                datos.remove(seleccionado);
                clear();

                info("Eliminado correctamente");
            }

        } catch (Exception ex) {
            alerta("Error al eliminar: " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    //  DESERIALIZAR
    // -------------------------------------------------------------------------

    /**
     * Carga en memoria los datos almacenados previamente en archivo.
     * No actualiza directamente la tabla; se debe presionar “Listar todo”.
     */
    @FXML
    void accionDeserializar() {
        servicio.cargarDesdeArchivo();
        info("Datos cargados en memoria. Ahora presione 'Listar todo' para mostrarlos.");
    }

    // -------------------------------------------------------------------------
    //  SERIALIZAR
    // -------------------------------------------------------------------------

    /**
     * Guarda los datos existentes en la lista interna dentro de un archivo externo.
     */
    @FXML
    void accionSerializar() {
        servicio.guardarArchivo();
        info("Datos guardados en archivo.");
    }

    // -------------------------------------------------------------------------
    //  LISTAR
    // -------------------------------------------------------------------------

    /**
     * Refresca la tabla con todos los elementos almacenados en el servicio.
     */
    @FXML
    void accionListar() {
        datos.setAll(servicio.listarTodos());
        tabla.refresh();
    }

    // -------------------------------------------------------------------------
    //  SELECCIÓN TABLA
    // -------------------------------------------------------------------------

    /**
     * Evento al seleccionar un elemento de la tabla.
     * Rellena los campos con los datos del objeto seleccionado.
     *
     * @param event evento del mouse al hacer clic en la tabla
     */
    @FXML
    void displaySelected(MouseEvent event) {
        ProduccionAudiovisual p = tabla.getSelectionModel().getSelectedItem();
        if (p != null) fillFields(p);
    }

    // -------------------------------------------------------------------------
    //  LLENAR CAMPOS
    // -------------------------------------------------------------------------

    /**
     * Llena los campos del formulario según el tipo de producción seleccionada.
     *
     * @param p producción audiovisual seleccionada
     */
    private void fillFields(ProduccionAudiovisual p) {
        txtCodigo.setText(p.getCodigo());
        txtTitulo.setText(p.getTitulo());
        txtAnio.setText(String.valueOf(p.getFechaEstreno()));
        txtDuracion.setText(String.valueOf(p.getDuracionMin()));
        txtDirector.setText(p.getDirector() != null ? p.getDirector().getNombre() : "");

        if (p instanceof Pelicula pel) {
            cmbTipo.getSelectionModel().select("Película");
            txtGenero.setText(pel.getGenero());
            txtTemporadas.clear();
        } else if (p instanceof Serie s) {
            cmbTipo.getSelectionModel().select("Serie");
            txtTemporadas.setText(String.valueOf(s.getNumeroTemporadas()));
            txtGenero.clear();
        }
    }

    // -------------------------------------------------------------------------
    //  LIMPIAR
    // -------------------------------------------------------------------------

    /**
     * Limpia todos los campos del formulario y restablece el combo a su valor inicial.
     */
    private void clear() {
        txtCodigo.clear();
        txtTitulo.clear();
        txtAnio.clear();
        txtDuracion.clear();
        txtDirector.clear();
        txtGenero.clear();
        txtTemporadas.clear();
        cmbTipo.getSelectionModel().selectFirst();
    }

    // -------------------------------------------------------------------------
    //  ALERTAS
    // -------------------------------------------------------------------------

    /**
     * Muestra una alerta tipo WARNING.
     *
     * @param msg mensaje a mostrar
     */
    private void alerta(String msg) {
        new Alert(Alert.AlertType.WARNING, msg).showAndWait();
    }

    /**
     * Muestra una alerta informativa.
     *
     * @param msg mensaje a mostrar
     */
    private void info(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).showAndWait();
    }
}
