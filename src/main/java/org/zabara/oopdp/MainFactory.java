package org.zabara.oopdp;

import org.zabara.oopdp.abstractfactory.*;
import org.zabara.oopdp.abstractfactory.exceptions.PersonFactoryException;
import org.zabara.oopdp.domain.Person;
import org.zabara.oopdp.services.exceptions.PersonReaderException;
import org.zabara.oopdp.services.exceptions.PersonWriterException;

/**
 * Created by Yaroslav on 17.02.14.
 */
public class MainFactory {

	public static void main(String[] args) {

		//выбор фабрики (можно вынести в отдельную задачу(к примеру DI), но никак не связана с самой реализацией фабрики)
		PersonSupportFactory factory = null;
		try {
			factory = FactoryManager.getFactory(FactoryManager.FactiryType.DB);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//клиенту передаем уже инстанс
		try {
			SomeClient someClient = new SomeClient(factory);
			try {
				someClient.writePerson(new Person("Slava", 23));
				System.out.println(someClient.readPerson("Slava"));
				someClient.editPerson(new Person("Slava", 23), new Person("Yaroslav", 24));
				someClient.readPerson("Yaroslav");
				System.out.println(someClient.readPerson("Yaroslav"));
				someClient.removePerson("Yaroslav");
				for (int i = 0; i < 100; i++) {
					someClient.writePerson(new Person("qwe" + i, i));
				}

				System.out.println("PERSON: " + someClient.readPerson("qwe" + "99"));
				System.out.println("PERSON: " + someClient.readPerson("qwe" + "32"));

				for (int i = 0; i < 100; i++) {
					someClient.removePerson("qwe" + i);
				}
			} catch (PersonWriterException e) {
				e.printStackTrace();
			} catch (PersonReaderException e) {
				e.printStackTrace();
			}
		} catch (PersonFactoryException e) {
			e.printStackTrace();
		}
	}
}
