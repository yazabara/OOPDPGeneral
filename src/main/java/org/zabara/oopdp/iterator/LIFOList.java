package org.zabara.oopdp.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class LIFOList<E> extends ArrayList<E> {

	@Override
	public Iterator<E> iterator() {
		return new LIFOIterator<E>(this);
	}
}
