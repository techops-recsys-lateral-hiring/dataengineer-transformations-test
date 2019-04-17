name := "data-transformations"

version := "0.1"

scalaVersion := "2.12.8"
val sparkVersion = "2.4.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "2.7.3"
libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.7.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
