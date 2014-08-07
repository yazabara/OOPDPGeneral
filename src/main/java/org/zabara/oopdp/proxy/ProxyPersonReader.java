package org.zabara.oopdp.proxy;

import org.zabara.oopdp.abstractfactory.PersonSupportFactory;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.exceptions.PersonReaderException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class ProxyPersonReader implements PersonReader {

	PersonReader reader = null;
	Map<String, Person> cache = new HashMap<String, Person>();
	protected Logger logger = Logger.getLogger(ProxyPersonReader.class.getName());

	public ProxyPersonReader(PersonReader personReader) {
		reader = personReader;
	}

	@Override
	public Person getPerson(String name) throws PersonReaderException {
		if (cache.containsKey(name)) {
			logger.log(Level.INFO, "Person[" + name + "] getted from cache");
			return cache.get(name);
		}
		Person person = reader.getPerson(name);
		cache.put(name, person);
		return person;
	}

	@Override
	public Collection<Person> getAllPersons() throws PersonReaderException {
		//тут не применить кэширование, т.к. неизвестно все ли пользователи в кэше
		return reader.getAllPersons();
	}
}
