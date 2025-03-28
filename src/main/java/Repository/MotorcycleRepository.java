package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DTO.MotorcycleDTO;
import databaseConfig.dataBaseConfig;

public class MotorcycleRepository {
	public void addMotorcycle(MotorcycleDTO motorcycle) throws SQLException {
	    String query = "INSERT INTO motorcycles (marca, cilindraje, precio, color) VALUES ('" +
	                   motorcycle.getMarca() + "', '" +
	                   motorcycle.getCilindraje() + "', '" +
	                   motorcycle.getPrecio() + "', '" +
	                   motorcycle.getColor() + "')";

	    try (Connection conn = dataBaseConfig.getConnection();
	         Statement stmt = conn.createStatement()) {
	        stmt.executeUpdate(query);
	    }
	}
	
	public MotorcycleDTO findMotorcycleById(int id) throws SQLException {
		String query = "SELECT * FROM motorcycles WHERE id =" +id;
		try (Connection connection = dataBaseConfig.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
			if (resultSet.next()) {
				return new MotorcycleDTO(resultSet.getInt("id"),             
						resultSet.getString("marca"),       
						resultSet.getInt("cilindraje"),   
						resultSet.getDouble("precio"),       
						resultSet.getString("color"));

			} else {
				return null;
			}
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
