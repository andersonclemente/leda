package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		
		SingleLinkedListNode<T> procurado = this.head;
		while(!procurado.isNIL()) {
			 
			SingleLinkedListNode<T> aux = procurado.getNext();
			while(!aux.isNIL()) {
				if(aux.getData().equals(procurado.getData())) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}else{
					aux = aux.getNext();
				}
			}
			
			procurado = procurado.getNext();
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		
		SetLinkedList<T> result = new SetLinkedListImpl<>();
		SingleLinkedListNode<T> aux = this.head;
		
		while(!aux.isNIL()){
			result.insert(aux.getData());
			aux = aux.getNext();
		}
		
		T[] otherSetArray = (T[])otherSet.toArray();
		
		for(int i = 0; i < otherSetArray.length; i++) {
			result.insert(otherSetArray[i]);
		}
		
		this.removeDuplicates();		
		return result;
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
