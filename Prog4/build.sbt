name := "Prog4"

version := "1.0"

scalaVersion := "2.10.0"

// set the main class for packaging the main jar
mainClass in (Compile, packageBin) := Some("Prog4")

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("Prog4")