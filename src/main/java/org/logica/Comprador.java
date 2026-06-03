package org.example;

/**
 * Simula a un cliente interactuando con la máquina expendedora, ademas de guardar el valor del vuelto.
 */
class Comprador {
    private int vuelto;
    private String sonido;

    /**
     * Intenta realizar una compra en el expendedor indicado.
     * @param m Moneda que usara para pagar.
     * @param tipo El producto seleccionado.
     * @param exp La maquina expendedora en la cual se realizara la operacion.
     * @throws PagoIncorrectoException Si la moneda entregada es null (No ingreso ninguna).
     * @throws PagoInsuficienteException Si no hay stock disponible.
     * @throws NoHayProductoException Si el valor de la moneda no alcanza a pagar el valor del producto.
     */
    public Comprador(Moneda m, TipoProducto tipo, Expendedor exp)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        Producto p = exp.comprarProducto(m, tipo);

        if (p != null) {
            sonido = p.getSabor();
        }

        Moneda vueltomoneda;
        while ((vueltomoneda = exp.getVuelto()) != null) {
            vuelto += vueltomoneda.getValor();
        }
    }

    /**
     * Obtiene la cantidad que el comprador recibio de vuelto.
     * @return El vuelto total.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /** Registra el sabor.
     * @return El sabor de lo consumido.
     */
    public String queBebiste() {
        return sonido;
    }
}
