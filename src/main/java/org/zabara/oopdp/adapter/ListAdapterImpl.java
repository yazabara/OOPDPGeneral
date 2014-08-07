package org.zabara.oopdp.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public class ListAdapterImpl<T> implements ListAdapter<T> {

	private List<T> list = new ArrayList<T>();

	@Override
	public T pop() {
		return list.get(list.size()-1);
	}

	@Override
	public void push(T object) {
		list.add(object);
	}
}
