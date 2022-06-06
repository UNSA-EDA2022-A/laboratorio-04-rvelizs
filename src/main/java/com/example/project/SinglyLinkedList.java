package com.example.project;

public class SinglyLinkedList<T> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        // * 
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
        Node<T> newNode = new Node<T>(data, null); // NODO QUE INGRESAREMOS
		
		if (isEmpty()) { // SI ESTÁ VACÍA
			first = newNode;
		} else {
			
			if (position == 0) // SI DESEA AGREGAR EN [0] (INICIO DE LA LISTA)
				addFirst(data);
			else if (position < size) { // SI DESEA AGREGAR EN [0 < position < size]
				
				// > PRIMERA ITERACIÓN PARA UNIR newNode CON EL RESTO DE LA LISTA
				// --------------------------------------------------------------------------
				Node<T> cur = first; // NODO RECORRIDO	index = 0
				for (int i = 1; i < position; i++)	// 	index > 0
					cur = cur.getNext();			//	RECORRE NODOS
				newNode.setNext(cur.getNext()); 	//	newNode APUNTA A LOS NODOS EN ADELANTE	
				// --------------------------------------------------------------------------
				

				// > SEGUNDA ITERACIÓN PARA CONECTAR LA PRIMERA PARTE DE LA LISTA CON newNode
				// --------------------------------------------------------------------------
				cur = first; // REINICIO DEL AUXILIAR	index = 0
				for (int i = 1; i < position; i++) 	//	index > 0
					cur = cur.getNext();			//	RECORRE NODOS
				cur.setNext(newNode); 				//	NODO EN POSICIÓN [position - 1] CONECTA CON newNode
				// --------------------------------------------------------------------------
				
				size++; 							// ACTUALIZA EL TAMAÑO DE LA LISTA

			} else if (position == size) // SI DESEA AGREGAR EN [size] (FINAL DE LA LISTA)
				addLast(data);
			else // SI DESEA AGREGAR EN [position > size]
				System.out.println("Fuera de rango.");
		}
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        if (position == 0) // SI DESEA QUITAR [0] (INICIO DE LA LISTA)
			removeFirst();
		
	else if (position < size) { // SI DESEA QUITAR [0 < position < size]
		
		// > ITERACIÓN PARA QUITAR EL NODO DE LA LISTA
		// --------------------------------------------------------------------------
		Node<T> cur = first; // NODO RECORRIDO		index = 0
		for (int i = 1; i < position; i++)		//	index > 0
			cur = cur.getNext();				//	RECORRE NODOS
		cur.setNext(cur.getNext().getNext());	//	NODO EN POSICIÓN [position - 1] CONECTA CON DOS NODOS DESPUÉS
		// --------------------------------------------------------------------------
		
		size--;										// ACTUALIZA EL TAMAÑO DE LA LISTA
	}
	
	else // SI DESEA QUITAR EN [position > size]
		System.out.println("Fuera de rango.");
    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}
