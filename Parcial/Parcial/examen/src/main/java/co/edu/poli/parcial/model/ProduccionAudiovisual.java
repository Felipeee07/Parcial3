package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa una producción audiovisual,
 * como una película o una serie.
 *
 * <p>Define los atributos y comportamientos comunes para todas
 * las producciones del sistema. Las clases derivadas como
 * {@link Pelicula} o {@link Serie} deben implementar el método
 * abstracto {@link #mostrarInformacion()}.</p>
 *
 * <p>Implementa {@link Serializable} para permitir la persistencia
 * de los objetos a través de procesos de serialización.</p>
 *
 * @author Felipe Parra
 */
public abstract class ProduccionAudiovisual implements Serializable {

    /** Código único que identifica la producción. */
    private String codigo;

    /** Título de la producción audiovisual. */
    private String titulo;

    /** Año de estreno de la producción. */
    private int fechaEstreno;

    /** Duración de la producción en minutos. */
    private int duracionMin;

    /** Director responsable de la producción. */
    private Director director;

    /**
     * Constructor vacío que permite instanciar la producción
     * sin inicializar sus atributos.
     */
    public ProduccionAudiovisual() {}

    /**
     * Constructor que inicializa todos los atributos de la producción audiovisual.
     *
     * @param codigo        código único de la producción
     * @param titulo        título de la producción
     * @param fechaEstreno  año de estreno
     * @param duracionMin   duración total en minutos
     * @param director      objeto {@link Director} responsable de la producción
     */
    public ProduccionAudiovisual(String codigo, String titulo, int fechaEstreno,
                                 int duracionMin, Director director) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.duracionMin = duracionMin;
        this.director = director;
    }

    /** @return código único de la producción */
    public String getCodigo() { return codigo; }

    /** @param codigo nuevo código de la producción */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** @return título de la producción */
    public String getTitulo() { return titulo; }

    /** @param titulo nuevo título de la producción */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return año de estreno */
    public int getFechaEstreno() { return fechaEstreno; }

    /** @param fechaEstreno nuevo año de estreno */
    public void setFechaEstreno(int fechaEstreno) { this.fechaEstreno = fechaEstreno; }

    /** @return duración total en minutos */
    public int getDuracionMin() { return duracionMin; }

    /** @param duracionMin nueva duración de la producción en minutos */
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    /** @return director asociado a la producción */
    public Director getDirector() { return director; }

    /** @param director nuevo director asignado a la producción */
    public void setDirector(Director director) { this.director = director; }

    /**
     * Muestra la información detallada de la producción audiovisual.
     *
     * <p>Este método debe ser implementado por todas las subclases,
     * permitiendo que cada una muestre su información específica.</p>
     */
    public abstract void mostrarInformacion();

}
