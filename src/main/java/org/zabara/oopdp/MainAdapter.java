package org.zabara.oopdp;

import org.zabara.oopdp.adapter.ListAdapter;
import org.zabara.oopdp.adapter.ListAdapterImpl;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public class MainAdapter {

	public static void main(String[] args) {
		ListAdapter<String> adapter = new ListAdapterImpl<String>();
		int n = 1000;
		for (int i = 0; i < n; i++) {
			adapter.push("object"+i);
		}

		System.out.println(adapter.pop());
	}
}
