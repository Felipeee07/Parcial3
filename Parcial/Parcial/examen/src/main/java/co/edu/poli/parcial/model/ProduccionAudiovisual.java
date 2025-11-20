package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa una producción audiovisual, 
 * como una película o una serie.
 * 
 * <p>Contiene los atributos y métodos comunes que comparten
 * todas las producciones del sistema. 
 * Implementa la interfaz {@link Serializable} para permitir
 * su almacenamiento y recuperación desde archivos.</p>
 * 
 * @author Felipe Parra
 */
public abstract class ProduccionAudiovisual implements Serializable {

    /** Código único que identifica la producción */
    private String codigo;

    /** Título de la producción */
    private String titulo;

    /** Año de estreno de la producción */
    private int fechaEstreno;

    /** Duración de la producción en minutos */
    private int duracionMin;

    /** Director responsable de la producción */
    private Director director;

    /**
     * Constructor vacío por defecto.
     * Permite crear una producción sin inicializar sus atributos.
     */
    public ProduccionAudiovisual() {}

    /**
     * Constructor que inicializa todos los atributos de la producción.
     * 
     * @param codigo código único de la producción
     * @param titulo título de la producción
     * @param fechaEstreno año de estreno
     * @param duracionMin duración en minutos
     * @param director objeto {@link Director} asociado a la producción
     */
    public ProduccionAudiovisual(String codigo, String titulo, int fechaEstreno, int duracionMin, Director director) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.duracionMin = duracionMin;
        this.director = director;
    }

    /** @return código de la producción */
    public String getCodigo() { return codigo; }

    /** @param codigo nuevo código de la producción */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** @return título de la producción */
    public String getTitulo() { return titulo; }

    /** @param titulo nuevo título de la producción */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return año de estreno de la producción */
    public int getFechaEstreno() { return fechaEstreno; }

    /** @param fechaEstreno nuevo año de estreno */
    public void setFechaEstreno(int fechaEstreno) { this.fechaEstreno = fechaEstreno; }

    /** @return duración de la producción en minutos */
    public int getDuracionMin() { return duracionMin; }

    /** @param duracionMin nueva duración en minutos */
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    /** @return director asociado a la producción */
    public Director getDirector() { return director; }

    /** @param director nuevo director asociado */
    public void setDirector(Director director) { this.director = director; }

    /**
     * Muestra la información general de la producción audiovisual.
     * 
     * <p>Este método debe ser implementado por las subclases 
     * (por ejemplo, {@code Pelicula} o {@code Serie}).</p>
     */
    public abstract void mostrarInformacion();
}