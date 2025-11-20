package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Representa a un director de una producción audiovisual.
 *
 * <p>Incluye información básica como su identificador, nombre y nacionalidad.
 * Implementa {@link Serializable} para permitir su almacenamiento en archivos
 * durante los procesos de serialización.</p>
 *
 * @author Felipe Parra
 */
public class Director implements Serializable {

    /** Identificador único del director. */
    private String id;

    /** Nombre completo del director. */
    private String nombre;

    /** Nacionalidad o país de origen del director. */
    private String nacionalidad;

    /**
     * Constructor vacío que permite crear un objeto {@code Director}
     * sin inicializar sus atributos.
     */
    public Director() {}

    /**
     * Constructor que permite crear un director con todos sus atributos inicializados.
     *
     * @param id            identificador único del director
     * @param nombre        nombre completo del director
     * @param nacionalidad  nacionalidad o país del director
     */
    public Director(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el identificador del director.
     *
     * @return id del director
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del director.
     *
     * @param id nuevo identificador del director
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del director.
     *
     * @return nombre del director
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nuevo nombre al director.
     *
     * @param nombre nuevo nombre del director
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la nacionalidad del director.
     *
     * @return nacionalidad del director
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del director.
     *
     * @param nacionalidad nueva nacionalidad del director
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
