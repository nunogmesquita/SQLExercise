import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientRepository {

    String query;

    Connection connection;

    public ClientRepository() {
        this.connection = SQLConnection.getConnection();
    }

    public List<Client> getClients() throws SQLException {
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

    void createClient(Client client) throws SQLException {
        Statement statement = connection.createStatement();
        query = "INSERT INTO clients (name, age, car_license) VALUES ('" + client.getName() + "', " + client.getAge() + ", " + client.car_license + ")";
        statement.executeUpdate(query);
    }

    Client getClient(int id) throws SQLException {
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

    void updateClient(Client client, int id) throws SQLException {
        Statement statement = connection.createStatement();
        query = "UPDATE clients SET name = '" + client.getName() + "', age = " + client.getAge() + ", car_license = " + client.car_license + " WHERE id = " + id;
        statement.executeUpdate(query);
    }

    void deleteClient(int id) throws SQLException{
        Statement statement = connection.createStatement();
        query = "DELETE FROM clients WHERE id = " + id;
        statement.executeUpdate(query);
    }
}