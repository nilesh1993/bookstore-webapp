name := "just-play-scala"

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)


libraryDependencies+="org.scalatra.scalate" % "scalate-core_2.10" % "1.7.0"



libraryDependencies+="org.jsoup" % "jsoup" % "1.8.3"



libraryDependencies +="com.marklogic" % "marklogic-xcc" % "6.0.3"