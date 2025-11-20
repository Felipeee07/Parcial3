package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Representa una película dentro del sistema de producciones audiovisuales.
 *
 * <p>Extiende la clase {@link ProduccionAudiovisual} e implementa {@link Serializable}
 * para permitir su persistencia mediante serialización.</p>
 *
 * <p>Incluye un atributo adicional correspondiente al género cinematográfico.</p>
 *
 * @author Felipe Parra
 */
public class Pelicula extends ProduccionAudiovisual implements Serializable {

    /** Género cinematográfico de la película. */
    private String genero;

    /**
     * Constructor vacío que permite crear una instancia de {@code Pelicula}
     * sin inicializar sus atributos.
     */
    public Pelicula() {}

    /**
     * Constructor que inicializa todos los atributos de la película.
     *
     * @param codigo        código único de la producción
     * @param titulo        título de la película
     * @param fechaEstreno  año de estreno de la película
     * @param duracion      duración en minutos
     * @param director      objeto {@link Director} asociado a la película
     * @param genero        género cinematográfico
     */
    public Pelicula(String codigo, String titulo, int fechaEstreno, int duracion,
                    Director director, String genero) {
        super(codigo, titulo, fechaEstreno, duracion, director);
        this.genero = genero;
    }

    /**
     * Obtiene el género cinematográfico de la película.
     *
     * @return género de la película
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece un nuevo género para la película.
     *
     * @param genero nuevo género cinematográfico
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Muestra en consola toda la información relevante de la película.
     *
     * <p>Sobrescribe el método {@link ProduccionAudiovisual#mostrarInformacion()}
     * para incluir los datos específicos de la película.</p>
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
