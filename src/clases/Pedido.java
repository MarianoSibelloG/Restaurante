/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Pedido implements Descontable, Entregable{
    private Cliente cliente;
    private ArrayList<Plato> platos;
    private MetodoEntrega metodoEntrega;
    private boolean confirmado;
    private double descuento;
    
    public Pedido(Cliente cliente, MetodoEntrega metodoEntrega){
        this.cliente = cliente;
        this.metodoEntrega = metodoEntrega;
        this.platos = new ArrayList<>(); // Creás la lista vacía para que no sea null
        this.confirmado = false;         // Por defecto arranca sin confirmar
        this.descuento = 0.0;            // Por defecto arranca sin descuento
    }
    
    /*public Pedido(Cliente cliente, MetodoEntrega metodoEntrega, double descuento){
        this.cliente = cliente;
        this.metodoEntrega = metodoEntrega;
        this.platos = new ArrayList<>(); // Creás la lista vacía para que no sea null
        this.confirmado = false;         // Por defecto arranca sin confirmar
        this.descuento = descuento;            
    }*/

    // Segundo constructor (Cero repetición de código)
    public Pedido(Cliente cliente, MetodoEntrega metodoEntrega, double descuento){
        this(cliente, metodoEntrega); // Llama al de arriba: inicializa cliente, entrega, lista y confirmado
        this.descuento = descuento;   // Acá solo configuras lo que cambia
    }
    
    public void agregarPlato(Plato plato){
        this.platos.add(plato);
    }
    
    public void confirmar(){
        if (!this.platos.isEmpty() && !this.confirmado) {
            this.confirmado = true;
            System.out.println("Pedido confirmado con éxito.");
        } else if (this.platos.isEmpty()) {
            System.out.println("Error: El pedido debe tener al menos un plato para confirmarse.");
        } else {
            System.out.println("Error: El pedido ya estaba confirmado.");
        }
    }
    
    public double calcularTotal(){
        double total = 0.0;

        for(Plato p : this.platos) {
            total += p.calcularPrecio();
        }

        // Regla: El descuento solo se aplica a pedidos con más de 2 platos
        if(this.descuento > 0 && this.platos.size() > 2) {
            total -= total * (this.descuento / 100);
        }
        
        return total;
    }
    
    public boolean getConfirmado() {
        return this.confirmado;
    }
    
    @Override
    public double aplicarDescuento(double porcentaje){
        this.descuento = porcentaje;
        return porcentaje; 
    }
    
    @Override
    public void entregar(){
        if(this.metodoEntrega == MetodoEntrega.DELIVERY) {
            System.out.println("Pedido en camino hacia " + this.cliente.getNombre() + ".");
        } else {
            System.out.println("Pedido listo para servir en mesa.");
        }
    }

    @Override
    public String toString(){
        return "Pedido de: [" + this.cliente.getNombre() + 
               "] | Método: " + this.metodoEntrega + 
               " | Confirmado: " + (this.confirmado ? "Sí" : "No") + 
               " | Descuento aplicado: " + this.descuento + "%" +
               " | TOTAL: $" + calcularTotal();
    }
}
