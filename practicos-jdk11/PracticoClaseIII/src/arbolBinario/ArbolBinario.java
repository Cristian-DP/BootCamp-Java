package arbolBinario;

import java.util.Objects;

public class ArbolBinario<T extends Comparable<T>> {
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		private Node<T> izq;
		private Node<T> der;
		private T data;
		
		public Node (T data){
			this.izq = this.der = null;
			this.data = data;
		}
		
		public Node<T> getIzq (){
			return izq;
		}
		
		public Node<T> getDer (){
			return der;
		}
		
		public void setDer (Node<T> n) {
			this.der = n;
		}

		public void setIzq (Node<T> n) {
			this.izq = n;
		}
		
		public T getData (){
			return data;
		}
		
	}
	
	private Node<T> raiz;
	
	public ArbolBinario () {
		this.raiz = null;
	}
	
	public ArbolBinario (Node<T> node) {
		this.raiz = node;
	}
	
	public void agregarNodo (T data) {
		if (Objects.isNull(this.raiz))
			this.raiz = new Node<T>(data);
		else
			this.add (this.raiz, data);
	}
	
	private void add(Node<T> n, T data) {
		if (n.getData().compareTo(data) <= 0)
			if (Objects.isNull(n.getDer()))
				n.setDer(new Node<T>(data));
			else
				this.add(n.getDer(), data);
		else
			if (Objects.isNull(n.getIzq()))
				n.setIzq(new Node<T>(data));
			else
				this.add(n.getIzq(), data);
	}

	public void recorrer (String s) {
		switch (s) {
		case "preOrden":
			this.preOrden(this.raiz);			
			break;
		case "postOrden":
			this.postOrden(this.raiz);			
			break;
		case "inOrden":
			this.inOrden(this.raiz);			
			break;

		default:
			System.out.println("Not found");
			break;
		}
	}
	
	/* izq, raiz, der*/
	public void inOrden (Node<T> node) {
		if (!Objects.isNull(node)) {
			this.inOrden(node.getIzq());
			System.out.println(node.getData().toString());
			this.inOrden(node.getDer());
		}
	}
	
	/* raiz, izq, derecha */
	public void preOrden (Node<T> node) {
		
		if (!Objects.isNull(node)) {
			System.out.println(node.getData().toString());
			preOrden(node.getIzq());
			preOrden(node.getDer());
		}
	}
	
	/* izq, der, raiz*/
	public void postOrden (Node<T> node) {
		if (!Objects.isNull(node)) {
			postOrden(node.getIzq());
			postOrden(node.getDer());
			System.out.println(node.getData().toString());
		}
	}

}

