package org.zabara.oopdp.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class LIFOIterator<E> implements Iterator<E> {

	List<E> list = Collections.EMPTY_LIST;
	int currentPosition = 0;

	public LIFOIterator(List<E> list1) {
		list = list1;
		currentPosition = list.size() - 1;
	}

	@Override
	public boolean hasNext() {
		return currentPosition >= 0;
	}

	@Override
	public E next() {
		if (hasNext()) {
			return list.get(currentPosition--);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		if (currentPosition < 0) {
			return;
		}
		list.remove(currentPosition);
		currentPosition = currentPosition - 1;
	}
}
