name := """server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  evolutions,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "mysql" % "mysql-connector-java" % "5.1.36",
  "net.sf.dozer" % "dozer" % "5.4.0",
  "org.apache.commons" % "commons-collections4" % "4.1",
  "org.mockito" % "mockito-all" % "1.9.5",
  "org.apache.commons" % "commons-lang3" % "3.4"
)


