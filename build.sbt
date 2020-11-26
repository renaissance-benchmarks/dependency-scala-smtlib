enablePlugins(GitVersioning)

git.useGitDescribe := true

lazy val writeVersion = taskKey[File]("Writes project version into version.sbt")

writeVersion := {
  val out = file("version.sbt")
  IO.write(out, "version := "+'"'+ version.value +'"')
  out
}

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

scalacOptions ++= {
  val Seq(_, major, minor) = (scalaVersion in ThisBuild).value.split("\\.").toSeq.map(_.toInt)
  if (major <= 10 || (major == 11 && minor < 5)) Seq.empty
  else Seq("-Ypatmat-exhaust-depth", "40")
}

javaOptions in IntegrationTest ++= Seq("-Xss128M")

fork in IntegrationTest := true

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.4" % "test"

logBuffered in IntegrationTest := false

parallelExecution in Test := true

lazy val commonSettings = Seq(
  organization := "com.regblanc",
  name := "scala-smtlib",
  crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.12", "2.13.4")
)

lazy val root = (project in file(".")).
  configs(IntegrationTest).
  settings(commonSettings: _*).
  settings(Defaults.itSettings: _*)

licenses := Seq("MIT-style" -> url("https://opensource.org/licenses/MIT"))
