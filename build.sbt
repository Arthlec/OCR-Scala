name := "Projet_final"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.scalafx" %% "scalafx" % "12.0.2-R18"
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.4.2"

scalaSource in Compile := baseDirectory.value / "src"