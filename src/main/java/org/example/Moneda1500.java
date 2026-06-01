package org.example;

/**
 * Subclase que representa una moneda con un valor de 1500.
 */
public class Moneda1500 extends Moneda {

    /**
     * Constructor que inicializa una moneda de 1500 llamando al constructor de la clase padre
     * para que se le asigne su número de serie correspondiente.
     */
    public Moneda1500() {
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor numérico entero 1500.
     */
    public int getValor() {
        return 1500;
    }
}