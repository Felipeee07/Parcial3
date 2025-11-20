package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.ProduccionAudiovisual;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de OperacionCrud.
 * Gestiona la lista interna de ProduccionAudiovisual
 * y delega la persistencia en OperacionArchivo.
 */
public class ImplOperacionCrud implements OperacionCrud {

    private List<ProduccionAudiovisual> lista;
    private OperacionArchivo archivo;

    public ImplOperacionCrud() {
        lista = new ArrayList<>();
        archivo = new OperacionArchivo();
    }

    // -------------------------
    //  CRUD
    // -------------------------
    @Override
    public void crear(ProduccionAudiovisual p) {
        lista.add(p);
    }

    @Override
    public boolean modificar(String codigo, ProduccionAudiovisual nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        ProduccionAudiovisual p = buscarPorCodigo(codigo);
        if (p != null) {
            lista.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public ProduccionAudiovisual buscarPorCodigo(String codigo) {
        for (ProduccionAudiovisual p : lista) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        }
        return null;
    }

    @Override
    public List<ProduccionAudiovisual> listarTodos() {
        return lista;
    }

    // -------------------------
    //  SERIALIZACIÓN / ARCHIVO
    // -------------------------
    public void guardarArchivo() {
        archivo.guardarArchivo(lista);
    }

    public void cargarDesdeArchivo() {
        List<ProduccionAudiovisual> cargado = archivo.cargarArchivo();
        if (cargado != null) {
            lista = cargado;
        } else {
            lista = new ArrayList<>();
        }
    }
}
