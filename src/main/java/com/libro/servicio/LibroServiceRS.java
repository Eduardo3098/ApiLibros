package com.libro.servicio;

import com.libro.data.LibroDao;
import com.libro.domian.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eduardo
 */
@Stateless
@Path("/libros")
public class LibroServiceRS {
    
    @Inject
    private LibroDao libroDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Libro> listar() {
        List<Libro> libros = libroDao.buscarTodos();
        System.out.println("Libros encontrados: " + libros);
        return libros;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Libro buscar(@PathParam("nombre") String nombre) {
        Libro libro = libroDao.buscarUno(new Libro(nombre));
        System.out.println("Libro encontrado:" + libro);
        return libro;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Libro agregar(Libro libro) {
        libroDao.insertar(libro);
        System.err.println("Libro agregado: " + libro);
        return libro;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Response editar(@PathParam("nombre") String nombre, Libro editar) {
        Libro libro = libroDao.buscarUno(new Libro(nombre));
        if(libro != null) {
            libroDao.actualizar(editar);
            System.out.println("Libro modificado: " + editar);
            return Response.ok().entity(editar).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{nombre}")
    public Response eliminar(@PathParam("nombre") String nombre) {
        libroDao.eliminar(new Libro(nombre));
        System.out.println("Libro eliminada con el Nombre: " + nombre);
        return Response.ok().build();
    }
}
