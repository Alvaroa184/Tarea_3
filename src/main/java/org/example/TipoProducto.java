package org.example;

/**
 * Define los productos disponibles en la máquina y sus respectivos precios.
 */
public enum TipoProducto {
    COCACOLA(1100),
    SPRITE(900),
    FANTA(1000),
    SNICKERS(500),
    SUPER8(300);

    private int precio;

    /**
     * Constructor para asignar el precio a cada tipo de producto.
     * @param precio Valor monetario del producto.
     */
    TipoProducto(int precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el precio asociado al tipo de producto.
     * @return El precio del producto seleccionado.
     */
    public int getPrecio() {
        return precio;
    }
}
