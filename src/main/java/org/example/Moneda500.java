package org.example;

/**
 * Subclase que representa una moneda con un valor de 500.
 */
public class Moneda500 extends Moneda {

    /**
     * Constructor que inicializa una moneda de 500 llamando al constructor de la clase padre
     * para que se le asigne su número de serie correspondiente.
     */
    public Moneda500() {
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor numérico entero 500.

     */
    public int getValor() {
        return 500;
    }
}