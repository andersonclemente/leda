package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		head = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) head, new DoubleLinkedListNode<>());
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			head = head.getNext();
			if(head.isNIL()) {
				((DoubleLinkedListNode<T>)head).setPrevious(null);
				last = (DoubleLinkedListNode<T>) head;
			}else{
				((DoubleLinkedListNode<T>)head).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			last = last.getPrevious();
			if(last.isNIL()) {
				last.setPrevious(null);
				head = last;
			}else{
				last.setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.head = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
			this.last = (DoubleLinkedListNode<T>) head;
		}else {
			DoubleLinkedListNode<T> prev = ((DoubleLinkedListNode<T>) head).getPrevious();
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head;
			
			while(!aux.isNIL()) {
				prev = aux;
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
			aux.setPrevious(prev);
			last = aux;
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

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
