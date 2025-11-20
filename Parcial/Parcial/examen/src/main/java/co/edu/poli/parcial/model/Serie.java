package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa una serie dentro del sistema de producciones audiovisuales.
 * 
 * <p>Hereda de {@link ProduccionAudiovisual} e implementa {@link Serializable}
 * para permitir la persistencia de los datos en archivos.</p>
 * 
 * <p>Incluye un atributo adicional que define el número de temporadas de la serie.</p>
 * 
 * @author Felipe Parra
 */
public class Serie extends ProduccionAudiovisual implements Serializable {

    /** Número total de temporadas que tiene la serie */
    private int numeroTemporadas;

    /**
     * Constructor por defecto.
     * <p>Permite crear una instancia de {@code Serie} sin inicializar sus atributos.</p>
     */
    public Serie() {}

    /**
     * Constructor que inicializa todos los atributos de la serie.
     * 
     * @param codigo código único de la producción
     * @param titulo título de la serie
     * @param fechaEstreno año de estreno de la serie
     * @param duracionMin duración promedio por episodio en minutos
     * @param director objeto {@link Director} asociado a la serie
     * @param numeroTemporadas número total de temporadas
     */
    public Serie(String codigo, String titulo, int fechaEstreno, int duracionMin, Director director, int numeroTemporadas) {
        super(codigo, titulo, fechaEstreno, duracionMin, director);
        this.numeroTemporadas = numeroTemporadas;
    }

    /**
     * Obtiene el número de temporadas de la serie.
     * 
     * @return número de temporadas
     */
    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    /**
     * Asigna un nuevo número de temporadas a la serie.
     * 
     * @param numeroTemporadas nuevo número de temporadas
     */
    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    /**
     * Muestra la información completa de la serie en consola.
     * <p>Sobrescribe el método {@link ProduccionAudiovisual#mostrarInformacion()}.</p>
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Serie ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Fecha de estreno: " + getFechaEstreno());
        System.out.println("Duración: " + getDuracionMin() + " minutos");
        System.out.println("Director: " + getDirector().getNombre());
        System.out.println("Número de temporadas: " + numeroTemporadas);
    }
}