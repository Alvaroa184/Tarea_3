package org.logica;

/**
 * Subclase abstracta que representa los productos de tipo dulce.
 */
public abstract class Dulce extends Producto {

    /**
     * @param tipo El tipo del dulce específico.
     */
    public Dulce(TipoProducto tipo) {
        super(tipo);
    }

    /**
     * Implementación que retorna el nombre del dulce.
     * @return El nombre del tipo de producto como String.
     */
    public String getSabor() {
        return getTipo().name();
    }
}