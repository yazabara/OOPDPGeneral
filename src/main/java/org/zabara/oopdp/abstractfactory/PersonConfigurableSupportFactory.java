package org.zabara.oopdp.abstractfactory;

import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Created by Yaroslav_Zabara on 2/18/14.
 */
public class PersonConfigurableSupportFactory extends PersonSupportFactory {

	private Properties properties = new Properties();
	public final static String configFileName = "src\\main\\resources\\app-conf.properties";
	private final static String NOT_FOUND = " not found";

	private static PersonConfigurableSupportFactory instance = null;

	protected enum ConfigNames {

		PERSON_READER("personReader.class"),
		PERSON_WRITER("personWriter.class");

		String name;

		ConfigNames(String name){
			this.name = name;
		}

		@Override
		public String toString() {
			return "ConfigNames{" +
					"name='" + name + '\'' +
					'}';
		}
	}

	public static PersonConfigurableSupportFactory getInstance() throws PersonFactoryException{
		if (instance == null) {
			instance = new PersonConfigurableSupportFactory(configFileName);
		}
		return instance;
	}

	private PersonConfigurableSupportFactory(String configFilePath) throws PersonFactoryException {
		//reed configs
		try {
			FileInputStream fileInputStream = new FileInputStream(configFilePath);
			properties.load(fileInputStream);
			logger.log(Level.CONFIG, "config properties are filled in correctly");
		} catch (IOException ex) {
			logger.log(Level.SEVERE, "config properties are not filled in correctly " + ex);
			throw new PersonFactoryException("Error while reading [" + configFilePath + "] file ", ex);
		}
		logger.info(PersonConfigurableSupportFactory.class.getName() + " initialized");
	}

	@Override
	public PersonReader getPersonReader() throws PersonFactoryException{
		PersonReader reader = null;
		try {
			reader = (PersonReader) Class.forName(properties.getProperty(ConfigNames.PERSON_READER.name)).newInstance();
		} catch (Exception ex) {
			logger.log(Level.WARNING, ConfigNames.PERSON_READER.name + PersonConfigurableSupportFactory.NOT_FOUND);
			throw new PersonFactoryException(ConfigNames.PERSON_READER.name + PersonConfigurableSupportFactory.NOT_FOUND, ex);
		}
		return reader;
	}

	@Override
	public PersonWriter getPersonWriter() throws PersonFactoryException {
		PersonWriter writer = null;
		try {
			writer = (PersonWriter) Class.forName(properties.getProperty(ConfigNames.PERSON_WRITER.name)).newInstance();
		} catch (Exception ex) {
			logger.log(Level.WARNING, ConfigNames.PERSON_WRITER.name + PersonConfigurableSupportFactory.NOT_FOUND);
			throw new PersonFactoryException(ConfigNames.PERSON_WRITER.name + PersonConfigurableSupportFactory.NOT_FOUND, ex);
		}
		return writer;
	}
}
