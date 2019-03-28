package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int fim= rightIndex;
		
		for(int i = leftIndex ; i < rightIndex ; i++) {
			for(int k = leftIndex ; k < fim ;  k++) {
				if(array[k].compareTo(array[k+1]) > 0) {
					Util.swap(array, k, k + 1);
				}
			}
			fim--;
		}
	}
}
