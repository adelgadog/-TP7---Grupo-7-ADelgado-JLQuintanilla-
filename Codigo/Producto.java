
import java.io.Serializable;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cant;
	private int idproducto;
	private String nombre;
	private float precio;

	public Producto(int cant, int idproducto, String nombre, float precio) {
		this.cant = cant;
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto() {

	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
