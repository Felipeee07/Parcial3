package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa una película dentro del sistema de producciones audiovisuales.
 * 
 * <p>Hereda de {@link ProduccionAudiovisual} e implementa {@link Serializable}
 * para permitir su almacenamiento y recuperación desde archivos.</p>
 * 
 * <p>Incluye un atributo adicional para el género cinematográfico.</p>
 * 
 * @author Felipe Parra
 */
public class Pelicula extends ProduccionAudiovisual implements Serializable {

    /** Género cinematográfico de la película */
    private String genero;

    /**
     * Constructor por defecto.
     * <p>Permite crear un objeto {@code Pelicula} sin inicializar sus atributos.</p>
     */
    public Pelicula() {}

    /**
     * Constructor que inicializa todos los atributos de la película.
     * 
     * @param codigo código único de la producción
     * @param titulo título de la película
     * @param fechaEstreno año de estreno de la película
     * @param duracion duración en minutos
     * @param director objeto {@link Director} asociado a la película
     * @param genero género cinematográfico de la película
     */
    public Pelicula(String codigo, String titulo, int fechaEstreno, int duracion, Director director, String genero) {
        super(codigo, titulo, fechaEstreno, duracion, director);
        this.genero = genero;
    }

    /**
     * Obtiene el género de la película.
     * 
     * @return género cinematográfico
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Asigna un nuevo género a la película.
     * 
     * @param genero nuevo género cinematográfico
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Muestra la información completa de la película en consola.
     * <p>Sobrescribe el método {@link ProduccionAudiovisual#mostrarInformacion()}.</p>
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Película ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Fecha de estreno: " + getFechaEstreno());
        System.out.println("Duración: " + getDuracionMin() + " minutos");
        System.out.println("Director: " + getDirector().getNombre());
        System.out.println("Género: " + genero);
    }
}