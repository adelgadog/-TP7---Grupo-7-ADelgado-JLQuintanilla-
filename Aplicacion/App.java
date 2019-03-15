package Aplicacion;
import Clases.Person;
import Codigo.Usuario;
import Codigo.basededatos;

public class App {
	public static void main(String[] args) {
		Person p = Usuario.crearPerson();
		basededatos.basededatos(p);
		}
}
