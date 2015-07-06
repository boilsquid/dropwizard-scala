name := "dropwizard-scala"

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.8.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.1"
)

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil

enablePlugins(JavaAppPackaging)

