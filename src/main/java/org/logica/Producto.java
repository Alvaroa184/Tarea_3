package org.logica;

/**
 * Clase abstracta que define la estructura básica de cualquier producto.
 */
public abstract class Producto {
    private static int registro= 2000;
    private int serie;
    private TipoProducto tipo;

    private int x;
    private int y;

    /**
     * Constructor que define el tipo de producto.
     * @param tipo El identificador del tipo de producto y su precio.
     */
    public Producto(TipoProducto tipo) {
        this.tipo = tipo;
        this.serie = registro++;
    }
    public int getSerie() {
        return serie;
    }
    /**
     * Método abstracto que tiene que ser implementado para devolver el nombre del sabor.
     * @return Un string con el nombre del producto.
     */
    public abstract String getSabor();

    /**
     * @return El valor del producto segun su tipo.
     */
    public int getPrecio() {
        return tipo.getPrecio();
    }

    /**
     * @return El tipo de producto que define su nombre y precio base.
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}