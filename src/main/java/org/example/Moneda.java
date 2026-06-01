package org.example;

/**
 * Clase abstracta que define el comportamiento básico de una moneda.
 * Implementa la interfaz Comparable para permitir el ordenamiento automático basado en su valor.
 */
abstract class Moneda implements Comparable<Moneda> {
    private static int registro = 1000;
    private int serie;

    /**
     * Constructor base de Moneda que asigna un número de serie único,
     * utilizando un registro estático compartido.
     */
    public Moneda() {
        this.serie=registro++;
    }

    /**
     * Obtiene el identificador único de la moneda.
     * @return El numero de serie de la moneda.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor de la moneda.
     */
    public abstract int getValor();

    /**
     * Compara el valor de esta moneda con otra proporcionada para determinar su orden.
     * @param otra La moneda con la que se comparara.
     * @return Un valor negativo si esta moneda es menor, cero si son iguales, o un valor positivo si es mayor.
     */
    @Override
    public int compareTo(Moneda otra) {
        return this.getValor() - otra.getValor();
    }

    /**
     * Representa en texto la serie y valor de la moneda.
     * @return Un String que contiene el número de serie y el valor de la moneda.
     */
    @Override
    public String toString() {
        return "Moneda[serie=" + getSerie() + ", valor=" + getValor() + "]";
    }
}