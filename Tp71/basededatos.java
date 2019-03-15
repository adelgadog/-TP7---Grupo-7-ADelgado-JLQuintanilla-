

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//import Compra;
//import Person;
//import Producto;

public class basededatos {

	public static void main(String[] args) {
		Compra carrito = new Compra();
		Person p = new Person("pepe", 12, true);
		//Person p = Usuario.crearPerson();
		Map<Integer, String> mapProductos = new HashMap<Integer, String>();
		mapProductos = dameProductos();
		carrito.setPer(p);

		while (true) {
			System.out.println("\n");
			System.out.println("Estos son los productos que puede comprar: ");
			System.out.println("\n");
			Iterator<Integer> it = mapProductos.keySet().iterator();
			while (it.hasNext()) {
				Integer key = (Integer) it.next();
				System.out.println("Id: 	" + key + " Producto: 	" + mapProductos.get(key).split(":")[0]
						+ "	Precio: 	" + mapProductos.get(key).split(":")[1]);
			}
			System.out.println("\n");
			System.out.println("Indique que produto desea añadir al carrito mediante su identificador.\n"
					+ "Seleccione '0' para continuar al carrito de la compra. Pulse 'Q' si desea salir del progama.");

			String linea = eleccion();
			if (linea.equals("q")) {
				salir();
			} else {
				if (linea.equals("0")) {
					carrito(carrito);
				} else {

					if (mapProductos.containsKey(Integer.parseInt(linea))) {
						carrito.addLista(
								eligeProducto(Integer.parseInt(linea), mapProductos.get(Integer.parseInt(linea))));
					}
				}
			}
		}
	}

	private static void salir() {
		System.out.println("Gracias por comprar en Quintanilla-Delgado SL.\n");
		System.exit(0);
	}

	private static String eleccion() {
		String linea = null;		
		try {
			Scanner teclado = new Scanner(System.in);			
			linea = teclado.nextLine();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return linea;
	}

	private static void carrito(Compra carrito) {
		ArrayList<Producto> lista = carrito.getLista();
		if (lista.size() > 0) {
			float total = 0;
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Estos son todos los productos en su carrito: ");
			System.out.println("\n");

			for (Producto i : lista) {
				System.out.println(i.getNombre() + " Cantidad: " + i.getCant() + " Precio: " + i.getPrecio());
				total = total + (i.getPrecio() * i.getCant());
			}
			System.out.println("\n");
			System.out.println("Total de la compra: " + total);
			System.out.println("\n");
			System.out.println("Pulse 'y' para confirmar su compra o pulse cualquier tecla para seguir comprando."
					+ "Pulse '0' si desea vaciar el carrito y volver a comenzar o 'Q' si desea salir.");
			String linea = eleccion();
			if (linea.equals("q")) {
				salir();
			} else {
				if (linea.equals("0")) {
					carrito.delLista();
				} else {
					if (linea.equals("y")) {
						guardarDB(carrito);
						darTicket(carrito);
						salir();
					}
				}
			}
		} else {
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("El carrito aun esta vacio.");
			System.out.println("\n");
		}
	}

	private static void darTicket(Compra carrito) {
		ArrayList<Producto> listaproductos = carrito.getLista();
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy.HH;mm;ss");
		String fechaticket = fecha.format(myFormatObj);
		float total = 0;
		try {
			Writer wr = new FileWriter(new File(".\\tickets\\", "ticket" + fechaticket + ".txt"));
			for (Producto p : listaproductos) {
				wr.write(p.getNombre() + ":	" + (p.getPrecio() * p.getCant()) + "€\n");
				wr.write(System.lineSeparator());
				wr.flush();
				total = total + (p.getPrecio() * p.getCant());
			}
			wr.write("El total de su compra es: " + total + "€\n");
			wr.write(System.lineSeparator());
			wr.write("Gracias por comprar en Quintanilla-Delgado SL.\n");
			wr.write(System.lineSeparator());
			wr.flush();
			wr.close();
		} catch (IOException e) {
			System.err.println("ERROR");
			System.err.println("An IOException was caught :" + e.getMessage());
		}
	}

	private static void guardarDB(Compra carrito) {
		String nombreDB = "HistorialCompra.db";
		String cliente = carrito.getPer().getName();
		ArrayList<Producto> listaproductos = carrito.getLista();
		String sql2 = "INSERT INTO historial (usuario,producto,precio,cantidad,total,fecha)VALUES(?,?,?,?,?,datetime('now'));";
		try (PreparedStatement pstmt = conectaDB(nombreDB).prepareStatement(sql2)) {
			for (Producto p : listaproductos) {
				pstmt.setString(1, cliente);
				pstmt.setString(2, p.getNombre());
				pstmt.setFloat(3, p.getPrecio());
				pstmt.setInt(4, p.getCant());
				pstmt.setFloat(5, (p.getPrecio() * p.getCant()));
				pstmt.executeUpdate();
			}
		} catch (SQLException o) {
			System.out.println(o.getMessage());
		}
	}

	private static Producto eligeProducto(int id, String valor) {
		Producto prod = new Producto();
		prod.setIdproducto(id);
		prod.setNombre(valor.split("\\:")[0]);
		prod.setPrecio(Integer.parseInt(valor.split("\\:")[1]));
		System.out.println("\n");
		System.out.println("Cuanta cantidad desea de : " + prod.getNombre());
		prod.setCant(Integer.parseInt(eleccion()));
		return prod;
	}

	private static Map<Integer, String> dameProductos() {
		String nombreDB = "testdb.db";
		Map<Integer, String> mapProductos = new HashMap<Integer, String>();

		String pregunta = "SELECT id, nombre, precio FROM producto";
		try (PreparedStatement pstmt = conectaDB(nombreDB).prepareStatement(pregunta)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mapProductos.put(rs.getInt(1), rs.getString(2) + ":" + rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return mapProductos;
	}

	private static Connection conectaDB(String nombreDB) {
		String url = "jdbc:sqlite:" + nombreDB;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
