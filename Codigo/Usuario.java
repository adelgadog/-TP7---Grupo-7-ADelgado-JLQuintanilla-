package Codigo;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Scanner;

import Clases.Person;

public class Usuario {
	public static void crearPerson() {
		Person p = new Person();
		// Scanner teclado = new Scanner(System.in);
		String op1;
		String usuario = null;
		String pass1;
		Boolean dineros = null;

		System.out.println("\n \n \n \n \n \n");
		System.out.println("	***************************************************");
		System.out.println("	---------------------------------------------------");
		System.out.println("	***************************************************");		
		System.out.println("\n \n");
		System.out.println("	¿Es tu primera compra?");
		System.out.println("	---------------------------------------------------");
		op1 = eleccion();
		if (op1.equals("no")) {
			System.out.println("	Bienvenido.");
			System.out.println("\n");
			System.out.println("	Introduce un nombre de usuario: ");
			System.out.println("	---------------------------------------------------");
			System.out.println("\n");
			usuario = eleccion();
			System.out.println("	Introduce una contraseña: ");
			System.out.println("	---------------------------------------------------");
			System.out.println("\n");
			pass1 = eleccion();
			String url = "jdbc:sqlite:DB/BDUsuario.db";
			Connection conn = null;
			String sqlSelect = "select * from usuario where usuario =? and contraseña =?";
			ResultSet rs = null;

			try {
				conn = DriverManager.getConnection(url);
				try {
					PreparedStatement stmtUs = conn.prepareStatement(sqlSelect);
					stmtUs.setString(1, usuario);
					stmtUs.setString(2, pass1);
					rs = stmtUs.executeQuery();
					if (!rs.next()) {
						System.out.print("	El usuario no existe. ");
						System.out.println("	---------------------------------------------------");
						System.out.println("\n");
						System.exit(0);
					}
					if (rs.getInt(3) == 1) {
						dineros = true;
					} else {
						dineros = false;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (op1.equals("si")) {
			System.out.println("\n \n \n \n \n \n");
			System.out.println("	Para usar esta aplicación necesitas ser usuario registrado.");
			System.out.println("\n \n \n");
			System.out.println("	Introduce un nuevo nombre de usuario: ");
			System.out.println("	---------------------------------------------------");
			System.out.println("\n");
			usuario = eleccion();
			System.out.println("	Introduce tu contraseña: ");
			System.out.println("	---------------------------------------------------");
			System.out.println("\n");
			pass1 = eleccion();
			System.out.println("	Tienes dineros: (si/no)");
			System.out.println("	---------------------------------------------------");
			System.out.println("\n");
			if (eleccion().equals("si")) {
				dineros = true;
			} else {
				dineros = false;
			}
			;
			// teclado.close();
			String url = "jdbc:sqlite:DB/BDUsuario.db";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url);
				if (conn != null) {
					// System.out.println("The driver name is " + meta.getDriverName());
					// System.out.println("A new database has been created.");
					String insertar = "INSERT INTO Usuario (usuario,contraseña,dinero)VALUES(?,?,?);";
					try (PreparedStatement pstmt = conn.prepareStatement(insertar)) {
						pstmt.setString(1, usuario);
						pstmt.setString(2, pass1);
						if (dineros) {
							pstmt.setInt(3, 1);
						}
						if (!dineros) {
							pstmt.setInt(3, 0);
						}
						;
						pstmt.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException o) {
				System.out.println("error insertar NU");
				System.out.println(o.getMessage());
			}

		}
		System.out.println("	Puedes empezar a comprar en Quintanilla-Delgado S.L.");
		System.out.println("	---------------------------------------------------");
		System.out.println("\n");
		p.setName(usuario);
		p.setDineros(dineros);
		basededatos.basededatos(p);
	}

	private static String eleccion() {
		String linea = null;
		try {
			Console cons = null;
			cons = System.console();
			linea = cons.readLine();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return linea;
	}

}
