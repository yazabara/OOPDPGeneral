package org.zabara.oopdp.dao;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.zabara.oopdp.domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Yaroslav on 03.03.14.
 */
public class DataBaseManager {

    private static DataBaseManager instance = null;

    private Collection<Person> persons = null;

    private DataBaseManager() {
        this.persons = new ArrayList<Person>();
    }

    static {
        instance = new DataBaseManager();
    }

    public static DataBaseManager getInstance(){
        if (instance == null) {
            instance = new DataBaseManager();
        }
        return instance;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public  Collection<Person> likeName(final String name){
        Collection<Person>selectPersons = CollectionUtils.select(persons , new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                Person p = null;
                try {
                    p = (Person)o;
                } catch (Exception ex) {
                    return false;
                }
                return p.getName().matches(".*"+name+".*");
            }
        });
        return selectPersons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(String name){
        Iterator<Person> iter = persons.iterator();
        while(iter.hasNext()){
            if(iter.next().getName().equals(name)){
                iter.remove();
            }
        }
    }

    public void editPerson(String name, Person person){
        for (Person curPerson : persons) {
            if (curPerson.getName().equals(name)) {
                curPerson.setAge(person.getAge());
                curPerson.setName(person.getName());
                return;
            }
        }
    }
}
