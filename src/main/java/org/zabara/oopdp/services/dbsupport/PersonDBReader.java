package org.zabara.oopdp.services.dbsupport;

import org.zabara.oopdp.dao.DataBaseManager;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.exceptions.PersonReaderException;

import java.util.Collection;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonDBReader implements PersonReader {

    @Override
    public Person getPerson(String name) throws PersonReaderException {
        try {
            return DataBaseManager.getInstance().likeName(name).iterator().next();
        } catch (Exception ex) {
            throw new PersonReaderException("Cannot get person", ex);
        }
    }

    @Override
    public Collection<Person> getAllPersons() {
        return DataBaseManager.getInstance().getPersons();
    }
}
