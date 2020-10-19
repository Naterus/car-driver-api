
name := """cars-and-drivers-service"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SwaggerPlugin)

scalaVersion := "2.13.1"

swaggerDomainNameSpaces := Seq("models")

libraryDependencies ++= Seq(guice, evolutions, javaJdbc)

libraryDependencies += "com.h2database" % "h2" % "1.4.196"

libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"

libraryDependencies += "org.webjars" % "swagger-ui" % "3.35.0"





