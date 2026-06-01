package org.example;

/**
 * Excepción lanzada cuando el pago ingresado es menor al valor del producto.
 */
public class PagoInsuficienteException extends Exception {

    /**
     * Constructor que permite definir el mensaje de error de la excepción.
     * @param mensaje Descripcion del error
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}