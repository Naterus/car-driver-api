package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Optional;
import models.Car;
import models.Driver;
import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;
import models.Manufacturer;
import org.mindrot.jbcrypt.BCrypt;
import play.libs.Json;
import play.mvc.*;
import pojos.CarsPayload;
import pojos.DriversPayload;
import pojos.ManufacturersPayload;
import pojos.ResponsePayload;
import util.exceptions.CarAlreadyInUseException;
import util.exceptions.GeneralAppException;
import util.middleware.AuthorityAction;

import java.util.ArrayList;
import java.util.List;


public class DriverController extends Controller {


    @With(AuthorityAction.class)
    public Result createDriver(Http.Request request) throws GeneralAppException {

        JsonNode formData = request.body().asJson();

        if(formData == null){

            return badRequest("Please provide valid json data");

        } else {
            Driver driver = new Driver();

            String username = formData.findPath("username").textValue();
            String password = formData.findPath("password").textValue();
            String firstName = formData.findPath("firstName").textValue();
            String lastName = formData.findPath("lastName").textValue();
            String gender = formData.findPath("gender").textValue();
            String contactNumber = formData.findPath("contactNumber").textValue();
            String onlineStatus = formData.findPath("onlineStatus").textValue();
            int age = formData.findPath("age").intValue();

            driver.setAge(age);
            driver.setContactNumber(contactNumber);
            driver.setFirstName(firstName);
            driver.setLastName(lastName);
            driver.setGender(gender);
            driver.setUsername(username);
            driver.setPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
            if(onlineStatus.equals("Online")){

                driver.setOnlineStatus(true);

            }else if(onlineStatus.equals("Offline")) {

                driver.setOnlineStatus(false);

            } else {
                return badRequest("Invalid online status, select between online and offline");
            }

            driver.save();

            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(201);
            responsePayload.setStatusTitle("created");
            responsePayload.setMessage("Driver created successfully");

            return created(Json.toJson(responsePayload));
        }
    }

    @With(AuthorityAction.class)
    public Result getAllDrivers(){

        List<Driver> drivers = Driver.find.all();

        List<DriversPayload> driversPayload = getDriversPayload(drivers);

        return ok(Json.toJson(driversPayload));
    }

    @With(AuthorityAction.class)
    public Result getDriver(Long id){

        Driver driver = Driver.find.byId(id);

        DriversPayload driverPayload = getSingleDriverPayload(driver);

        return ok(Json.toJson(driverPayload));
    }

    @With(AuthorityAction.class)
    public Result updateDriver(Http.Request request,Long id){
        JsonNode formData = request.body().asJson();

        if(formData == null){

            return badRequest("Please provide valid json data");

        } else {
            Driver driver = Driver.find.byId(id);

            String username = formData.findPath("username").textValue();
            String password = formData.findPath("password").textValue();
            String firstName = formData.findPath("firstName").textValue();
            String lastName = formData.findPath("lastName").textValue();
            String gender = formData.findPath("gender").textValue();
            String contactNumber = formData.findPath("contactNumber").textValue();
            String onlineStatus = formData.findPath("onlineStatus").textValue();
            int age = formData.findPath("age").intValue();

            driver.setAge(age);
            driver.setContactNumber(contactNumber);
            driver.setFirstName(firstName);
            driver.setLastName(lastName);
            driver.setGender(gender);
            driver.setUsername(username);
            driver.setPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
            if(onlineStatus.equals("Online")){

                driver.setOnlineStatus(true);

            }else if(onlineStatus.equals("Offline")) {

                driver.setOnlineStatus(false);

            } else {
                return badRequest("Invalid online status, select between online and offline");
            }

            driver.update();

            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(201);
            responsePayload.setStatusTitle("created");
            responsePayload.setMessage("Driver created successfully");
            return created(Json.toJson(responsePayload));
        }
    }

    @With(AuthorityAction.class)
    public Result deleteDriver(Long id){
        Driver driver = Driver.find.byId(id);
        driver.setDeleted(true);
        driver.save();

        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setStatusCode(200);
        responsePayload.setStatusTitle("ok");
        responsePayload.setMessage("Driver deleted successfully");
        return created(Json.toJson(responsePayload));
    }

