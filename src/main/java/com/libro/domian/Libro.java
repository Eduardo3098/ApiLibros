package com.libro.domian;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Eduardo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Libro.encontrarLibros", query = "SELECT l FROM Libro l ORDER BY l.nombre")
})
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre")    
    
    private String nombre;
    private String descripcion;
    private String autor;
    private String fecha;
    private int ejemplares;
    private double costo;
            
    public Libro() {
        
    }
    
    public Libro(String nombre) {
        this.nombre = nombre;
    }
    
    public Libro(String nombre, String descripcion, String autor, String fecha, int ejemplares, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fecha = fecha;
        this.ejemplares = ejemplares;
        this.costo = costo;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", autor=" + autor + ", fecha=" + fecha + ", ejemplares=" + ejemplares + ", costo=" + costo + '}';
    }
    
    
}
