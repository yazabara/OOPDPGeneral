package org.zabara.oopdp.services;

import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.exceptions.PersonReaderException;

import java.util.Collection;

/**
 * Created by Yaroslav on 17.02.14.
 */
public interface PersonReader {

	public Person getPerson(String name) throws PersonReaderException;

	public Collection<Person> getAllPersons() throws PersonReaderException;

}
