package pojos;

import models.Driver;
import models.Manufacturer;

public class CarsPayload {

    private int carId;
    private String licencePlate;
    private boolean convertible;
    private int rating;
    private int seatCount;
    private String engineType;
    private String colour;
    private String model;
    private ManufacturersPayload manufacturer;
    private String speedLimit;
    private DriversPayload driverAssigned;

    public CarsPayload() {
        
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public ManufacturersPayload getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturersPayload manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSpeedLimit() {
        return speedLimit;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setSpeedLimit(String speedLimit) {
        this.speedLimit = speedLimit;
    }

    public DriversPayload getDriverAssigned() {
        return driverAssigned;
    }

    public void setDriverAssigned(DriversPayload driverAssigned) {
        this.driverAssigned = driverAssigned;
    }
}
