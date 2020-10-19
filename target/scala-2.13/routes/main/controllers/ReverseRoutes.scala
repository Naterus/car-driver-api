// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nate/Documents/play-workspace/cars-and-drivers-service/conf/routes
// @DATE:Mon Oct 19 11:10:54 WAT 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseCarController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createCar(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/cars/create")
    }
  
    // @LINE:9
    def getCar(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/cars/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:15
    def deleteCar(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/v1/cars/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:13
    def updateCar(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/v1/cars/update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:7
    def getAllCars(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/cars")
    }
  
  }

  // @LINE:43
  class ReverseAuthorizationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def generateKey(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/authorization/generate-key")
    }
  
  }

  // @LINE:17
  class ReverseDriverController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def selectCar(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/drivers/select-car")
    }
  
    // @LINE:23
    def createDriver(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/drivers/create")
    }
  
    // @LINE:25
    def updateDriver(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/v1/drivers/update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:27
    def deleteDriver(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/drivers/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:19
    def searchDrivers(username:String = null, onlineStatus:String = null, licencePlate:String = null, rating:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/drivers/search" + play.core.routing.queryString(List(if(username == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("username", username)), if(onlineStatus == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("onlineStatus", onlineStatus)), if(licencePlate == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("licencePlate", licencePlate)), if(rating == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("rating", rating)))))
    }
  
    // @LINE:17
    def getAllDrivers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/drivers")
    }
  
    // @LINE:41
    def deselectCar(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/drivers/deselect-car")
    }
  
    // @LINE:21
    def getDriver(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/drivers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:46
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/lib/swagger-ui"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "docs/swagger-ui/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:50
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
