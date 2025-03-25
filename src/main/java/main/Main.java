package main;

import java.sql.SQLException;
import java.util.Scanner;

import Services.MotorcycleService;
import Services.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		MotorcycleService motorcycleService = new MotorcycleService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n MENÚ PRINCIPAL");
			System.out.println("1. Registrar Usuario");
			System.out.println("2. Iniciar Sesión");
			System.out.println("3. Agregar Motocicleta");
			System.out.println("4. buscar Motocicleta");
			System.out.println("5. Actualizar Motocicleta");
			System.out.println("6. Eliminar Motocicleta");
			System.out.println(". Salir");
			System.out.print("Seleccione una opción: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (option) {
				case 1:
					System.out.print("Ingrese un nombre de usuario: ");
					String username = scanner.nextLine();
					System.out.print("Ingrese una contraseña: ");
					String password = scanner.nextLine();
					userService.register(username, password);
					break;

				case 2:
					System.out.print("Ingrese su usuario: ");
					username = scanner.nextLine();
					System.out.print("Ingrese su contraseña: ");
					password = scanner.nextLine();
					userService.login(username, password);
					break;

				case 3:
					System.out.print("Ingrese la marca: ");
					String marca = scanner.nextLine();
					System.out.print("Ingrese el cilindraje: ");
					int cilindraje = scanner.nextInt();
					System.out.print("Ingrese el precio: ");
					double precio = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Ingrese el color: ");
					String color = scanner.nextLine();
					motorcycleService.addMotorcycle(marca, cilindraje, precio, color);
					break;

				case 4:
					System.out.print("Ingrese el ID de la motocicleta a buscar: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					motorcycleService.findMotorcycleById(id);
					break;

				case 5:
					System.out.print("Ingrese el ID de la motocicleta a actualizar: ");
					id = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Ingrese la nueva marca: ");
					marca = scanner.nextLine();
					System.out.print("Ingrese el nuevo cilindraje: ");
					cilindraje = scanner.nextInt();
					System.out.print("Ingrese el nuevo precio: ");
					precio = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Ingrese el nuevo color: ");
					color = scanner.nextLine();
					motorcycleService.updateMotorcycle(id, marca, cilindraje, precio, color);
					break;

				case 6:
					System.out.print("Ingrese el ID de la motocicleta para eliminar: ");
					id = scanner.nextInt();
					scanner.nextLine();
					motorcycleService.deleteMotorcycle(id);
					break;

				case 7:
					System.out.println("Saliendo");
					scanner.close();
					return;

				default:
					System.out.println("Opción inválida. Intente otra vez");
				}
			} catch (SQLException e) {
				System.out.println("Error en la bd: " + e.getMessage());
			}
		}
	}
}
