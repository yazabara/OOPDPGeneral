package org.zabara.oopdp.abstractfactory.exceptions;

/**
 * Created by Yaroslav_Zabara on 2/18/14.
 */
public class PersonFactoryException extends Exception {

	public PersonFactoryException(String message) {
		super(message);
	}

	public PersonFactoryException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
