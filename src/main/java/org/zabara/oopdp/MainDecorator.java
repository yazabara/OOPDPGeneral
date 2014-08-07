package org.zabara.oopdp;

import org.zabara.oopdp.decorator.PersonInputStream;
import org.zabara.oopdp.decorator.PersonInputStreamDecorator;
import org.zabara.oopdp.decorator.PersonOutputStream;
import org.zabara.oopdp.decorator.PersonOutputStreamDecorator;
import org.zabara.oopdp.domain.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class MainDecorator {

	public static void main(String[] args) {
		try {
			PersonOutputStream pos = new PersonOutputStreamDecorator(new PersonOutputStream(new FileOutputStream("decorator.txt")));
			pos.writePerson(new Person("Person", 21));

			PersonInputStream personInputStream = new PersonInputStreamDecorator(new PersonInputStream(new FileInputStream("decorator.txt")));
			System.out.println("person.name: " + personInputStream.readPerson().toString());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
