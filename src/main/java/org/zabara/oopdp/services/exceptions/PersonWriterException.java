package org.zabara.oopdp.services.exceptions;

/**
 * Created by Yaroslav_Zabara on 2/18/14.
 */
public class PersonWriterException extends Exception {

	public PersonWriterException(String message) {
		super(message);
	}

	public PersonWriterException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
