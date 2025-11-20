package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar y Eliminar)
 * para gestionar objetos de tipo {@link ProduccionAudiovisual}.
 *
 * <p>Es implementada por {@link ImplOperacionCrud}, que maneja la lógica interna
 * de almacenamiento y la delegación a la clase de persistencia {@code OperacionArchivo}.</p>
 *
 * @author Felipe Parra
 */
public interface OperacionCrud {

    /**
     * Crea y almacena una nueva producción audiovisual.
     *
     * @param p objeto {@link ProduccionAudiovisual} a agregar
     */
    void crear(ProduccionAudiovisual p);

    /**
     * Busca una producción audiovisual cuyo código coincida con el proporcionado.
     *
     * @param codigo código único de la producción a buscar
     * @return la producción encontrada o {@code null} si no existe
     */
    ProduccionAudiovisual buscarPorCodigo(String codigo);

    /**
     * Retorna una lista con todas las producciones almacenadas.
     *
     * @return lista completa de producciones audiovisuales
     */
    List<ProduccionAudiovisual> listarTodos();

    /**
     * Modifica una producción existente reemplazándola por una nueva instancia.
     *
     * @param codigo código de la producción a modificar
     * @param nuevo nueva producción con los datos actualizados
     * @return {@code true} si la modificación se realizó, {@code false} si no se encontró el código
     */
    boolean modificar(String codigo, ProduccionAudiovisual nuevo);

    /**
     * Elimina una producción audiovisual según su código.
     *
     * @param codigo código de la producción a eliminar
     * @return {@code true} si se eliminó, {@code false} si no se encontró el código
     */
    boolean eliminar(String codigo);
}
