package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Model {

    @Id
    private int id;

    @Column(unique = true)
    @Constraints.Required
    private String licencePlate;
    @Constraints.Required
    private boolean convertible;
    @Constraints.Min(1)
    @Constraints.Max(5)
    @Constraints.Required
    private int rating;
    @Constraints.Required
    private String engineType;
    @Constraints.Required
    private String colour;
    @Constraints.Required
    private String model;
    @Constraints.Required
    private int seatCount;
    @Constraints.Required
    private String speedLimit;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Manufacturer manufacturer;
    @OneToOne(cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonBackReference
    private Driver driver;

    public static Finder<Long,Car> find = new Finder<>(Car.class);

    public Car() {

    }

    public Car(String licencePlate, boolean convertible, @Constraints.Min(1) @Constraints.Max(5) int rating, String engineType, String colour, String model, int seatCount, String speedLimit, Manufacturer manufacturer, Driver driver) {
        this.licencePlate = licencePlate;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.colour = colour;
        this.model = model;
        this.seatCount = seatCount;
        this.speedLimit = speedLimit;
        this.manufacturer = manufacturer;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(String speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
