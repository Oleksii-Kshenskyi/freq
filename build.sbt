ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "freq"
  )

version := "0.1.0"

lazy val utils = (project in file("."))
  .settings(
    assembly / assemblyJarName := "freq.jar",
    // more settings here ...
  )

// https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "2.0.26"

Compile / scalaSource  := file("/src/main")
Compile / run / mainClass := Some("org.einax.freq.Freq")
