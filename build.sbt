val scala3Version = "3.1.3"
lazy val root = project
  .in(file("."))
  .settings(
    name := "afbot_scala",
    scalaVersion := scala3Version,
    libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % "3.7.6",
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.5",
  )
