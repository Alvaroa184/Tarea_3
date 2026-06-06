package org.logica;

/**
 * Simula a un cliente interactuando con la máquina expendedora, ademas de guardar el valor del vuelto.
 */
public class Comprador {
    private Deposito<Moneda> monedero;
    private Deposito<Producto> inventario;
    private String sonido;

    public Comprador(){
        monedero = new Deposito<>();
        inventario = new Deposito<>();

        monedero.add(new Moneda1500());
        monedero.add(new Moneda1000());
        monedero.add(new Moneda500());
        monedero.add(new Moneda500());
        monedero.add(new Moneda100());
        monedero.add(new Moneda100());
        monedero.add(new Moneda100());
    }

    public Moneda seleccionarmoneda(int valor) {
        for (int i = 0; i<monedero.size(); i++) {
            if (monedero.getElemento(i).getValor()==valor) {
                return monedero.remove(i);
            }
        }
        return null;
    }

    public Moneda recogerVuelto(Expendedor exp){
        Moneda m = exp.getVuelto();
        if (m!=null) {
            if (m!=null) {
                monedero.add(m);
            }
        }
        return m;
    }

    public Producto recogerProducto(Expendedor exp) {
        Producto p = exp.getProducto();
        if (p != null) {
            inventario.add(p);
        }
        return p;
    }

    public int totalMonedero() {
        int total = 0;
        for (int i = 0; i<monedero.size(); i++) {
            total+=monedero.getElemento(i).getValor();
        }
        return total;
    }

    public String queBebiste() {
        return sonido; //
    }

}
