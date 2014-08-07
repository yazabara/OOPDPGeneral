package org.zabara.oopdp.facade;

import org.zabara.oopdp.SomeClient;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.domain.PersonIqComparator;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public class PersonFacadeImpl implements PersonFacade {

	private SomeClient client = null;

	public PersonFacadeImpl(SomeClient client) {
		this.client = client;
	}

	@Override
	public Person getSmarter(Person p1, Person p2) throws IllegalArgumentException {
		if (p1 == null || p2 == null) {
			throw new IllegalArgumentException("some person is null");
		}
		if (new PersonIqComparator().compare(p1, p2) > 0) {
			return p1;
		}
		return p2;
	}

	@Override
	public void incrementIq(Person person) throws IllegalArgumentException {
		if (person == null) {
			throw new IllegalArgumentException("person is null");
		}
		person.setIq(person.getIq() + 1);
		//store the changes
		storeChanges(person);
	}

	@Override
	public void copyIq(Person from, Person to) {
		if (from == null || to == null) {
			throw new IllegalArgumentException("some person is null");
		}
		to.setIq(from.getIq());
		//store the changes
		storeChanges(to);
	}

	private void storeChanges(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("person is null");
		}
		try {
			client.editPerson(person.getName(), person);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
