package Codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Clases.Person;

public class Usuario {
	public static Person crearPerson() {
		Person p = new Person();
		Scanner teclado = new Scanner(System.in);
		String op1;
		String usuario = null;
		String pass1;
		Boolean dineros = null;

		System.out.println("¿Es tu primera compra? ");
		op1 = teclado.nextLine();
		if (op1.equals("no")) {


			System.out.println("Bienvenido.");
			System.out.println("Introduce un nombre de usuario: ");
			usuario = teclado.nextLine();
			System.out.println("Introduce una contraseña: ");
			pass1 = teclado.nextLine();

	

			String url = "jdbc:sqlite:BDUsuario.db";
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
						 System.out.print("El usuario no existe. ");
						 System.exit(0);
					 }
					 if(rs.getInt(3)==1) {
						 dineros = true; 
					 }
					 else {
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
			System.out.println("Para usar esta aplicación necesitas ser usuario registrado.");
			System.out.println("Introduce un nuevo nombre de usuario: ");
			usuario = teclado.nextLine();
			System.out.println("Introduce tu contraseña: ");
			pass1 = teclado.nextLine();
			teclado.close();
			String url = "jdbc:sqlite:BDUsuario.db";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url);
				if (conn != null) {
					//System.out.println("The driver name is " + meta.getDriverName());
					//System.out.println("A new database has been created.");

					String insertar = "INSERT INTO Usuario (usuario,contraseña,dinero)VALUES(?,?,?);";
					try (PreparedStatement pstmt = conn.prepareStatement(insertar)) {
						pstmt.setString(1, usuario);
						pstmt.setString(2, pass1);
						if(dineros) {
							pstmt.setInt(3, 1);
						}
						if(!dineros) {
							pstmt.setInt(3, 0);
						};
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
		System.out.println("Puedes empezar a comprar en Quintanilla-Delgado S.L.");
		p.setName(usuario);
		p.setDineros(dineros);
		return p;
	}

}
