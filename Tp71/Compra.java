

import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person per;
	@SuppressWarnings("unused")
	private Producto producto;
	private ArrayList<Producto> lista;

	public Compra() {
		// constructor por defecto
		per = new Person();
		lista = new ArrayList<Producto>();
	}

	public void setPer(Person per) {
		this.per = per;
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}
	
	public void addLista(Producto producto) {
		this.producto = producto;
		this.lista.add(producto);
	}
	
	public void delLista() {
		this.lista = null;
		this.lista = new ArrayList<Producto>();
	}
	public Person getPer() {
		return per;
	}

}
