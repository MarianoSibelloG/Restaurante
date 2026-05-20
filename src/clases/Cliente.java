/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author usuario
 */
public class Cliente {
    private String nombre;
    private String mail;
    private String telefono;
    
    public Cliente(String nombre, String mail, String telefono){
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+" | Mail: "+this.mail+" | Telefono: "+this.telefono;
    }
}
