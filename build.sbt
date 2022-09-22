val scala3Version = "3.1.3"
lazy val root = project
  .in(file("."))
  .settings(
    name := "afbot_scala",
    scalaVersion := scala3Version,
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.5",
  )
