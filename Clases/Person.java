package Clases;

public class Person {
	private String name;
	private int age;
	private boolean dineros;

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
}
