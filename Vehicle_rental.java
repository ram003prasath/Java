import java.util.HashMap;
import java.util.Map;

class Vehicle {
    protected String registrationNumber;
    protected double rentalRate;
    protected boolean rented;

    public Vehicle(String registrationNumber, double rentalRate) {
        this.registrationNumber = registrationNumber;
        this.rentalRate = rentalRate;
        this.rented = false;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isRented() {
        return rented;
    }

    public void rent() {
        rented = true;
    }

    public void returnVehicle() {
        rented = false;
    }
}

class Car extends Vehicle {
    public Car(String registrationNumber, double rentalRate) {
        super(registrationNumber, rentalRate);
    }
}

class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(String registrationNumber, double rentalRate, int cargoCapacity) {
        super(registrationNumber, rentalRate);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }
}

class Customer {
    private String name;
    private Map<String, Vehicle> rentedVehicles;

    public Customer(String name) {
        this.name = name;
        this.rentedVehicles = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void rentVehicle(Vehicle vehicle) {
        if (!vehicle.isRented()) {
            rentedVehicles.put(vehicle.getRegistrationNumber(), vehicle);
            vehicle.rent();
            System.out.println(name + " rented vehicle " + vehicle.getRegistrationNumber());
        } else {
            System.out.println("Vehicle " + vehicle.getRegistrationNumber() + " is already rented.");
        }
    }

    public void returnVehicle(String registrationNumber) {
        Vehicle vehicle = rentedVehicles.remove(registrationNumber);
        if (vehicle != null) {
            vehicle.returnVehicle();
            System.out.println(name + " returned vehicle " + registrationNumber);
        } else {
            System.out.println("Vehicle " + registrationNumber + " is not rented by " + name);
        }
    }
}

class RentalSystem {
    private Map<String, Vehicle> vehicles;

    public RentalSystem() {
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public Vehicle getVehicle(String registrationNumber) {
        return vehicles.get(registrationNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        Car car1 = new Car("CAR001", 50.0);
        Car car2 = new Car("CAR002", 60.0);
        Truck truck1 = new Truck("TRUCK001", 80.0, 5000);

        rentalSystem.addVehicle(car1);
        rentalSystem.addVehicle(car2);
        rentalSystem.addVehicle(truck1);

        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Alice");

        customer1.rentVehicle(car1);
        customer2.rentVehicle(truck1);

        customer1.returnVehicle("CAR001");
        customer2.returnVehicle("TRUCK001");
    }
}
