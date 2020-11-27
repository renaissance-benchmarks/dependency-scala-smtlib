lazy val scalaSMTLib = (project in file("."))
  .settings(
    name := "scala-smtlib",
    organization := "com.regblanc",
    scalacOptions := Seq("-unchecked", "-deprecation", "-feature"),
    crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.12", "2.13.4"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.4" % "test",
    licenses := Seq("MIT-style" -> url("https://opensource.org/licenses/MIT")),
    exportJars := true,
    Test / parallelExecution := true
  )
