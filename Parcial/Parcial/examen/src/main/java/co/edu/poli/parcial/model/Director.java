package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa a un director de una producción audiovisual.
 * 
 * <p>Contiene los datos básicos de identificación y nacionalidad
 * del director. Implementa la interfaz {@link Serializable}
 * para permitir su persistencia en archivos.</p>
 * 
 * @author Felipe Parra
 */
public class Director implements Serializable {

    /** Identificador único del director */
    private String id;

    /** Nombre completo del director */
    private String nombre;

    /** Nacionalidad del director */
    private String nacionalidad;

    /**
     * Constructor vacío por defecto.
     * <p>Permite crear un objeto {@code Director} sin inicializar sus atributos.</p>
     */
    public Director() {}

    /**
     * Constructor que inicializa todos los atributos del director.
     * 
     * @param id identificador único del director
     * @param nombre nombre completo del director
     * @param nacionalidad país o nacionalidad del director
     */
    public Director(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el identificador único del director.
     * 
     * @return id del director
     */
    public String getId() {
        return id;
    }

    /**
     * Asigna un nuevo identificador al director.
     * 
     * @param id nuevo id del director
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del director.
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
     * Asigna una nueva nacionalidad al director.
     * 
     * @param nacionalidad nueva nacionalidad del director
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}