// @GENERATOR:play-routes-compiler
// @SOURCE:/home/nate/Documents/play-workspace/cars-and-drivers-service/conf/routes
// @DATE:Mon Oct 19 11:10:54 WAT 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
