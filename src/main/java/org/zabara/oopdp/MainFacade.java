package org.zabara.oopdp;

import org.zabara.oopdp.abstractfactory.FactoryManager;
import org.zabara.oopdp.abstractfactory.PersonDBSupportFactory;
import org.zabara.oopdp.abstractfactory.PersonSupportFactory;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.facade.PersonFacade;
import org.zabara.oopdp.facade.PersonFacadeImpl;

/**
 * Created by Yaroslav_Zabara on 3/19/14.
 */
public class MainFacade {

	public static void main(String[] args) {
		//выбор фабрики
		PersonSupportFactory factory = null;
		try {
			factory = FactoryManager.getFactory(FactoryManager.FactiryType.DB);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//клиенту передаем уже инстанс
		try {
			SomeClient someClient = new SomeClient(factory);
			someClient.writePerson(new Person("IqPerson1", 20, 123));
			someClient.writePerson(new Person("IqPerson2", 20, 153));
			Person iqPerson1 = someClient.readPerson("IqPerson1");
			Person iqPerson2 = someClient.readPerson("IqPerson2");
			PersonFacade facade = new PersonFacadeImpl(someClient);
			System.out.println("smarter is " + facade.getSmarter(iqPerson1, iqPerson2));
			facade.copyIq(iqPerson1, iqPerson2);
			System.out.println("copy iq " + iqPerson2);
			facade.incrementIq(iqPerson2);
			System.out.println("increment iq " + iqPerson2);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
