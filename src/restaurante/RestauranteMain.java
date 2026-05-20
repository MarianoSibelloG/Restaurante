
package restaurante;

import clases.Restaurante;
import clases.Pedido;
import clases.Cliente;
import clases.Plato;
import clases.Comida;
import clases.Bebida;
import clases.Postre;
import clases.CategoriaComida;
import clases.MetodoEntrega;

public class RestauranteMain {

    public static void main(String[] args) {
        // 1. Crear el restaurante
        Restaurante restaurante = new Restaurante("Sabores del Sur");

        // 2. Agregar platos (suponemos precios base inventados)
        Plato milanesa = new Comida("Milanesa", 1500.0, CategoriaComida.PRINCIPAL, true); // con guarnición (+10%)
        Plato ensalada = new Comida("Ensalada César", 1200.0, CategoriaComida.PRINCIPAL, false); // sin guarnición
        Plato cerveza = new Bebida("Cerveza", 500.0, CategoriaComida.BEBIDA, true); // alcohólica (+20%)
        Plato helado = new Postre("Helado", 600.0, CategoriaComida.POSTRE, true); // con helado/recargo (+15%)

        restaurante.agregarPlato(milanesa);
        restaurante.agregarPlato(ensalada);
        restaurante.agregarPlato(cerveza);
        restaurante.agregarPlato(helado);

        // 3. Registrar dos clientes
        Cliente maria = new Cliente("María", "maria@mail.com", "123456");
        Cliente juan = new Cliente("Juan", "juan@mail.com", "789101");

        restaurante.agregarCliente(maria);
        restaurante.agregarCliente(juan);

        System.out.println("--- INICIO DE SIMULACIÓN ---");

        // 4. Escenario A: María hace pedido con 2 platos, método LOCAL
        System.out.println("\n[Escenario A]");
        Pedido pedido1 = new Pedido(maria, MetodoEntrega.LOCAL);
        pedido1.agregarPlato(milanesa);
        pedido1.agregarPlato(cerveza);
        
        pedido1.confirmar(); // Se confirma
        pedido1.entregar();  // Se entrega
        restaurante.registrarPedido(pedido1);

        // 5. Escenario B: Juan pide DELIVERY con 3 platos y aplica 10% de descuento
        System.out.println("\n[Escenario B]");
        // Usamos el constructor con descuento. Recordá que la regla pide > 2 platos para aplicar
        Pedido pedido2 = new Pedido(juan, MetodoEntrega.DELIVERY, 10.0); 
        pedido2.agregarPlato(milanesa);
        pedido2.agregarPlato(ensalada);
        pedido2.agregarPlato(helado);
        
        pedido2.confirmar(); // Se confirma (tiene 3 platos, cumple la regla de > 0)
        pedido2.entregar();  // Se entrega (mostrará en camino hacia Juan)
        restaurante.registrarPedido(pedido2);

        // 6. Mostrar todos los pedidos realizados y el total recaudado
        System.out.println("\n--- REPORTES FINALES ---");
        System.out.println("--- Lista de Pedidos Históricos ---");
        restaurante.listarPedidos();

        System.out.println("\n--- Balance del Restaurante ---");
        System.out.println(restaurante.toString());
    }
    
}
