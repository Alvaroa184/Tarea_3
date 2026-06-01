package org.example;

/**
 * Subclase que representa una moneda con un valor de 1000.
 */
public class Moneda1000 extends Moneda {

    /**
     * Constructor que inicializa una moneda de 1000 llamando al constructor de la clase padre
     * para que se le asigne su número de serie correspondiente.
     */
    public Moneda1000() {
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor numérico entero 1000.
     */
    public int getValor() {
        return 1000;
    }
}