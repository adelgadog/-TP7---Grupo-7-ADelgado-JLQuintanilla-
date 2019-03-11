package Codigo;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private boolean dineros;
	private String pssw;

	public Person() {
		// Nothing to do...
	}

	public Person(String name, int age, boolean dineros) {
		this.name = name;
		this.age = age;
		this.setDineros(dineros);
	}

	@Override
	public String toString() {
		String all = name + " * " + age + " * ";
		return all;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public boolean getDineros() {
		return dineros;
	}

	public void setDineros(boolean dineros) {
		this.dineros = dineros;
	}

	public String getPssw() {
		return pssw;
	}

	public void setPssw(String pssw) {
		this.pssw = pssw;
	}
}
