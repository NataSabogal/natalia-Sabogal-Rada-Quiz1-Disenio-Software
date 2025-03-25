package Services;

import java.sql.SQLException;

import DTO.MotorcycleDTO;
import Repository.MotorcycleRepository;

public class MotorcycleService {
	private final MotorcycleRepository motorcycleRepository = new MotorcycleRepository();

	public void addMotorcycle(String marca, int cilindraje, double precio, String color) throws SQLException {
		MotorcycleDTO motorcycle = new MotorcycleDTO(0, marca, cilindraje, precio, color);
		motorcycleRepository.addMotorcycle(motorcycle);
		System.out.println("Motocicleta agregada exitosamente.");
	}

	public void updateMotorcycle(int id, String marca, int cilindraje, double precio, String color)
			throws SQLException {
		MotorcycleDTO motorcycle = new MotorcycleDTO(id, marca, cilindraje, precio, color);
		motorcycleRepository.updateMotorcycle(motorcycle);
		System.out.println("Motocicleta actualizada correctamente.");
	}

	public void deleteMotorcycle(int id) throws SQLException {
		motorcycleRepository.deleteMotorcycle(id);
		System.out.println("Motocicleta eliminada correctamente.");
	}
}
