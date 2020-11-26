enablePlugins(GitVersioning)

git.useGitDescribe := true

lazy val writeVersion = taskKey[File]("Writes project version into version.sbt")

writeVersion := {
  val out = file("version.sbt")
  IO.write(out, "version := "+'"'+ version.value +'"')
  out
}

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.4" % "test"

parallelExecution in Test := true

lazy val commonSettings = Seq(
  organization := "com.regblanc",
  name := "scala-smtlib",
  crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.12", "2.13.4")
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*)

licenses := Seq("MIT-style" -> url("https://opensource.org/licenses/MIT"))
