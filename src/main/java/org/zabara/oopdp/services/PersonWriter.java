package org.zabara.oopdp.services;

import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.exceptions.PersonWriterException;

/**
 * Created by Yaroslav on 17.02.14.
 */
public interface PersonWriter {

	public void removePerson(String name)  throws PersonWriterException;

	public void addPerson(Person newPerson) throws PersonWriterException;

	public void editPerson(Person oldPerson, Person newPerson) throws PersonWriterException;

	public void editPerson(String oldPersonName, Person newPerson) throws PersonWriterException;
}
