# Java Play Backend REST API service implementation to manage Cars and Drivers

To run the car and drivers restful service, you will need the correct version of Java and a build tool. You can build Play projects with any Java build tool. Since sbt takes advantage of Play features such as auto-reload. 

Prerequisites include:

* Java Software Developer's Kit (SE) 1.8 or higher
* sbt 1.2.0 or higher (I recommend 1.3.4) the file includes an sbt distribution for your convenience.

To check your Java version, enter the following in a command window:

`java -version`

To check your sbt version, enter the following in a command window:

`sbt sbtVersion`

If you do not have the required versions, follow these links to obtain them:

* [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [sbt](http://www.scala-sbt.org/download.html)

## Run the project

To build and run the project:

1. Use a command window to change into the example project directory, for example: `cd car-driver-service`

2. Build the project. Enter: `sbt run`. The project builds and starts the embedded HTTP server. Since this downloads libraries and dependencies, the amount of time required depends partly on your connection's speed.

3. After the message `Server started, ...` displays, enter the following URL in a browser: <http://localhost:9000/api/v1/cars>

The Play application responds: `{
"statusCode": 401,
"statusTitle": "unauthorized",
"message": "Invalid/missing authorization key. Ensure you include valid authorization key in request header."
}`

## Access Api endpoints
1. Generate authorization token from the endpoint: <http://localhost:9000/api/v1/authorization/generate-key> - attach a raw json object to the request  e.g `{
   "name" : "John Doe",
   "email" : "johndoe1@example.com"
   }`. the response should contain  the authorization token. ensure you copy it.

2. Attach the generated token as a header parameter with the key :  authorization and value : <your-token> across all request (Preferably use postman to test). 

## Test with swagger
1. Swagger interface is integrated in the project. once the project runs successfully, you can access swagger-ui from the URL : <http://localhost:9000/docs/swagger-ui/index.html?url=/assets/swagger.json#/> 

2. You can get the list of endpoints in swagger Ui also.

## Example data
1. To create driver , add  raw json object to the request e.g `{
   "username" : "doe111",
   "password" : "12345",
   "age" : 45,
   "firstName" : "John",
   "lastName" : "Doe",
   "onlineStatus" : "Online",
   "contactNumber" : "0815558555u",
   "gender" : "Male"
   }`

2. To create car, add  raw json object to the request e.g `{
   "licencePlate": "Jyc-eee",
   "convertible": "Yes",
   "rating": 5,
   "engineType": "Electric",
   "colour": "Blue",
   "model": "2020",
   "manufacturer": "Innoson",
   "speedLimit": "360km/h"
   }`
   
3. To select/deselect car, add  raw json object to their endpoints e.g ` {
   "carId" : 1,
   "driverId" : 2
   }`
   
4. To update both car, add json payload to request e.g `   "licencePlate": "Jyc-eee",
   "convertible": "Yes",
   "rating": 5,
   "engineType": "Electric",
   "colour": "Blue",
   "model": "2020",
   "manufacturer": "Innoson",
   "speedLimit": "360km/h"
   }`
   
5. To update driver, add  raw json object to the request e.g `{
   "username" : "doe111",
   "password" : "12345",
   "age" : 45,
   "firstName" : "John",
   "lastName" : "Doe",
   "onlineStatus" : "Online",
   "contactNumber" : "0815558555u",
   "gender" : "Male"
   }`
