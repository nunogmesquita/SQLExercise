public class Car {
    int car_year;
    int price;
    String brand;
    String model;
    String color;

    public Car(int car_year, int price, String brand, String model, String color) {
        this.car_year = car_year;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_year=" + car_year +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getCar_year() {
        return car_year;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}