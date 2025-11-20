package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionArchivo {

    private final String archivo = "data.dat";

    /**
     * Guarda toda la lista completa en el archivo .dat
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
     * Carga los datos del archivo .dat si existe
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
