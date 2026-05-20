/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author usuario
 */
public abstract class Plato {
    private String nombre;
    private double precioBase;
    private CategoriaComida categoria;
    
    public Plato(){
        this.nombre = "Sin nombre";
        this.precioBase = 0.0;
        this.categoria = null;
    }
    
    public Plato(String nombre, double precioBase, CategoriaComida categoria){
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }
    
    public abstract double calcularPrecio();
    
    public String getNombre(){
        return this.nombre;
    }
    
    public double getPrecioBase(){
        return this.precioBase;
    }
    
    public CategoriaComida getCategoria(){
        return this.categoria;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+" | Precio Base: "+this.precioBase+" | Categoria: "+this.categoria;
    }
}
