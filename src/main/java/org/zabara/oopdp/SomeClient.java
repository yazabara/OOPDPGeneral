package org.zabara.oopdp;

import org.zabara.oopdp.abstractfactory.PersonSupportFactory;
import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.exceptions.PersonReaderException;
import org.zabara.oopdp.services.exceptions.PersonWriterException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class SomeClient {

    protected Logger logger = Logger.getLogger(SomeClient.class.getName());
	private PersonWriter personWriter = null;
    private PersonReader personReader = null;
    private PersonSupportFactory factory = null;

	public SomeClient(PersonSupportFactory factory)throws PersonFactoryException{
        this.factory = factory;
        try {
            this.personWriter = factory.getPersonWriter();
            this.personReader = factory.getPersonReader();
        }catch (PersonFactoryException ex) {
            logger.log(Level.SEVERE, String.valueOf(ex));
            throw new PersonFactoryException(SomeClient.class.getName() + " initialization fail. ", ex);
        }
	}

    public void writePerson(Person person) throws PersonWriterException {
		personWriter.addPerson(person);
        logger.log(Level.INFO, "Person " + person.getName() + " was added");
    }

    public Person readPerson(String name)throws PersonReaderException{
        logger.log(Level.INFO, "try to read person " + name);
        return personReader.getPerson(name);
    }

	public void editPerson(Person oldPerson, Person newPerson) throws PersonWriterException {
		personWriter.editPerson(oldPerson, newPerson);
	}

	public void editPerson(String personName, Person newPerson) throws PersonWriterException {
		personWriter.editPerson(personName, newPerson);
	}

	public void removePerson(String name) throws PersonWriterException {
		personWriter.removePerson(name);
	}


}
