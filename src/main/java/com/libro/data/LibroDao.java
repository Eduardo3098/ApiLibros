package com.libro.data;

import com.libro.domian.Libro;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface LibroDao {
    public List<Libro> buscarTodos();
    public Libro buscarUno(Libro libro);
    public void insertar(Libro libro);
    public void actualizar(Libro libro);
    public void eliminar(Libro libro);
}
