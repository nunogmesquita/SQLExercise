import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        CarRepository carRepository = new CarRepository();
        RentalRepository rentalRepository = new RentalRepository();
        try {
            clientRepository.getClients().forEach(System.out::println);
            System.out.println(clientRepository.getClient(1).toString());
            clientRepository.deleteClient(8);
            carRepository.getCars().forEach(System.out::println);
            rentalRepository.getRentals().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}