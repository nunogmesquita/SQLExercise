import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientRepository {

    static String query;

    public static List<Client> getClients(Connection connection) throws SQLException {
        List<Client> clients = new LinkedList<>();
        Statement statement = connection.createStatement();
        query = "SELECT * FROM clients";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            boolean car_license = resultSet.getBoolean("car_license");
            clients.add(new Client(name, age, car_license));
        }
        return clients;
    }

    static void createClient(Connection connection, Client client) throws SQLException {
        Statement statement = connection.createStatement();
        query = "INSERT INTO clients (name, age, car_license) VALUES ('" + client.getName() + "', " + client.getAge() + ", " + client.car_license + ")";
        statement.executeUpdate(query);
    }

    static Client getClient(Connection connection, int id) throws SQLException {
        Statement statement = connection.createStatement();
        query = "SELECT * FROM clients WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Client client = null;
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            boolean car_license = resultSet.getBoolean("car_license");
            client = new Client(name, age, car_license);
        }
        return client;
    }

    static void updateClient(Connection connection, Client client) throws SQLException {
        Statement statement = connection.createStatement();
        query = "UPDATE clients SET name = '" + client.getName() + "', age = " + client.getAge() + ", car_license = " + client.car_license + " WHERE id = 8";
        statement.executeUpdate(query);
    }

    static void deleteClient(Connection connection, int id) throws SQLException{
        Statement statement = connection.createStatement();
        query = "DELETE FROM clients WHERE id = " + id;
        statement.executeUpdate(query);
    }
}