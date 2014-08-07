package org.zabara.oopdp;

import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.iterator.LIFOIterator;
import org.zabara.oopdp.iterator.LIFOList;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class MainLIFO {

	public static void main(String[] args) {
		List<String> list = new LIFOList<String>();

		for (int i = 0; i < 100; i++) {
			list.add("qwe" + i);
		}

		for (String iterator : list) {
			System.out.println(iterator);
		}

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}

		System.out.println("size is " + list.size());

	}
}
