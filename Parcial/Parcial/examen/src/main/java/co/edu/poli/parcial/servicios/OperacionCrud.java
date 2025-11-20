package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;
import java.util.List;

public interface OperacionCrud {

    void crear(ProduccionAudiovisual p);

    ProduccionAudiovisual buscarPorCodigo(String codigo);

    List<ProduccionAudiovisual> listarTodos();

    boolean modificar(String codigo, ProduccionAudiovisual nuevo);

    boolean eliminar(String codigo);
}
