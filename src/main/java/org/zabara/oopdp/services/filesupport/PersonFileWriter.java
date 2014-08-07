package org.zabara.oopdp.services.filesupport;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.exceptions.PersonWriterException;

import javax.validation.Path;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class PersonFileWriter extends PersonFileSupport implements PersonWriter {

    public enum PersonProperties {

        NAME("person.name"),
		IQ("person.iq"),
        AGE("person.age");

        private String desc;

        PersonProperties(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

	public PersonFileWriter() {
		directoryPath = PersonFileSupport.DEFAULT_DIRECTORY;
	}

	public PersonFileWriter(String personDirectoryPath) {
		directoryPath = personDirectoryPath;
	}

	@Override
	public void removePerson(String name) {
		File file = new File(directoryPath + "//" + name + ".txt");
		if (file.exists() && !file.isDirectory()) {
			//file.delete();
			FileSystemUtils.deleteRecursively(file);
			logger.log(Level.INFO, "Person " + name + " deleted");
		}
	}

	@Override
	public void addPerson(Person newPerson) throws PersonWriterException {
		File directory = new File(directoryPath);
		if (!directory.exists() || !directory.isDirectory()) {
			directory.mkdir();
		}
		File file = new File(directoryPath + "//" + newPerson.getName() + ".txt");
		if (file.exists() && !file.isDirectory()) {
			logger.log(Level.SEVERE, "Person already exist");
			throw new PersonWriterException("Person already exist");
		}
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(writer);
			out.write(PersonFileWriter.PersonProperties.NAME.getDesc() + " : " + newPerson.getName() + "\n");
			out.write(PersonFileWriter.PersonProperties.IQ.getDesc() + " : " + newPerson.getIq() + "\n");
			out.write(PersonFileWriter.PersonProperties.AGE.getDesc() + " : " + newPerson.getAge());
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot create new person ", e);
			throw new PersonWriterException("Cannot create new person ", e);
		}
	}

	@Override
	public void editPerson(Person oldPerson, Person newPerson) throws PersonWriterException {
		editPerson(oldPerson.getName(), newPerson);
	}

	@Override
	public void editPerson(String oldPersonName, Person newPerson) throws PersonWriterException {
		//simple implementing - delete old file and create new file
		removePerson(oldPersonName);
		addPerson(newPerson);
	}
}
