ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "M323"
  )
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.7"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.18.0" % "test"

