package Aplicacion;
import Clases.Person;
import Codigo.Usuario;
import Codigo.basededatos;

public class App {
	public void main (String args) {
		Usuario u = new Usuario();
		Person p = u.Usuario();
		basededatos b = new basededatos();
		b.basededatos(p);
		}
}
