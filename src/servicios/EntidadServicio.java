package servicios;

import java.util.ArrayList;

public interface EntidadServicio<T> {
    public int crearEntidad(T t);
    public ArrayList<T> listarEntidad();
    public T buscarEntidad(int id);
    public int actualizarEntidad(T t);
    public int eliminarEntidad(int id);
}