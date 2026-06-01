package org.example;

/**
 * Molde de una maquina expendedora que guarda productos en depositos.
 * Procesa el pago y vuelto de cada venta.
 */
class Expendedor {

    private Deposito<Producto> depositoCoca;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;
    private Deposito<Moneda> depositoVuelto;

    /**
     * Crea un expendedor con una cantidad inicial de productos en cada deposito.
     * @param numProductos La cantidad inicial que tendra cada deposito.
     */
    public Expendedor(int numProductos) {
        depositoCoca = new Deposito<>();
        depositoSprite = new Deposito<>();
        depositoFanta = new Deposito<>();
        depositoSnickers = new Deposito<>();
        depositoSuper8 = new Deposito<>();
        depositoVuelto = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            depositoCoca.add(new CocaCola());
            depositoSprite.add((new Sprite()));
            depositoFanta.add(new Fanta());
            depositoSnickers.add(new Snickers());
            depositoSuper8.add(new Super8());
        }

    }

    /**
     * Realiza la logica de compra: valida el pago, verifica stock y calcula el vuelto.
     * @param moneda La moneda ulizada para pagar.
     * @param tipo El producto seleccionado.
     * @return El producto seleccionado si la operacion fue exitosa.
     * @throws PagoIncorrectoException Si la moneda entregada es null (No ingreso ninguna).
     * @throws NoHayProductoException Si no hay stock disponible.
     * @throws PagoInsuficienteException Si el valor de la moneda no alcanza a pagar el valor del producto.
     */
    public Producto comprarProducto(Moneda moneda, TipoProducto tipo)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {


        int precio = tipo.getPrecio();

        if (moneda==null){
            throw new PagoIncorrectoException ("No hay monedas");
        }
        if (moneda.getValor()<precio){
            depositoVuelto.add(moneda);
            throw new PagoInsuficienteException("No hay suficiente dinero");
        }
        Producto producto=null;
        if (tipo==TipoProducto.COCACOLA){
            producto = depositoCoca.get();
        }
        else if (tipo==TipoProducto.SPRITE){
            producto = depositoSprite.get();
        }
        else if (tipo==TipoProducto.SNICKERS){
            producto = depositoSnickers.get();
        }
        else if (tipo==TipoProducto.SUPER8){
            producto = depositoSuper8.get();
        }
        else if (tipo== TipoProducto.FANTA){
            producto = depositoFanta.get();
        }
        if (producto==null){
            depositoVuelto.add(moneda);
            throw new NoHayProductoException("No hay producto actualmente");
        }

        int diferencia = moneda.getValor() - precio;
        while (diferencia >= 100) {
            depositoVuelto.add(new Moneda100());
            diferencia -= 100;
        }

        return producto;
    }

    /**
     * Saca de a una moneda de 100 del deposito de vuelto.
     * @return Una moneda de 100 si quedara en el deposito de vuelto.
     */
    public Moneda getVuelto() {
        return depositoVuelto.get();
    }
}