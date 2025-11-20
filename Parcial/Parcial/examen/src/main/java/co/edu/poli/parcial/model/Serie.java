package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa una serie dentro del sistema de producciones audiovisuales.
 *
 * <p>Extiende a {@link ProduccionAudiovisual} e implementa {@link Serializable}
 * para permitir su almacenamiento en archivos mediante procesos de serialización.</p>
 *
 * <p>Añade el atributo {@code numeroTemporadas} que identifica cuántas temporadas
 * tiene la serie.</p>
 *
 * @author Felipe Parra
 */
public class Serie extends ProduccionAudiovisual implements Serializable {

    /** Número total de temporadas que posee la serie. */
    private int numeroTemporadas;

    /**
     * Constructor por defecto.
     *
     * <p>Permite crear una instancia de {@code Serie} sin inicializar sus atributos.</p>
     */
    public Serie() {}

    /**
     * Constructor que inicializa todos los atributos de la serie.
     *
     * @param codigo            código único de la producción
     * @param titulo            título de la serie
     * @param fechaEstreno      año de estreno
     * @param duracionMin       duración promedio por episodio en minutos
     * @param director          objeto {@link Director} asociado
     * @param numeroTemporadas  número total de temporadas de la serie
     */
    public Serie(String codigo, String titulo, int fechaEstreno, int duracionMin,
                 Director director, int numeroTemporadas) {
        super(codigo, titulo, fechaEstreno, duracionMin, director);
        this.numeroTemporadas = numeroTemporadas;
    }

    /**
     * Obtiene el número total de temporadas de la serie.
     *
     * @return número de temporadas
     */
    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    /**
     * Asigna un nuevo número de temporadas a la serie.
     *
     * @param numeroTemporadas nuevo valor del número de temporadas
     */
    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    /**
     * Muestra en consola la información completa de la serie.
     *
     * <p>Sobrescribe el método abstracto {@link ProduccionAudiovisual#mostrarInformacion()},
     * agregando los detalles específicos correspondientes a una serie.</p>
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
