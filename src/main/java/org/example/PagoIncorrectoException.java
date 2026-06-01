package org.example;

/**
 * Excepción lanzada cuando el pago es null.
 */
public class PagoIncorrectoException extends Exception {

    /**
     * Constructor que permite definir el mensaje de error de la excepción.
     * @param mensaje Descripcion del error.
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}