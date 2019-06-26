package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int result = 0;
		SingleLinkedListNode<T> aux = head;
		
		while(!aux.isNIL()){
			aux = aux.getNext();
			result++;
		}
		
		return result;	
	}

	@Override
	public T search(T element) {
		T result = null;
		SingleLinkedListNode<T> aux = head;
		
		while(!aux.isNIL()) {
			if(aux.getData().equals(element)) {
				result = aux.getData();
				break;
			}else {
				aux = aux.getNext();
			}
		}
		
		return result;		
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.head = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		}else {
			SingleLinkedListNode<T> aux = head;
			while(!aux.isNIL())
				aux = aux.getNext();
			
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL()) {
			if(aux.getData().equals(element)) {
				SingleLinkedListNode<T> nextAux = aux.getNext();
				aux.setData(nextAux.getData());
				aux.setNext(nextAux.getNext());
				break;
			}
			
			aux = aux.getNext();
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = head;
		int cont = 0;
		
		while(!aux.isNIL()) {
			result[cont++] = aux.getData();
			aux = aux.getNext();
		}
		
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
