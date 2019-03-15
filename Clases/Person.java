package Clases;


import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean dineros;

	public Person() {
		// Nothing to do...
	}

	public Person(String name, int age, boolean dineros) {
		this.name = name;
		this.setDineros(dineros);
	}

	@Override
	public String toString() {
		String all = name + " * ";
		return all;
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
}
