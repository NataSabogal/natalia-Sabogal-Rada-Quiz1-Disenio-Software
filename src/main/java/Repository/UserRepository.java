package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import DTO.UserDTO;
import databaseConfig.dataBaseConfig;

public class UserRepository {
	public void registerUser(String username, String password) throws SQLException {
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		String query = "INSERT INTO users (username, password) VALUES (?, ?)";
		try (Connection conn = dataBaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, hashedPassword);
			stmt.executeUpdate();
		}
	}

	public UserDTO loginUser(String username, String password) throws SQLException {
		String query = "SELECT id, password FROM users WHERE username = ?";
		try (Connection conn = dataBaseConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int userId = rs.getInt("id");
				String hashedPassword = rs.getString("password");

				if (BCrypt.checkpw(password, hashedPassword)) {
					return new UserDTO(userId, username, hashedPassword);
				}
			}
		}
		return null;
	}
}
