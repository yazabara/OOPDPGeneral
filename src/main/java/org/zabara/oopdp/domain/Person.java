package org.zabara.oopdp.domain;

import java.io.Serializable;

/**
 * Created by Yaroslav on 17.02.14.
 * <p/>
 * Тестовый бин - имя уникальное поле. оно же выступает в роли id;
 */
public class Person implements Serializable {

	protected int age;
	protected String name;
	protected int iq;

	public static final int DEFAULT_IQ = 100;

	public Person(String name, int age, int iq) {
		this.age = age;
		this.name = name;
		this.iq = iq;
	}

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
		this.iq = DEFAULT_IQ;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIq() {
		return iq;
	}

	public void setIq(int iq) {
		this.iq = iq;
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", name='" + name + '\'' +
				", iq=" + iq +
				'}';
	}
}
