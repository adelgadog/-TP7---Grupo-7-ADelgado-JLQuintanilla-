public class Person {
	private String name;
	private boolean dineros;

	public Person() {
		// Nothing to do...
	}

	public Person(String name, int age, boolean dineros) {
		this.name = name;
		this.setDineros(dineros);
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
