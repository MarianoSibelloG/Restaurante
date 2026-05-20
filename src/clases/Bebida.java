/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author usuario
 */
public class Bebida extends Plato{
    private boolean esAlcoholica;
    
    public Bebida(String nombre, double precioBase, CategoriaComida categoria, boolean esAlcoholica){
        super(nombre, precioBase, categoria);
        this.esAlcoholica = esAlcoholica;
    }
    
    @Override
    public double calcularPrecio(){
        double precioFinal = getPrecioBase();
        
        if(esAlcoholica){
            precioFinal += precioFinal * 0.20;
        }
        
        return precioFinal;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | ¿Es alcohólica?: " + (esAlcoholica ? "Si" : "No");
    }
}
