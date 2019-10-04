name := "Prog6"

version := "1.0"

scalaVersion := "2.10.0"

// set the main class for packaging the main jar
mainClass in (Compile, packageBin) := Some("Prog6")

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("Prog6")