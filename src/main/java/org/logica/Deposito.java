package org.logica;

import java.util.ArrayList;

/**
 * Clase genérica que representa un depósito para almacenar objetos de cualquier tipo.
 * @param <T> El tipo de objetos que se guardarán en este depósito.
 */
public class Deposito<T> {
    private ArrayList<T> lista;

    /**
     * Crea un depósito vacío.
     */
    public Deposito() {
        lista = new ArrayList<T>();
    }

    /**
     * Agrega un elemento al final de la lista del depósito.
     * @param elemento El objeto que se quiere almacenar.
     */
    public void add(T elemento) {
        lista.add(elemento);
    }

    /**
     * Retira el primer elemento almacenado en el depósito.
     * @return El primer objeto disponible, o null si el depósito está vacío.
     */
    public T get() {
        if (lista.size() != 0) {
            return lista.remove(0);
        } else {
            return null;
        }
    }

    public T remove(int i) {
        if (i>=0 && i<lista.size()) {
            return lista.remove(i);
        } else {
            return null;
        }
    }

    public int size(){
        return lista.size();
    }
    public T getElemento(int i){
        return lista.get(i);
    }

}