package org.example;

/**
 * Excepción lanzada cuando el depósito solicitado no tiene stock disponible.
 */
public class NoHayProductoException extends Exception {

    /**
     * Constructor que permite definir el mensaje de error de la excepción.
     * @param mensaje Descripcion del error.
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}