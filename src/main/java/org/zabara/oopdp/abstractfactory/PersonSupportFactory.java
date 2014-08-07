package org.zabara.oopdp.abstractfactory;

import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;

import java.util.logging.Logger;

/**
 * Created by Yaroslav on 17.02.14.
 */
public abstract class PersonSupportFactory {

	protected Logger logger = Logger.getLogger(PersonSupportFactory.class.getName());

    public abstract PersonReader getPersonReader() throws PersonFactoryException;

    public abstract PersonWriter getPersonWriter() throws PersonFactoryException;
}
