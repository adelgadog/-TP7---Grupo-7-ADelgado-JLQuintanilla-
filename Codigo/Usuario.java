package Codigo;

import java.util.Scanner;

import Clases.Person;

public class Usuario {

	public Person Usuario() {
		Person p = new Person();

			Scanner teclado = new Scanner(System.in);
			String op1;
			String nUsuario;
			String usuario;
			String pass1;
			String pass2;

			System.out.println("�Es tu primera compra? ");
			op1 = teclado.nextLine();
			if (op1.equals("no")) {

				String contrase�a;
				String intento;
				contrase�a = "password";
				String dineros;

				System.out.println("Bienvenido.");
				System.out.println("Introduce un nombre de usuario: ");
				nUsuario = teclado.nextLine();

				boolean encontrado = false;

				for (int i = 0; i < 3 && !encontrado; i++) {
					if (i == 0) {
						System.out.println("Introduzca la contrase�a: ");
					} else if (i == 1) {
						System.out.println("Quedan dos intentos: ");
					} else if (i == 2) {
						System.out.println("�ltimo intento: ");
					}

					intento = teclado.nextLine();
					if (intento.equals(contrase�a)) {
						encontrado = true;
					}
				}

				if (encontrado) {
					System.out.println("La contrase�a introducida es correcta: ");
				} else {
					System.out.println("Ha agotado los tres intentos: ");
					System.exit(0);
				}
				System.out.println("�Cu�nto dinero tienes? ");
				dineros = teclado.nextLine();
			}

			if (op1.equals("si")) {
				System.out.println("Para usar esta aplicaci�n necesitas ser usuario registrado.");
				System.out.println("Introduce un nuevo nombre de usuario: ");
				nUsuario = teclado.nextLine();
				do {
					System.out.println("Introduce tu contrase�a: ");
					pass1 = teclado.nextLine();
					System.out.println("Vuelve a introducir la contrase�a: ");
					pass2 = teclado.nextLine();
					if (pass1.contentEquals(pass2)) {

						System.out.println("Ya est�s registrado.");

					} else {

						System.out.println("Las cotrase�as no coinciden, vuelve a intentarlo: ");
						/////
					}

				} while (!pass1.contentEquals(pass2));
				teclado.close();

			}
			System.out.println("Puedes empezar a comprar en Quintanilla-Delgado S.L.");
			return p;
		}	
}
