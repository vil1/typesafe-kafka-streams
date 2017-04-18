import de.heikoseeberger.sbtheader.license.MIT
import sbt._

organization in ThisBuild := "fr.psug.kafka"

scalaVersion in ThisBuild := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

val kafkaVersion = "0.10.1.1"

lazy val core = project.in(file("core"))
  .settings(
      name := "typesafe-kafka-streams",
      libraryDependencies ++= Seq(
        "org.apache.kafka" % "kafka-streams" % kafkaVersion
      )
  )

lazy val cats = project.in(file("cats"))
  .dependsOn(core)
  .settings(
    name := "typesafe-kafka-streams-cats",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats" % "0.7.+" % Provided
    )
  )

resolvers in ThisBuild ++= Seq(
  "conjars.org" at "http://conjars.org/repo",
  "confluent" at "http://packages.confluent.io/maven/",
  "cakesolutions" at "http://dl.bintray.com/cakesolutions/maven/",
  Resolver.sonatypeRepo("snapshot"),
  Resolver.sonatypeRepo("releases")
)

headers := Map(
  "scala" -> MIT("2016", "Fred Cecilia, Valentin Kasas, Olivier Girardot")
)

// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "fr.psug"

// To sync with Maven central, you need to supply the following information:
pomExtra in Global := {
  <url>https://github.com/ogirardot/typesafe-kafka-streams</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://opensource.org/licenses/MIT</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/ogirardot/typesafe-kafka-streams</connection>
      <developerConnection>scm:git:git@github.com:ogirardot/typesafe-kafka-streams</developerConnection>
      <url>github.com/ogirardot/typesafe-kafka-streams</url>
    </scm>
    <developers>
      <developer>
        <id>ogirardot</id>
        <name>Olivier GIRARDOT</name>
        <url>https://www.linkedin.com/in/oliviergirardot</url>
      </developer>
    </developers>
}