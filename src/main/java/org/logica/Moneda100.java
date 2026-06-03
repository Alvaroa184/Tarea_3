package org.logica;

/**
 * Subclase que representa una moneda con un valor de 100.
 */
public class Moneda100 extends Moneda {

    /**
     * Constructor que inicializa una moneda de 100 llamando al constructor de la clase padre
     * para que se le asigne su número de serie correspondiente.
     */
    public Moneda100() {
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor numérico entero 100.
     */
    public int getValor() {
        return 100;
    }
}