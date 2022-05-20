ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "freqtemp"
  )

// https://mvnrepository.com/artifact/org.apache.tika/tika-core
libraryDependencies += "org.apache.tika" % "tika-core" % "2.4.0"
// https://mvnrepository.com/artifact/org.apache.tika/tika-parser-pdf-module
libraryDependencies += "org.apache.tika" % "tika-parser-pdf-module" % "2.4.0"
