package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.MotorcycleDTO;
import databaseConfig.dataBaseConfig;

public class MotorcycleRepository {
	public void addMotorcycle(MotorcycleDTO motorcycle) throws SQLException {
		String query = "INSERT INTO motorcycles (marca, cilindraje, precio, color) VALUES (?, ?, ?, ?)";
		try (Connection conn = dataBaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, motorcycle.getMarca());
			stmt.setInt(2, motorcycle.getCilindraje());
			stmt.setDouble(3, motorcycle.getPrecio());
			stmt.setString(4, motorcycle.getColor());
			stmt.executeUpdate();
		}
	}

	public void updateMotorcycle(MotorcycleDTO motorcycle) throws SQLException {
		String query = "UPDATE motorcycles SET marca = ?, cilindraje = ?, precio = ?, color = ? WHERE id = ?";
		try (Connection conn = dataBaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, motorcycle.getMarca());
			stmt.setInt(2, motorcycle.getCilindraje());
			stmt.setDouble(3, motorcycle.getPrecio());
			stmt.setString(4, motorcycle.getColor());
			stmt.setInt(5, motorcycle.getId());
			stmt.executeUpdate();
		}
	}

	public void deleteMotorcycle(int id) throws SQLException {
		String query = "DELETE FROM motorcycles WHERE id = ?";
		try (Connection conn = dataBaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

}
