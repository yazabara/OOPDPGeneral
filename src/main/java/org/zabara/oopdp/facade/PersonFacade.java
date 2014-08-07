package org.zabara.oopdp.facade;

import org.zabara.oopdp.domain.Person;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public interface PersonFacade {

	public Person getSmarter(Person p1, Person p2);

	public void incrementIq(Person person);

	public void copyIq(Person from, Person to);
}
