# Basic Repo for working with Spark + Scala
The purpose of this repo is to make sure you have everything set up to build and run a spark project locally.

## Pre-requisites
Please make sure you have the following installed
* Java 8
* Scala 2.11
* Sbt 1.1.x
* Apache Spark 2.4 with ability to run spark-submit locally

## Setup for local building and testing
* Clone this repo
* Build: sbt assembly
* Test: sbt test

Please confirm that all of the tests pass.

## Setup for local run with spark-submit
After running ```sbt assembly``` from the root directory run
```
spark-submit target/scala-2.12/data-transformations-assembly-0.1.jar 
```
to run the spark job locally.

Confirm that you see "Hello Spark" in the output.

If all the test passed locally and "Hello Spark" was in the output than your environment is set up and ready for a TW Data Engineering coding interview.

###


### Wordcount
* Sample data is available in the src/test/wordcount/data directory
This applications will count the occurrences of a word within a text file. By default this app will read from the words.txt file and write to the target folder.  Pass in the input source path and output path directory to the spark-submit command below if you wish to use different files.

```
spark-submit --master local[2]  --py-files thoughtworks.zip job_runner.py WordCount $(INPUT_LOCATION) $(OUTPUT_LOCATION)
```

Currently this application is a skeleton with ignored tests.  Please unignore the tests and build the wordcount application.

### Citibike multi-step pipeline
* Sample data is available in the src/test/citibike/data directory
This application takes bike trip information and calculates the "as the crow flies" distance traveled for each trip.  
The application is run in two steps.
* First the data will be ingested from a sources and transformed to parquet format.
* Then the application will read the parquet files and apply the appropriate transformations.


* To ingest data from external source to datalake:
```
spark-submit --master local[2]  --py-files thoughtworks.zip job_runner.py DailyDriver $(INPUT_LOCATION) $(OUTPUT_LOCATION)
```

* To transform Citibike data:
```
spark-submit --master local[2]  --py-files thoughtworks.zip job_runner.py CitiBikeTransformer $(INPUT_LOCATION) $(OUTPUT_LOCATION)
```

Currently this application is a skeleton with ignored tests.  Please unignore the tests and build the Citibike transformation application.

#### Tips
- For distance calculation, consider using [**Harvesine formula**](https://en.wikipedia.org/wiki/Haversine_formula) as an option.  
