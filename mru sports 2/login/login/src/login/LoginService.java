import java.sql.*;

public class LoginService {
    private Connection connection;

    public LoginService() throws SQLException {
        // Establish connection to the database
        String url = "jdbc:mysql://localhost:3306/user_db";
        String username = "your_username";
        String password = "your_password";
        connection = DriverManager.getConnection(url, username, password);
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        // Query the database to check if the user exists and the password matches
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // If there's a matching user, return true
        }
    }
}
