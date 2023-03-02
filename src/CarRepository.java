import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CarRepository {
    String query;

    Connection connection;

    public CarRepository() {
        this.connection = SQLConnection.getConnection();
    }

    public List<Car> getCars() throws SQLException {
        List<Car> cars = new LinkedList<>();
        Statement statement = connection.createStatement();
        query = "SELECT * FROM cars";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int car_year = resultSet.getInt("car_year");
            int price = resultSet.getInt("price");
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            String color = resultSet.getString("color");
            cars.add(new Car(car_year, price, brand, model, color));
        }
        return cars;
    }

    void createCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        query = "INSERT INTO cars (car_year, price, brand, model, color) VALUES (" + car.getCar_year() + ", " + car.getPrice() + ", '" + car.getBrand() + "', '" + car.getModel() + "', '" + car.getColor() + "')";
        statement.executeUpdate(query);
    }

    Car getCar(int id) throws SQLException {
        Statement statement = connection.createStatement();
        query = "SELECT * FROM cars WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Car car = null;
        while (resultSet.next()) {
            int car_year = resultSet.getInt("car_year");
            int price = resultSet.getInt("price");
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            String color = resultSet.getString("color");
            car = new Car(car_year, price, brand, model, color);
        }
        return car;
    }

    void updateCar(Car car, int id) throws SQLException {
        Statement statement = connection.createStatement();
        query = "UPDATE cars SET car_year = " + car.getCar_year() + ", price = " + car.getPrice() + ", brand = '" + car.getBrand() + "', model = '" + car.getModel() + "', color = '" + car.getColor() + "' WHERE id = "+id;
        statement.executeUpdate(query);
    }

    void deleteCar(int id) throws SQLException{
        Statement statement = connection.createStatement();
        query = "DELETE FROM cars WHERE id = " + id;
        statement.executeUpdate(query);
    }
}