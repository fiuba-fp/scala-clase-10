name := "clase-10"

version := "0.1"

scalaVersion := "2.13.3"

//scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.1.1")

libraryDependencies ++= Seq(
  "org.typelevel"              %% "cats-laws"                 % "2.0.0" % Test,
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % "1.2.3" % Test,
  "org.scalatest"              %% "scalatest"                 % "3.2.2" % Test,
  "org.typelevel"              %% "discipline-scalatest"      % "2.0.1" % Test
)
