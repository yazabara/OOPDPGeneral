package org.zabara.oopdp.abstractfactory;

import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.filesupport.PersonFileReader;
import org.zabara.oopdp.services.filesupport.PersonFileSupport;
import org.zabara.oopdp.services.filesupport.PersonFileWriter;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonFileSupportFactory extends PersonSupportFactory {

	private static PersonFileSupportFactory instance = null;
    private String personDirectory = PersonFileSupport.DEFAULT_DIRECTORY;

	static {
		instance = new PersonFileSupportFactory();
	}

    private PersonFileSupportFactory(){
		logger.info(PersonFileSupportFactory.class.getName() + " initialized");
    }

	public static PersonFileSupportFactory getInstance(){
		if (instance == null) {
			instance = new PersonFileSupportFactory();
		}
		return instance;
	}

    @Override
    public PersonReader getPersonReader() {
       return new PersonFileReader(personDirectory);
    }

    @Override
    public PersonWriter getPersonWriter() {
        return new PersonFileWriter(personDirectory);
    }

    public String getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(String personDirectory) {
        this.personDirectory = personDirectory;
    }
}
