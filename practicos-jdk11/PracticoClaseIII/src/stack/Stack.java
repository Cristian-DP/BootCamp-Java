package stack;

public class Stack<T> {
	private Node<T> head;
	
	public Stack () {
		this.head = null;
	}
	
	public void push (T data) {
		Node<T> node = new Node<T>(data);
		
		if (head == null)
			head = node;
		else {
			node.setNext(head);
			head = node;
		}
	}
	
	public void pop () {
		if (isEmpty())
			head = null;
		else
			head = head.getNext();
	}
	
	public boolean isEmpty () {
		if (head == null)
			return true;
		
		return false;
	}
	
	public void printStack () {
		if (isEmpty())
			return;
		
		Node<T> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.getData().toString());
			ptr = ptr.getNext();
		}
	}
}
