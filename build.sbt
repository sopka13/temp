ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

lazy val root = (project in file("."))
  .settings(
    name := "simpleActors"
  )

lazy val akkaVersion = "2.9.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %%  "akka-actor-typed"    % akkaVersion,
  "ch.qos.logback"    %   "logback-classic"     % "1.2.11",
  "com.typesafe.akka" %%  "akka-cluster-typed"  % akkaVersion,
  "com.typesafe.akka" %%  "akka-remote"         % akkaVersion
)
