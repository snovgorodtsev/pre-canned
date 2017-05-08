organization := "com.netaporter"

version := "0.0.8"

val scala211Version = "2.11.11"
val scala212Version = "2.12.2"

scalaVersion := scala211Version

crossScalaVersions := Seq(scala211Version, scala212Version)

name := "pre-canned"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val akka = "2.4.17"
val akkaHttp = "10.0.5"

libraryDependencies ++=
  "com.typesafe.akka" %% "akka-actor" % akka ::
  "com.typesafe.akka" %% "akka-http-core" % akkaHttp ::
  Nil

libraryDependencies ++=
  "com.typesafe.akka" %% "akka-testkit" % akka % "test" ::
  "org.scalatest" %% "scalatest" % "3.0.3" % "test" ::
  Nil

scalariformSettings

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/net-a-porter/pre-canned</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:net-a-porter/pre-canned.git</url>
      <connection>scm:git@github.com:net-a-porter/pre-canned.git</connection>
    </scm>
    <developers>
      <developer>
        <id>theon</id>
        <name>Ian Forsey</name>
        <url>http://theon.github.io</url>
      </developer>
    </developers>)