package org.zabara.oopdp.domain;

import java.util.Comparator;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public class PersonIqComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getIq() - o2.getIq();
	}
}
