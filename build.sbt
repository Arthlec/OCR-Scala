name := "Projet_final"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "12.0.2-R18",
  "com.lihaoyi" %% "os-lib" % "0.4.2",
  "net.sourceforge.tess4j" % "tess4j" % "4.4.0",
//  "com.sksamuel.scrimage" %% "scrimage-core_2.11" % "2.1.0",
//  "com.sksamuel.scrimage" %% "scrimage-io-extra_2.11" % "2.1.0",
//  "com.sksamuel.scrimage" %% "scrimage-filters_2.11" % "2.1.0"
)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaSource in Compile := baseDirectory.value / "src"