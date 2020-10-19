// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nate/Documents/play-workspace/cars-and-drivers-service/conf/routes
// @DATE:Mon Oct 19 11:10:54 WAT 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  CarController_1: controllers.CarController,
  // @LINE:17
  DriverController_3: controllers.DriverController,
  // @LINE:43
  AuthorizationController_0: controllers.AuthorizationController,
  // @LINE:46
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    CarController_1: controllers.CarController,
    // @LINE:17
    DriverController_3: controllers.DriverController,
    // @LINE:43
    AuthorizationController_0: controllers.AuthorizationController,
    // @LINE:46
    Assets_2: controllers.Assets
  ) = this(errorHandler, CarController_1, DriverController_3, AuthorizationController_0, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CarController_1, DriverController_3, AuthorizationController_0, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars""", """controllers.CarController.getAllCars(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/""" + "$" + """id<[^/]+>""", """controllers.CarController.getCar(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/create""", """controllers.CarController.createCar(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/update/""" + "$" + """id<[^/]+>""", """controllers.CarController.updateCar(request:Request, id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/delete/""" + "$" + """id<[^/]+>""", """controllers.CarController.deleteCar(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers""", """controllers.DriverController.getAllDrivers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/search""", """controllers.DriverController.searchDrivers(username:String ?= null, onlineStatus:String ?= null, licencePlate:String ?= null, rating:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/""" + "$" + """id<[^/]+>""", """controllers.DriverController.getDriver(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/create""", """controllers.DriverController.createDriver(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/update/""" + "$" + """id<[^/]+>""", """controllers.DriverController.updateDriver(request:Request, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/delete/""" + "$" + """id<[^/]+>""", """controllers.DriverController.deleteDriver(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/select-car""", """controllers.DriverController.selectCar(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/drivers/deselect-car""", """controllers.DriverController.deselectCar(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/authorization/generate-key""", """controllers.AuthorizationController.generateKey(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """docs/swagger-ui/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/lib/swagger-ui", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_CarController_getAllCars0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars")))
  )
  private[this] lazy val controllers_CarController_getAllCars0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CarController_1.getAllCars(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarController",
      "getAllCars",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/v1/cars""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CarController_getCar1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarController_getCar1_invoker = createInvoker(
    CarController_1.getCar(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarController",
      "getCar",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/v1/cars/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_CarController_createCar2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/create")))
  )
  private[this] lazy val controllers_CarController_createCar2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CarController_1.createCar(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarController",
      "createCar",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/v1/cars/create""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CarController_updateCar3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/update/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarController_updateCar3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CarController_1.updateCar(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarController",
      "updateCar",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "PUT",
      this.prefix + """api/v1/cars/update/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CarController_deleteCar4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CarController_deleteCar4_invoker = createInvoker(
    CarController_1.deleteCar(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarController",
      "deleteCar",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """api/v1/cars/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_DriverController_getAllDrivers5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers")))
  )
  private[this] lazy val controllers_DriverController_getAllDrivers5_invoker = createInvoker(
    DriverController_3.getAllDrivers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "getAllDrivers",
      Nil,
      "GET",
      this.prefix + """api/v1/drivers""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_DriverController_searchDrivers6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/search")))
  )
  private[this] lazy val controllers_DriverController_searchDrivers6_invoker = createInvoker(
    DriverController_3.searchDrivers(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "searchDrivers",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """api/v1/drivers/search""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_DriverController_getDriver7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DriverController_getDriver7_invoker = createInvoker(
    DriverController_3.getDriver(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "getDriver",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/v1/drivers/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_DriverController_createDriver8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/create")))
  )
  private[this] lazy val controllers_DriverController_createDriver8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DriverController_3.createDriver(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "createDriver",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/v1/drivers/create""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_DriverController_updateDriver9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/update/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DriverController_updateDriver9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DriverController_3.updateDriver(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "updateDriver",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "PUT",
      this.prefix + """api/v1/drivers/update/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_DriverController_deleteDriver10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DriverController_deleteDriver10_invoker = createInvoker(
    DriverController_3.deleteDriver(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "deleteDriver",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/v1/drivers/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_DriverController_selectCar11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/select-car")))
  )
  private[this] lazy val controllers_DriverController_selectCar11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DriverController_3.selectCar(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "selectCar",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/v1/drivers/select-car""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_DriverController_deselectCar12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/drivers/deselect-car")))
  )
  private[this] lazy val controllers_DriverController_deselectCar12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DriverController_3.deselectCar(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "deselectCar",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/v1/drivers/deselect-car""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_AuthorizationController_generateKey13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/authorization/generate-key")))
  )
  private[this] lazy val controllers_AuthorizationController_generateKey13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AuthorizationController_0.generateKey(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthorizationController",
      "generateKey",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/v1/authorization/generate-key""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_Assets_at14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("docs/swagger-ui/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at14_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """docs/swagger-ui/""" + "$" + """file<.+>""",
      """## NoDocs ###""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_Assets_versioned15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned15_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """## NoDocs ###
 Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_CarController_getAllCars0_route(params@_) =>
      call { 
        controllers_CarController_getAllCars0_invoker.call(
          req => CarController_1.getAllCars(req))
      }
  
    // @LINE:9
    case controllers_CarController_getCar1_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CarController_getCar1_invoker.call(CarController_1.getCar(id))
      }
  
    // @LINE:11
    case controllers_CarController_createCar2_route(params@_) =>
      call { 
        controllers_CarController_createCar2_invoker.call(
          req => CarController_1.createCar(req))
      }
  
    // @LINE:13
    case controllers_CarController_updateCar3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CarController_updateCar3_invoker.call(
          req => CarController_1.updateCar(req, id))
      }
  
    // @LINE:15
    case controllers_CarController_deleteCar4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CarController_deleteCar4_invoker.call(CarController_1.deleteCar(id))
      }
  
    // @LINE:17
    case controllers_DriverController_getAllDrivers5_route(params@_) =>
      call { 
        controllers_DriverController_getAllDrivers5_invoker.call(DriverController_3.getAllDrivers)
      }
  
    // @LINE:19
    case controllers_DriverController_searchDrivers6_route(params@_) =>
      call(params.fromQuery[String]("username", Some(null)), params.fromQuery[String]("onlineStatus", Some(null)), params.fromQuery[String]("licencePlate", Some(null)), params.fromQuery[String]("rating", Some(null))) { (username, onlineStatus, licencePlate, rating) =>
        controllers_DriverController_searchDrivers6_invoker.call(DriverController_3.searchDrivers(username, onlineStatus, licencePlate, rating))
      }
  
    // @LINE:21
    case controllers_DriverController_getDriver7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DriverController_getDriver7_invoker.call(DriverController_3.getDriver(id))
      }
  
    // @LINE:23
    case controllers_DriverController_createDriver8_route(params@_) =>
      call { 
        controllers_DriverController_createDriver8_invoker.call(
          req => DriverController_3.createDriver(req))
      }
  
    // @LINE:25
    case controllers_DriverController_updateDriver9_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DriverController_updateDriver9_invoker.call(
          req => DriverController_3.updateDriver(req, id))
      }
  
    // @LINE:27
    case controllers_DriverController_deleteDriver10_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DriverController_deleteDriver10_invoker.call(DriverController_3.deleteDriver(id))
      }
  
    // @LINE:39
    case controllers_DriverController_selectCar11_route(params@_) =>
      call { 
        controllers_DriverController_selectCar11_invoker.call(
          req => DriverController_3.selectCar(req))
      }
  
    // @LINE:41
    case controllers_DriverController_deselectCar12_route(params@_) =>
      call { 
        controllers_DriverController_deselectCar12_invoker.call(
          req => DriverController_3.deselectCar(req))
      }
  
    // @LINE:43
    case controllers_AuthorizationController_generateKey13_route(params@_) =>
      call { 
        controllers_AuthorizationController_generateKey13_invoker.call(
          req => AuthorizationController_0.generateKey(req))
      }
  
    // @LINE:46
    case controllers_Assets_at14_route(params@_) =>
      call(Param[String]("path", Right("/public/lib/swagger-ui")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at14_invoker.call(Assets_2.at(path, file))
      }
  
    // @LINE:50
    case controllers_Assets_versioned15_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned15_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
