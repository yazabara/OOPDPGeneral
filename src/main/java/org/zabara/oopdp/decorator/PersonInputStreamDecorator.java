package org.zabara.oopdp.decorator;

import org.zabara.oopdp.domain.Person;

import java.io.IOException;
import java.io.InputStream;

public class PersonInputStreamDecorator extends PersonInputStream {

	public PersonInputStreamDecorator(InputStream inputStream) {
		super(inputStream);
	}
	
	@Override
	public Person readPerson() throws ClassNotFoundException, IOException {
		Person person = super.readPerson();
		if (!Character.isLowerCase(person.getName().charAt(0))) {
			person.setName(Character.toLowerCase(person.getName().charAt(0))
					+ person.getName().substring(1));
		}	
		
		return person;	
	}

}
