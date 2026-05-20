/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author usuario
 */
public class Postre extends Plato{
    private boolean conHelado;
    
    public Postre(String nombre, double precioBase, CategoriaComida categoria, boolean conHelado){
        super(nombre, precioBase, categoria);
        this.conHelado = conHelado;
    }
    
    @Override
    public double calcularPrecio(){
        double precioFinal = getPrecioBase();
        if(conHelado){
            precioFinal += precioFinal * 0.15;
        }
        return precioFinal;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | ¿Con helado?: " + (conHelado ? "Si" : "No");
    }
}
