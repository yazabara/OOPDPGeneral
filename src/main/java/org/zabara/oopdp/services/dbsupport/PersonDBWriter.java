package org.zabara.oopdp.services.dbsupport;

import org.zabara.oopdp.dao.DataBaseManager;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.exceptions.PersonWriterException;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonDBWriter implements PersonWriter {

	@Override
	public void removePerson(String name) throws PersonWriterException {
        DataBaseManager.getInstance().removePerson(name);
	}

	@Override
	public void addPerson(Person newPerson) throws PersonWriterException {
        DataBaseManager.getInstance().addPerson(newPerson);
	}

	@Override
	public void editPerson(Person oldPerson, Person newPerson) {
        editPerson(oldPerson.getName(), newPerson);
	}

	@Override
	public void editPerson(String oldPersonName, Person newPerson) {
        DataBaseManager.getInstance().editPerson(oldPersonName, newPerson);
	}
}
