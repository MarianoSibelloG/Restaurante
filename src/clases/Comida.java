/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author usuario
 */
public class Comida extends Plato {
    private boolean tieneGuarnicion;
    
    public Comida(String nombre, double precioBase, CategoriaComida categoria, boolean tieneGuarnicion){
        super(nombre, precioBase, categoria);
        this.tieneGuarnicion = tieneGuarnicion;
    }
    
    @Override
    public double calcularPrecio(){
        double precioFinal = getPrecioBase();
        
        if(tieneGuarnicion){
            precioFinal += precioFinal * 0.10;
        }
        
        return precioFinal;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | ¿Tiene guarnición?: " + (tieneGuarnicion ? "Sí" : "No");
    }
}
