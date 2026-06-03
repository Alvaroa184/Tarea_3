package org.example;

/**
 * Clase abstracta que define la estructura básica de cualquier producto.
 */
public abstract class Producto {

    private TipoProducto tipo;

    /**
     * Constructor que define el tipo de producto.
     * @param tipo El identificador del tipo de producto y su precio.
     */
    public Producto(TipoProducto tipo) {
        this.tipo = tipo;
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
}