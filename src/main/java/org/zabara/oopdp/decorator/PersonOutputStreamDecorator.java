package org.zabara.oopdp.decorator;

import org.zabara.oopdp.domain.Person;

import java.io.IOException;
import java.io.OutputStream;

public class PersonOutputStreamDecorator extends PersonOutputStream {
	
	public PersonOutputStreamDecorator(OutputStream outputStream) {
		super(outputStream);
	}
	
	@Override
	public void writePerson(Person person) throws IOException {
		if (!Character.isUpperCase(person.getName().charAt(0))) {
			person.setName(Character.toUpperCase(person.getName().charAt(0))
					+ person.getName().substring(1));
		}
		super.writePerson(person);
	}

}
