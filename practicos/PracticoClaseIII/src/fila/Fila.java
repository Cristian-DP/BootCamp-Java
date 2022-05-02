package fila;

import stack.Node;

public class Fila<T> {

	/* inner class */
	public class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node (T data) {
			this.data = data;
			this.next = null;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public T getData () {
			return this.data;
		}
	}
	
	private Node<T> head;
	
	public Fila () {
		this.head = null;
	}
	
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null){
			head = node;
		}else {
			Node<T> ptro = head;
			
			while (ptro.getNext() != null)
				ptro = ptro.getNext();
			
			ptro.setNext(node);
		}
	}
	
	public void remove (Integer i) {
		Node<T> node;
		
		if ((node = ir(i-1)) == null)
			return;
		
		node.setNext(node.getNext().getNext());
		
	}
	
	public Integer size () {
		return size (head);
	}
	
	public Node<T> ir(Integer i){
		if ( i >= size() || i < 0)
			return null;
		
		Node<T> n = head;
		for (Integer j = 1; j < i; j++)
			n = n.getNext();
		
		return n;
	}
	
	private Integer size(Node<T> n) {
		if (n == null )
			return 0;
		
		return 1 + size (n.getNext());
	}
	
	public boolean isEmpty () {
		if (head == null)
			return true;
		return false;
	}
	
	public void printFila() {
		if (isEmpty())
			return;
		
		Node<T> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.getData().toString());
			ptr = ptr.getNext();
		}
	}
	
}
