package org.example;

/**
 * Subclase abstracta que representa los productos de tipo bebida.
 */
public abstract class Bebida extends Producto {

    /**
     * @param tipo El tipo de bebida específico.
     */
    public Bebida(TipoProducto tipo) {
        super(tipo);
    }

    /**
     * Implementación que retorna el nombre de la bebida.
     * @return El nombre del tipo de producto como String.
     */
    public String getSabor() {
        return getTipo().name();
    }
}