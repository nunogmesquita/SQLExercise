public class Client {
    String name;
    int age;
    boolean car_license;

    public Client(String name, int age, boolean car_license) {
        this.name = name;
        this.age = age;
        this.car_license = car_license;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car_license=" + car_license +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCar_license() {
        return car_license;
    }
}