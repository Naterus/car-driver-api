package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Car;
import models.Driver;
import models.Manufacturer;
import play.libs.Json;
import play.libs.typedmap.TypedKey;
import play.mvc.*;
import pojos.CarsPayload;
import pojos.DriversPayload;
import pojos.ManufacturersPayload;
import pojos.ResponsePayload;
import util.exceptions.GeneralAppException;
import util.middleware.AuthorityAction;
import util.security.Authority;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class CarController extends Controller {

    @Inject
    Authority auth;

    @With(AuthorityAction.class)
    public Result createCar(Http.Request request) throws GeneralAppException {
        JsonNode formData = request.body().asJson();
        if(formData == null){
            return badRequest("Please provide valid json data");
        }else{
            Car car = new Car();

            String licencePlate = formData.findPath("licencePlate").textValue();
            int rating = formData.findPath("rating").intValue();
            int seat_count = formData.findPath("seat_count").intValue();
            String convertible = formData.findPath("convertible").textValue();
            String engineType = formData.findPath("engineType").textValue();
            String manufacturer = formData.findPath("manufacturer").textValue();
            String colour = formData.findPath("colour").textValue();
            String model = formData.findPath("model").textValue();
            String speedLimit = formData.findPath("speedLimit").textValue();

            Manufacturer modelManufacturer = Manufacturer.find.byId(manufacturer);

            if(modelManufacturer == null){

                //Create manufacturer is it doesnt exist
                modelManufacturer = new Manufacturer();

                modelManufacturer.setId(manufacturer);
                modelManufacturer.save();
            }


            car.setColour(colour);
            car.setEngineType(engineType);
            car.setModel(model);
            car.setSeatCount(seat_count);
            car.setLicencePlate(licencePlate);
            car.setSpeedLimit(speedLimit);
            car.setManufacturer(modelManufacturer);
            car.setRating(rating);

            if(convertible.equals("Yes")){
                car.setConvertible(true);
            }else if (convertible.equals("No")){
                car.setConvertible(false);
            }else{
               return  badRequest("Convertible value must be Yes or No");
            }

            car.save();

            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(201);
            responsePayload.setStatusTitle("created");
            responsePayload.setMessage("Car created successfully");

            return created(Json.toJson(responsePayload));
        }
    }

    @With(AuthorityAction.class)
    public Result getAllCars(Http.Request request) throws GeneralAppException {

        List<Car> cars = Car.find.all();

        List<CarsPayload> carsPayload = getCarsPayload(cars);


        return ok(Json.toJson(carsPayload));
    }

    @With(AuthorityAction.class)
    public Result getCar(Long id){
       Car car = Car.find.byId(id);
       if(car == null){
           return notFound("Car not found");
       }
       CarsPayload carPayload = getSingleCarPayload(car);

       return ok(Json.toJson(carPayload));

    }

    @With(AuthorityAction.class)
    public Result updateCar(Http.Request request,Long id){

        JsonNode formData = request.body().asJson();

        if(formData == null){
            return badRequest("Please provide valid json data");
        }else{
            Car car = Car.find.byId(id);

            if(car == null){

                ResponsePayload responsePayload = new ResponsePayload();
                responsePayload.setStatusCode(404);
                responsePayload.setStatusTitle("not found");
                responsePayload.setMessage("Car not found");

                return notFound(Json.toJson(responsePayload));
            }

            String licencePlate = formData.findPath("licencePlate").textValue();
            int rating = formData.findPath("plateNumber").intValue();
            int seatCount = formData.findPath("seatCount").intValue();
            String convertible = formData.findPath("convertible").textValue();
            String engineType = formData.findPath("engineType").textValue();
            String manufacturer = formData.findPath("manufacturer").textValue();
            String colour = formData.findPath("colour").textValue();
            String model = formData.findPath("model").textValue();
            String speedLimit = formData.findPath("speedLimit").textValue();

            Manufacturer modelManufacturer = Manufacturer.find.byId(manufacturer);

            if(modelManufacturer == null){
                //Create new manufacturer if it doesn't exist
                Manufacturer newManufacturer = new Manufacturer();
                newManufacturer.setId(manufacturer);
                newManufacturer.save();
            }

            car.setColour(colour);
            car.setEngineType(engineType);
            car.setModel(model);
            car.setSeatCount(seatCount);
            car.setLicencePlate(licencePlate);
            car.setSpeedLimit(speedLimit);
            car.setRating(rating);

            if(convertible.equals("Yes")){
                car.setConvertible(true);
            }else if (convertible.equals("No")){
                car.setConvertible(false);
            }else{
                return  badRequest("Convertible value must be Yes or No");
            }

            car.update();

            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(200);
            responsePayload.setStatusTitle("ok");
            responsePayload.setMessage("Car updated successfully");

            return ok(Json.toJson(responsePayload));
        }

    }

    @With(AuthorityAction.class)
    public Result deleteCar(Long id){

        Car car = Car.find.byId(id);
        if(car == null){
            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(404);
            responsePayload.setStatusTitle("not found");
            responsePayload.setMessage("No car found with the specified id");
            return notFound(Json.toJson(responsePayload));
        }


        Driver driver = Driver.find.byId((long) car.getDriver().getId());
        car.setDriver(driver);
        car.save();

        //Check back
        car.delete();

        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setStatusCode(200);
        responsePayload.setStatusTitle("ok");
        responsePayload.setMessage("Car deleted successfully");
        return ok(Json.toJson(responsePayload));

    }

    /**
     * Convenience method to set list of cars payload
     * @param cars
     * @return
     */
    public List<CarsPayload> getCarsPayload(List<Car> cars){
        List<CarsPayload> carsPayload = new ArrayList<>();

        for ( Car car : cars
        ) {
            CarsPayload carsPojo = getSingleCarPayload(car);
            carsPayload.add(carsPojo);
        }

        return carsPayload;
    }

    /**
     * Convenience method to set and get single car payload
     * @param car
     * @return
     */
    public CarsPayload getSingleCarPayload(Car car){
        CarsPayload carPayload =  new CarsPayload();

        carPayload.setCarId(car.getId());
        carPayload.setColour(car.getColour());
        carPayload.setConvertible(car.isConvertible());
        carPayload.setLicencePlate(car.getLicencePlate());
        carPayload.setEngineType(car.getEngineType());
        carPayload.setManufacturer(getManufacturerPayload(car.getManufacturer()));
        carPayload.setModel(car.getModel());
        carPayload.setRating(car.getRating());
        carPayload.setSeatCount(car.getSeatCount());
        carPayload.setSpeedLimit(car.getSpeedLimit());
        if(car.getDriver() != null) {
            carPayload.setDriverAssigned(getSingleDriver(car.getDriver()));
        }

        return carPayload;
    }

    public DriversPayload getSingleDriver(Driver driver){
        DriversPayload driverPayload = new DriversPayload();

        driverPayload.setDriverId(driver.getId());
        driverPayload.setAge(driver.getAge());
        driverPayload.setContactNumber(driver.getContactNumber());
        driverPayload.setFirstName(driver.getFirstName());
        driverPayload.setLastName(driver.getLastName());
        driverPayload.setGender(driver.getGender());
        driverPayload.setUsername(driver.getUsername());
        driverPayload.setPassword(driver.getPassword());
        driverPayload.setDeleted(driver.isDeleted());
        if(driver.isOnlineStatus()){
            driverPayload.setOnlineStatus("Online");
        }else{
            driverPayload.setOnlineStatus("Offline");
        }
        driverPayload.setDateCreated(driver.getDateCreated());
        driverPayload.setDateModified(driver.getDateModified());

        return driverPayload;
    }

    public ManufacturersPayload getManufacturerPayload(Manufacturer manufacturer){

        ManufacturersPayload manufacturersPayload = new ManufacturersPayload();

        manufacturersPayload.setName(manufacturer.getId());
        manufacturersPayload.setLocation(manufacturer.getLocation());
        manufacturersPayload.setDateEstablished(manufacturer.getDateEstablished());

        return manufacturersPayload;
    }



}
