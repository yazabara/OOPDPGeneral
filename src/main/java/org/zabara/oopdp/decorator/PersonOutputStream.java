package org.zabara.oopdp.decorator;

import org.zabara.oopdp.domain.Person;

import java.io.*;

public class PersonOutputStream extends OutputStream {

    private OutputStream outputStream;

    public PersonOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

	public void writePerson(Person person) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ObjectOutput output = new ObjectOutputStream(stream);
        output.writeObject(person);
        output.close();
        outputStream.write(stream.toByteArray());
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }
}
