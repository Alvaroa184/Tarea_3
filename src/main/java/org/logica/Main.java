package org.logica;
import java.util.ArrayList;


/**
 * Clase principal que contiene las pruebas automáticas,
 * para verificar el funcionamiento de la máquina expendedora.
 */
public class Main {
    public static void main(String[] args) {
         System.out.println("prueba 1:");
        Expendedor exp = new Expendedor(0);
        try {
            Comprador c = new Comprador(new Moneda1500(), TipoProducto.COCACOLA, exp);

            System.out.println("tomaste: " + c.queBebiste());
            System.out.println("tu vuelto es: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());

        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());

        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        exp=new Expendedor(6);
         System.out.println();
         System.out.println(("prueba 2:"));
        try {
            Comprador c = new Comprador(new Moneda1500(), TipoProducto.COCACOLA, exp);

            System.out.println("tomaste una: " + c.queBebiste());
            System.out.println("tu vuelto es: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());

        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());

        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
         System.out.println("prueba 3:");
        try {
        Comprador c = new Comprador(null, TipoProducto.COCACOLA, exp);

        System.out.println("tomaste una: " + c.queBebiste());
        System.out.println("tu vuelto es: " + c.cuantoVuelto());

    } catch (PagoIncorrectoException e) {
        System.out.println(e.getMessage());

    } catch (PagoInsuficienteException e) {
        System.out.println(e.getMessage());

    } catch (NoHayProductoException e) {
        System.out.println(e.getMessage());
    }
        System.out.println();
        System.out.println("prueba 4:");
        try {
            Comprador c = new Comprador(new Moneda100(), TipoProducto.COCACOLA, exp);

            System.out.println("tomaste una: " + c.queBebiste());
            System.out.println("tu vuelto es: " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());

        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());

        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("prueba 5:");

        ArrayList<Moneda> comparador = new ArrayList<>();
        comparador.add(new Moneda1000());
        comparador.add(new Moneda500());
        comparador.add(new Moneda100());
        comparador.add(new Moneda1500());

        System.out.println("Antes de ordenar:");
        for(int i = 0; i < comparador.size(); i++){
            Moneda m = comparador.get(i);
            System.out.println(m.toString());
        }

        comparador.sort(null);

        System.out.println("Despues de ordenar:");
        for(int i = 0; i < comparador.size(); i++){
            Moneda m = comparador.get(i);
            System.out.println(m.toString());
        }
    }
}

