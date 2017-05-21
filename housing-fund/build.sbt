
name := "housing-fund"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % "2.4.0",
    "org.jsoup"         % "jsoup"                                 % "1.8+",
    "commons-validator" % "commons-validator"                     % "1.5+",
    "org.scalatest"     %% "scalatest"                            % "3.0.1"     % "test",
    "org.junit"             % "junit"                                 % "4.12"      % "test"
  )
}