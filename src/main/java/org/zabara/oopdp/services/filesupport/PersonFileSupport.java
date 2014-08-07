package org.zabara.oopdp.services.filesupport;

import java.util.logging.Logger;

/**
 * Created by Yaroslav_Zabara on 2/20/14.
 */
public  abstract class PersonFileSupport {

	protected String directoryPath = "";
	protected Logger logger = Logger.getLogger(PersonFileSupport.class.getName());
	public final static String DEFAULT_DIRECTORY = "persons";

	protected PersonFileSupport() {
		logger.info(PersonFileSupport.class.getName() + " initialized");
	}
}
