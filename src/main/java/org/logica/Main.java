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
        Comprador comp1 = new Comprador();
        Moneda m1 = comp1.seleccionarmoneda(1500);
        try {
            exp.comprarProducto(m1, TipoProducto.COCACOLA);
            comp1.recogerProducto(exp);
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        while (comp1.recogerVuelto(exp) != null);

        System.out.println();
        System.out.println(("prueba 2:"));

        exp = new Expendedor(6);
        Comprador comp2 = new Comprador();

        Moneda m2 = comp2.seleccionarmoneda(1500);
        try {
            exp.comprarProducto(m2, TipoProducto.COCACOLA);
            Producto p = comp2.recogerProducto(exp);
            if (p != null) {
                System.out.println("tomaste una: " + p.getSabor());
            }
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        int vueltoRecogido = 0;
        Moneda monedaVuelto;
        while ((monedaVuelto = comp2.recogerVuelto(exp)) != null) {
            vueltoRecogido += monedaVuelto.getValor();
        }
        System.out.println("Vuelto recogido: " + vueltoRecogido);

        System.out.println();
        System.out.println("prueba 3:");

        try {
            exp.comprarProducto(null, TipoProducto.COCACOLA);
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("prueba 4:");

        Comprador comp4 = new Comprador();
        Moneda m4 = comp4.seleccionarmoneda(100);

        try {
            exp.comprarProducto(m4, TipoProducto.COCACOLA);
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
        while (comp4.recogerVuelto(exp) != null);

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

