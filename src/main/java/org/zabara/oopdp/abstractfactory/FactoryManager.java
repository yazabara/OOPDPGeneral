package org.zabara.oopdp.abstractfactory;

import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class FactoryManager {

	public enum FactiryType {
		DB,FILE,CONFIG
	}

	public static PersonSupportFactory getFactory(FactoryManager.FactiryType factiryType)throws PersonFactoryException{
		switch (factiryType) {
			case  CONFIG:
				return PersonConfigurableSupportFactory.getInstance();
			case FILE:
				return PersonFileSupportFactory.getInstance();
			case DB:
				return PersonDBSupportFactory.getInstance();
			default:
				return PersonDBSupportFactory.getInstance();
		}
	}
}