    @With(AuthorityAction.class)
    public Result searchDrivers(@Optional String username,@Optional String onlineStatus,@Optional String licencePlate,@Optional String rating){

        boolean newStatus = false;
        if (username != null && onlineStatus != null) {

            //Search by username and online status

            if(onlineStatus.equals("online")){
                newStatus = true;
            }

            String sql = "SELECT username,password,first_name,last_name,id,age,online_status,gender,contact_number,deleted,date_created,date_modified,car_assigned_id FROM drivers WHERE username='"+username+"' OR online_status='"+newStatus+"'";

            RawSql rawSql = RawSqlBuilder.parse(sql).create();
            Query<Driver> query = Ebean.find(Driver.class);
            query.setRawSql(rawSql);

            List<Driver> drivers = query.findList();

            List<DriversPayload> driversPayload = getDriversPayload(drivers);

            return ok(Json.toJson(driversPayload));

        }
        else if (username == null && onlineStatus != null){

            //Search by online status
            if(onlineStatus.equals("online")){
                newStatus = true;
            }
            String sql = "SELECT username,password,first_name,last_name,id,age,online_status,gender,contact_number,deleted,date_created,date_modified,car_assigned_id FROM drivers WHERE online_status='"+newStatus+"'";

            RawSql rawSql = RawSqlBuilder.parse(sql).create();
            Query<Driver> query = Ebean.find(Driver.class);
            query.setRawSql(rawSql);

            List<Driver> drivers = query.findList();

            List<DriversPayload> driversPayload = getDriversPayload(drivers);

            return ok(Json.toJson(driversPayload));

        }

        else if (username != null && onlineStatus == null){

            //Search by username

            String sql = "SELECT username,password,first_name,last_name,id,age,online_status,gender,contact_number,deleted,date_created,date_modified,car_assigned_id FROM drivers WHERE username='"+username+"'";

            RawSql rawSql = RawSqlBuilder.parse(sql).create();
            Query<Driver> query = Ebean.find(Driver.class);
            query.setRawSql(rawSql);

            List<Driver> drivers = query.findList();

            List<DriversPayload> driversPayload = getDriversPayload(drivers);

            return ok(Json.toJson(driversPayload));

        } else if (licencePlate != null && rating == null){

            //Search by licencePlate
            //  Licence plate is unique so only a single result would be returned
            String sql = "SELECT licence_plate,convertible,rating,engine_type,colour,model,seat_count,speed_limit,manufacturer_id,driver_id FROM cars WHERE licence_plate='"+licencePlate+"'";

            RawSql rawSql = RawSqlBuilder.parse(sql).create();
            Query<Car> query = Ebean.find(Car.class);
            query.setRawSql(rawSql);

            Car car = query.findOne();

            if(car == null || car.getDriver() == null ) {
                return ok(Json.toJson(null));
            }

            //Return driver if assigned to car with matching licence plate
            DriversPayload driver = getSingleDriverPayload(car.getDriver());

            return ok(Json.toJson(driver));

        } else if( licencePlate == null && rating != null ) {
            //Search by rating

            String sql = "SELECT licence_plate,convertible,rating,engine_type,colour,model,seat_count,speed_limit,manufacturer_id,driver_id FROM cars WHERE rating='"+rating+"'";

            RawSql rawSql = RawSqlBuilder.parse(sql).create();
            Query<Car> query = Ebean.find(Car.class);
            query.setRawSql(rawSql);

            List<Car> cars = query.findList();

            if(cars == null) {
                return ok(Json.toJson(null));
            }

            //List<CarsPayload> carsPayload = getCarsPayload(car);

            List<DriversPayload>  driversPayload = new ArrayList<>();
            CarsPayload carPayload =  new CarsPayload();
            for (Car car: cars
            ) {
                //Only return driver if assigned to car with matched rating
                if(car.getDriver() != null) {
                    carPayload.setCarId(car.getId());
                    carPayload.setColour(car.getColour());
                    carPayload.setConvertible(car.isConvertible());
                    carPayload.setLicencePlate(car.getLicencePlate());
                    carPayload.setEngineType(car.getEngineType());
                    carPayload.setManufacturer(getManufacturerPayload(car.getManufacturer()));
                    carPayload.setModel(car.getModel());
                    carPayload.setRating(car.getRating());
                    carPayload.setSpeedLimit(car.getSpeedLimit());
                    carPayload.setDriverAssigned(getSingleDriverPayload(car.getDriver()));

                    driversPayload.add(carPayload.getDriverAssigned());
                }
            }

            return ok(Json.toJson(driversPayload));

        }
        else {

            return ok(Json.toJson(null));
        }

    }

