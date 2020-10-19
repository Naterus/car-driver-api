// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nate/Documents/play-workspace/cars-and-drivers-service/conf/routes
// @DATE:Mon Oct 19 11:10:54 WAT 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseCarController CarController = new controllers.ReverseCarController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAuthorizationController AuthorizationController = new controllers.ReverseAuthorizationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDriverController DriverController = new controllers.ReverseDriverController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseCarController CarController = new controllers.javascript.ReverseCarController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAuthorizationController AuthorizationController = new controllers.javascript.ReverseAuthorizationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDriverController DriverController = new controllers.javascript.ReverseDriverController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
