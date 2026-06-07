package org.logica;

/**
 * Define los productos disponibles en la máquina y sus respectivos precios.
 */
public enum TipoProducto {
    COCACOLA(1400) {
        @Override
        public Producto crearProducto() {
            return new CocaCola();
        }
    },
    SPRITE(900) {
        @Override
        public Producto crearProducto() {
            return new Sprite();
        }
    },
    FANTA(1000) {
        @Override
        public Producto crearProducto() {
            return new Fanta();
        }
    },
    SNICKERS(1200) {
        @Override
        public Producto crearProducto() {
            return new Snickers();
        }
    },
    SUPER8(700) {
        @Override
        public Producto crearProducto() {
            return new Super8();
        }
    };

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

    public abstract Producto crearProducto();
}
