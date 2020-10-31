/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libro.data;

import com.libro.domian.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eduardo
 */
@Stateless
public class LibroDaoImpl implements LibroDao{

    @PersistenceContext (unitName = "LibroPU")
    EntityManager em;
    
    @Override
    public List<Libro> buscarTodos() {
        return em.createNamedQuery("Libro.encontrarLibros").getResultList();
    }

    @Override
    public Libro buscarUno(Libro libro) {
        return em.find(Libro.class, libro.getNombre());
    }

    @Override
    public void insertar(Libro libro) {
        em.persist(libro);
        em.flush();
    }

    @Override
    public void actualizar(Libro libro) {
        em.merge(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        em.remove(em.merge(libro));
    }
    
}
