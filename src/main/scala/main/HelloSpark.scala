package main

import org.apache.spark.sql.SparkSession

object HelloSpark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Read Data with Spark").getOrCreate()
    println("Hello Spark")
    spark.stop()
  }

}
