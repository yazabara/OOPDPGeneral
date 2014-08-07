package org.zabara.oopdp;

import org.zabara.oopdp.abstractfactory.FactoryManager;
import org.zabara.oopdp.abstractfactory.PersonSupportFactory;
import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.proxy.ProxyPersonReader;
import org.zabara.oopdp.services.PersonReader;
import org.zabara.oopdp.services.PersonWriter;
import org.zabara.oopdp.services.filesupport.PersonFileWriter;

/**
 * Created by Yaroslav_Zabara on 3/21/14.
 */
public class MainProxy {

	public static void main(String[] args) {
		try {
			PersonSupportFactory factory = FactoryManager.getFactory(FactoryManager.FactiryType.DB);
			PersonWriter writer = factory.getPersonWriter();

			for (int i = 0; i < 100; i++) {
				writer.addPerson(new Person("qwe" + i, i));
			}

			PersonReader reader = makeProxyObject(factory.getPersonReader());

			reader.getPerson("qwe1");
			reader.getPerson("qwe1");
			reader.getPerson("qwe1");
			reader.getPerson("qwe1");

			//clearing
			for (int i = 0; i < 100; i++) {
				writer.removePerson("qwe" + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PersonReader makeProxyObject(PersonReader reader) {
		return new ProxyPersonReader(reader);
	}
}
