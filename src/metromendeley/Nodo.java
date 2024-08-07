/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

/**
 * Clase que representa un nodo en una estructura de datos enlazada.
 * 
 * @param <E> el tipo de elemento almacenado en el nodo
 * 
 * @autor VivianaPetit
 */
public class Nodo<E> {
    private E valor;
    private Nodo siguiente;
    
    /**
     * Constructor de la clase Nodo.
     * 
     * @param valor informaci&oacute;n para crear el nodo.
     */
    public Nodo (E valor){
        this.siguiente=null;
        this.valor=valor;
    }
    
    /**
     * Obtener el contenido de un nodo.
     * @return el contenido del nodo. 
     */
    public E getValor() {
        return valor;
    }
    /**
     * Obtener el apuntador al nodo siguiente.
     * @return el apuntador al nodo siguiente.
     */
    public Nodo<E> getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establecer el contenido de un nodo.
     * @param valor contenido del nodo.
     */
    public void setValor(E valor) {
        this.valor = valor;
    }
    
    /**
     * Establecer el apuntador al nodo siguiente.
     * @param siguiente apuntador al nodo siguiente.
     */
    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
    
}
