// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nate/Documents/play-workspace/cars-and-drivers-service/conf/routes
// @DATE:Mon Oct 19 11:10:54 WAT 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseCarController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarController.createCar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/cars/create"})
        }
      """
    )
  
    // @LINE:9
    def getCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarController.getCar",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/cars/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:15
    def deleteCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarController.deleteCar",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/cars/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:13
    def updateCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarController.updateCar",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/cars/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:7
    def getAllCars: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarController.getAllCars",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/cars"})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseAuthorizationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def generateKey: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthorizationController.generateKey",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/authorization/generate-key"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseDriverController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def selectCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.selectCar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/select-car"})
        }
      """
    )
  
    // @LINE:23
    def createDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.createDriver",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/create"})
        }
      """
    )
  
    // @LINE:25
    def updateDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.updateDriver",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/update/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:27
    def deleteDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.deleteDriver",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def searchDrivers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.searchDrivers",
      """
        function(username0,onlineStatus1,licencePlate2,rating3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/search" + _qS([(username0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("username", username0)), (onlineStatus1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("onlineStatus", onlineStatus1)), (licencePlate2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("licencePlate", licencePlate2)), (rating3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("rating", rating3))])})
        }
      """
    )
  
    // @LINE:17
    def getAllDrivers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.getAllDrivers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers"})
        }
      """
    )
  
    // @LINE:41
    def deselectCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.deselectCar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/deselect-car"})
        }
      """
    )
  
    // @LINE:21
    def getDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.getDriver",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/drivers/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:46
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "docs/swagger-ui/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
    // @LINE:50
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
