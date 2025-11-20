package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta de la interfaz {@link OperacionCrud}.
 *
 * <p>Gestiona una lista en memoria de objetos {@link ProduccionAudiovisual}
 * permitiendo realizar operaciones CRUD sobre ellos. Además, delega los procesos
 * de persistencia en la clase {@link OperacionArchivo}.</p>
 *
 * <p>Esta clase actúa como el servicio central de gestión de datos utilizado
 * por el controlador de la aplicación.</p>
 *
 * @author Felipe Parra
 */
public class ImplOperacionCrud implements OperacionCrud {

    /** Lista interna que almacena las producciones audiovisuales en memoria. */
    private List<ProduccionAudiovisual> lista;

    /** Servicio encargado de la serialización y deserialización de datos. */
    private OperacionArchivo archivo;

    /**
     * Constructor que inicializa la lista interna y el servicio de archivo.
     */
    public ImplOperacionCrud() {
        lista = new ArrayList<>();
        archivo = new OperacionArchivo();
    }

    // -----------------------------------------------------------
    // CRUD
    // -----------------------------------------------------------

    /**
     * Agrega una nueva producción audiovisual a la lista interna.
     *
     * @param p objeto {@link ProduccionAudiovisual} a agregar
     */
    @Override
    public void crear(ProduccionAudiovisual p) {
        lista.add(p);
    }

    /**
     * Modifica una producción existente identificada por su código.
     *
     * @param codigo código de la producción a modificar
     * @param nuevo  objeto con los nuevos valores
     * @return {@code true} si la modificación fue exitosa,
     *         {@code false} si no se encontró el elemento
     */
    @Override
    public boolean modificar(String codigo, ProduccionAudiovisual nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una producción audiovisual por su código.
     *
     * @param codigo código de la producción a eliminar
     * @return {@code true} si la eliminación fue exitosa,
     *         {@code false} si no se encontró el elemento
     */
    @Override
    public boolean eliminar(String codigo) {
        ProduccionAudiovisual p = buscarPorCodigo(codigo);
        if (p != null) {
            lista.remove(p);
            return true;
        }
        return false;
    }

    /**
     * Busca una producción audiovisual mediante su código.
     *
     * @param codigo código a buscar
     * @return el objeto encontrado o {@code null} si no existe
     */
    @Override
    public ProduccionAudiovisual buscarPorCodigo(String codigo) {
        for (ProduccionAudiovisual p : lista) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        }
        return null;
    }

    /**
     * Retorna la lista completa de producciones almacenadas.
     *
     * @return lista de objetos {@link ProduccionAudiovisual}
     */
    @Override
    public List<ProduccionAudiovisual> listarTodos() {
        return lista;
    }

    // -----------------------------------------------------------
    // SERIALIZACIÓN / ARCHIVO
    // -----------------------------------------------------------

    /**
     * Guarda en archivo la lista completa de producciones audiovisuales.
     * <p>Utiliza el servicio {@link OperacionArchivo}.</p>
     */
    public void guardarArchivo() {
        archivo.guardarArchivo(lista);
    }

    /**
     * Carga los datos desde el archivo y los reemplaza en la lista interna.
     * <p>Si no se encuentra información válida, la lista se inicializa vacía.</p>
     */
    public void cargarDesdeArchivo() {
        List<ProduccionAudiovisual> cargado = archivo.cargarArchivo();
        if (cargado != null) {
            lista = cargado;
        } else {
            lista = new ArrayList<>();
        }
    }
}
