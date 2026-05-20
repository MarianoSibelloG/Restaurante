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
public class Restaurante {
    private String nombre;
    private ArrayList<Plato> platosDisponibles;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;
    
    public Restaurante(){
        this.platosDisponibles = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    public Restaurante(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public void agregarPlato(Plato plato){
        this.platosDisponibles.add(plato);
    }
    
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public void registrarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    public Cliente buscarClientePorNombre(String nombre){
        Cliente clienteBuscado = null;
        
        for (Cliente c : clientes) {
            if(c.getNombre().equals(nombre)){
                clienteBuscado = c;
            }
        }
        
        if(clienteBuscado == null){
            System.out.println("Cliente no encontrado");
        }
        
        return clienteBuscado;
    }
    
    public void listarPedidos(){       
        for (Pedido p : pedidos) {
            System.out.println(p.toString());
        }
    }
    
    public double calcularRecaudacionTotal(){
        double total = 0;
        for (Pedido p : pedidos) {
            // Regla: Sumando SOLO los pedidos confirmados
            if (p.getConfirmado()) { 
                total += p.calcularTotal();
            }
        }
        return total;
    }
    
    // Completado: Devuelve la descripción del restaurante
    @Override
    public String toString(){
        return "Restaurante: " + this.nombre + 
               " | Platos en menú: " + platosDisponibles.size() + 
               " | Clientes registrados: " + clientes.size() + 
               " | Pedidos históricos: " + pedidos.size();
    }
}
