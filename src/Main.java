import java.sql.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            Connection databaseConnection = getConnection();
            ClientRepository.getClients(databaseConnection).forEach(System.out::println);
            System.out.println(ClientRepository.getClient(databaseConnection, 1).toString());
            ClientRepository.deleteClient(databaseConnection, 8);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {

        String dbURL = "jdbc:mysql://localhost:3306/rental_car_database";
        String username = "root";
        String password = "12345";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }

        return connection;
    }

}