    @With(AuthorityAction.class)
    public Result selectCar(Http.Request request) throws CarAlreadyInUseException{
        JsonNode formData = request.body().asJson();

        if(formData == null){

        }

        Long driverId = formData.findPath("driverId").longValue();
        Long carId = formData.findPath("carId").longValue();
        Car  car = Car.find.byId(carId);

        Driver  driver = Driver.find.byId(driverId);

        // Driver driver  = Driver.find("username",username).first();

        if(car == null || driver == null){
              ResponsePayload responsePayload = new ResponsePayload();
               responsePayload.setStatusCode(400);
               responsePayload.setStatusTitle("Bad request");
               responsePayload.setMessage("Invalid car/driver selection.");
               return badRequest(Json.toJson(responsePayload));
        }

        if(car.getDriver() == null){
            //Assign to car   null
            if(driver.isOnlineStatus()){
                if(driver.getCarAssigned() != null){
                    ResponsePayload responsePayload = new ResponsePayload();
                    responsePayload.setStatusCode(400);
                    responsePayload.setStatusTitle("Bad request");
                    responsePayload.setMessage("Another car is already in use by you, deselect active car to proceed new selection.");
                    return badRequest(Json.toJson(responsePayload));
                }
                car.setDriver(driver);
                driver.setCarAssigned(car);
                car.save();
                driver.save();
                ResponsePayload responsePayload = new ResponsePayload();
                responsePayload.setStatusCode(200);
                responsePayload.setStatusTitle("ok");
                responsePayload.setMessage("Car selected successfully.");
                return ok(Json.toJson(responsePayload));
            }else {
                ResponsePayload responsePayload = new ResponsePayload();
                responsePayload.setStatusCode(401);
                responsePayload.setStatusTitle("Bad request");
                responsePayload.setMessage("Can not select  a car while offline.");

                return badRequest(Json.toJson(responsePayload));
            }

        }else {
            throw new CarAlreadyInUseException();
        }
    }

    @With(AuthorityAction.class)
    public Result deselectCar(Http.Request request){
        JsonNode formData = request.body().asJson();

        if(formData == null){

        }
        Long driverId = formData.findPath("driverId").longValue();
        Long carId = formData.findPath("carId").longValue();
        Car  car = Car.find.byId(carId);

        Driver  driver = Driver.find.byId(driverId);

        // Driver driver  = Driver.find("username",username).first();

        if(car == null || driver == null){

            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(404);
            responsePayload.setStatusTitle("not found");
            responsePayload.setMessage("Car or driver not found");
            return ok(Json.toJson(responsePayload));

        }

        if(car.getDriver() == null){
            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(404);
            responsePayload.setStatusTitle("not found");
            responsePayload.setMessage("No car selected yet.");
            return ok(Json.toJson(responsePayload));
        }
        car.setDriver(null);
        driver.setCarAssigned(null);
        car.save();
        driver.save();

        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setStatusCode(200);
        responsePayload.setStatusTitle("ok");
        responsePayload.setMessage("Car deselected successfully");

        return ok(Json.toJson(responsePayload));
    }


    /**
     * Convenience method to set and get a list of drivers payload
     * @param drivers
     * @return
     */
    public List<DriversPayload> getDriversPayload(List<Driver> drivers){

        List<DriversPayload> driversPayload  = new ArrayList<>();

        for (Driver driver : drivers
        ) {
            //Only return drivers whose deleted status if false
            if(!driver.isDeleted()) {
                DriversPayload driversPojo = getSingleDriverPayload(driver);

                driversPayload.add(driversPojo);
            }
        }

        return driversPayload;
    }


    /**
     * Convenience method to set and get single driver payload
     * @param driver
     * @return
     */
    public DriversPayload getSingleDriverPayload(Driver driver){
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
        if(driver.getCarAssigned() == null){
            driverPayload.setCarAssigned(null);
        } else {
            driverPayload.setCarAssigned(getSingleCarPayload(driver.getCarAssigned()));
        }


        return driverPayload;
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
        carPayload.setSpeedLimit(car.getSpeedLimit());

        return carPayload;
    }

    /**
     * Convenience method to set manufacturer payload
     * @param manufacturer
     * @return
     */
    public ManufacturersPayload getManufacturerPayload(Manufacturer manufacturer){

        ManufacturersPayload manufacturersPayload = new ManufacturersPayload();

        manufacturersPayload.setName(manufacturer.getId());
        manufacturersPayload.setLocation(manufacturer.getLocation());
        manufacturersPayload.setDateEstablished(manufacturer.getDateEstablished());

        return manufacturersPayload;
    }



}
