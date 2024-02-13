package stack_queue;

import java.io.Serializable;

public class LinkedStack<E> implements Stack<E>, Serializable {
	 private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); 
     public LinkedStack( ) { } 
     public int size( ) { 	 return list.size( ); }
     public boolean isEmpty( ) { return list.isEmpty( ); } 
     public void push(E element) { list.addFirst(element);}
     public E top( ) { return list.first( ); } 
     public E pop( ) { return list.removeFirst( ); }
     }


