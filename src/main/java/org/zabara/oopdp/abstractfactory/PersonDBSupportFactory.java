package org.zabara.oopdp.abstractfactory;

import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.dbsupport.PersonDBReader;
import org.zabara.oopdp.services.dbsupport.PersonDBWriter;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonDBSupportFactory extends PersonSupportFactory {

	private static PersonDBSupportFactory instance = null;

	static {
		instance = new PersonDBSupportFactory();
	}

	public static PersonDBSupportFactory getInstance(){
		if (instance == null) {
			instance = new PersonDBSupportFactory();
		}
		return instance;
	}

    private PersonDBSupportFactory(){
		logger.info(PersonDBSupportFactory.class.getName() + " initialized");
    }

    @Override
    public PersonReader getPersonReader() {
       return new PersonDBReader();
    }

    @Override
    public PersonWriter getPersonWriter() {
        return new PersonDBWriter();
    }
}
