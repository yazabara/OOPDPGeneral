package org.zabara.oopdp.adapter;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public interface ListAdapter<T extends Object> {

	public T pop();

	public void push(T object);
}
