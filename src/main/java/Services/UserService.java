package Services;
import java.sql.SQLException;
import DTO.UserDTO;
import Repository.UserRepository;

public class UserService {

	private final UserRepository userRepository = new UserRepository();

	public void register(String username, String password) throws SQLException {
		userRepository.registerUser(username, password);
		System.out.println("Usuario registrado exitosamente.");
	}

	public void login(String username, String password) throws SQLException {
		UserDTO user = userRepository.loginUser(username, password);
		if (user != null) {
			System.out.println("Inicio de sesión exitoso. Bienvenido, " + username);
		} else {
			System.out.println("Error: Usuario o contraseña incorrectos.");
		}
	}
}
