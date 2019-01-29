package main

import org.apache.spark.sql.SparkSession
import org.scalatest.{FunSuite, Matchers}

class HelloSparkTest extends FunSuite with Matchers{
  test("true should be true") {
    true should be(true)
  }

  test("should use test spark session for spark tests") {
    val testAppName = "Test Spark Session"
    val spark = SparkSession
      .builder()
      .master("local")
      .appName(testAppName)
      .getOrCreate()
    spark.sparkContext.appName should be(testAppName)
  }

}
