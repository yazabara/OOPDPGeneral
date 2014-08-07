package org.zabara.oopdp.services.filesupport;

import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.exceptions.PersonReaderException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonFileReader extends PersonFileSupport implements PersonReader {

	public PersonFileReader() {
		directoryPath = PersonFileSupport.DEFAULT_DIRECTORY;
	}

	public PersonFileReader(String personDirectoryPath) {
		directoryPath = personDirectoryPath;
	}

	@Override
	public Person getPerson(String name) throws PersonReaderException {
		try {
			Reader reader = new FileReader(new File(directoryPath + "/" + name + ".txt"));
			BufferedReader bufferedReader = new BufferedReader(reader);
			List<List<Integer>> classicMap = new ArrayList<List<Integer>>();

			String line = bufferedReader.readLine();
			String personName = readLine(line, "person.name : ");
			line = bufferedReader.readLine();
			int iq = Integer.parseInt(readLine(line, "person.iq : "));
			line = bufferedReader.readLine();
			int age = Integer.parseInt(readLine(line, "person.age : "));

			//если не закрыть будет беда=) можно попробовать для теста))
			bufferedReader.close();
			reader.close();

			return new Person(personName, age, iq);

		} catch (Exception ex) {
			throw new PersonReaderException(ex.getMessage(), ex);
		}
	}

	private String readLine(String line, String pattern) {
		if (line != null) {
			return line.replaceAll(pattern, "").trim();
		}
		return new String();
	}

	@Override
	public Collection<Person> getAllPersons() {
//		todo потом сделаю
		return Collections.EMPTY_LIST;
	}
}
