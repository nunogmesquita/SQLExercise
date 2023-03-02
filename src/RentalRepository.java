import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RentalRepository {
    static String query;

    public static List<Rental> getRental(Connection connection) throws SQLException {
        List<Rental> rentals = new LinkedList<>();
        Statement statement = connection.createStatement();
        query = "SELECT * FROM rentals";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int car_id = resultSet.getInt("car_id");
            int client_id = resultSet.getInt("client_id");

            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");


            rentals.add(new Rental(car_id, client_id, start_date, end_date));
        }
        return rentals;
    }

    static void createRental(Connection connection, Rental rental) throws SQLException {
        Statement statement = connection.createStatement();
        query = "INSERT INTO rentals (car_id, client_id, start_date, end_date) VALUES (" + rental.getCar_id() + ", " + rental.getClient_id() + ", '" + rental.getStart_date() + "', '" + rental.getEnd_date() +"'";
        statement.executeUpdate(query);
    }

    static Rental getRental(Connection connection, int id) throws SQLException {
        Statement statement = connection.createStatement();
        query = "SELECT * FROM rentals WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Rental rental = null;
        while (resultSet.next()) {
            int car_id = resultSet.getInt("car_id");
            int client_id = resultSet.getInt("client_id");
            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");

            rental = new Rental(car_id, client_id, start_date, end_date);
        }
        return rental;
    }

    static void updateRental (Connection connection, Rental rental) throws SQLException {
        Statement statement = connection.createStatement();
        query = "UPDATE rentals SET car_id = " + rental.getCar_id() + ", client_id = " + rental.getClient_id() + ", start_date = '" + rental.getStart_date() + "', end_date = '" + rental.getEnd_date() + "' WHERE id = 1";
        statement.executeUpdate(query);
    }

    static void deleteRental(Connection connection, int id) throws SQLException{
        Statement statement = connection.createStatement();
        query = "DELETE FROM rentals WHERE id = " + id;
        statement.executeUpdate(query);
    }
}