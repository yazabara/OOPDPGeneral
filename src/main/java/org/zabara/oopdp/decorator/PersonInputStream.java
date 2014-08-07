package org.zabara.oopdp.decorator;

import org.zabara.oopdp.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class PersonInputStream extends InputStream {

    private InputStream inputStream;

    public PersonInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Person readPerson() throws IOException, ClassNotFoundException {
        ObjectInput objectInput = new ObjectInputStream(inputStream);
        Object result = objectInput.readObject();
        objectInput.close();
        return (Person) result;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }
}

