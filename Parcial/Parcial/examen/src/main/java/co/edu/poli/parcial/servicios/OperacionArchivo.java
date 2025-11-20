package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la persistencia de datos mediante serialización.
 *
 * <p>Permite guardar y cargar una lista completa de objetos
 * {@link ProduccionAudiovisual} utilizando un archivo binario
 * denominado <strong>data.dat</strong>.</p>
 *
 * <p>Esta clase es utilizada por {@link ImplOperacionCrud} para manejar la
 * persistencia del sistema.</p>
 *
 * @author Felipe Parra
 */
public class OperacionArchivo {

    /** Nombre del archivo donde se almacenan los datos serializados. */
    private final String archivo = "data.dat";

    /**
     * Guarda en el archivo binario la lista completa de producciones audiovisuales.
     *
     * <p>Utiliza {@link ObjectOutputStream} para serializar el contenido.
     * Si ocurre algún error, el método lo notifica por consola.</p>
     *
     * @param lista lista de objetos {@link ProduccionAudiovisual} a serializar
     */
    public void guardarArchivo(List<ProduccionAudiovisual> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Carga desde el archivo binario la lista de producciones audiovisuales previamente guardada.
     *
     * <p>Si el archivo no existe, se indica en consola y se retorna una lista vacía.
     * Si ocurre un error durante la carga o la lectura, también se retorna una lista vacía.</p>
     *
     * @return lista cargada desde el archivo o una lista vacía si no existe o ocurre un error
     */
    @SuppressWarnings("unchecked")
    public List<ProduccionAudiovisual> cargarArchivo() {

        File f = new File(archivo);
        if (!f.exists()) {
            System.out.println("No existe data.dat, se creará al guardar.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            System.out.println("Datos cargados correctamente.");
            return (ArrayList<ProduccionAudiovisual>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
