## SparkSQL --> Simple example with raster data


Sedona raster operators: https://sedona.apache.org/api/sql/Raster-operators/

SparkSQL built-in functions reference: https://spark.apache.org/docs/latest/api/sql/index.html#built-in-functions

Sample data are [rain raster data](/spark/rain_raster_ds) in North Carolina over a five year period.

The data pipeline needs to use a [Sedona jar](/spark/SedonaSQLTemplate-assembly-0.1.0.jar) which can be built via [Scala](https://github.com/apache/incubator-sedona/tree/master/examples). A [sample file]() is provided which should replace the one in the Apache Sedona [example](https://github.com/apache/incubator-sedona/blob/master/examples/sql/src/main/scala/ScalaExample.scala).

## Running the test

1. Build and run Apache Spark, run OntopSpark
  ```console
  foo@bar:~$ sudo git clone https://github.com/apano-on/test-spark-datatypes.git sedona-raster-test
  foo@bar:~$ sudo cd sedona-raster-test
  foo@bar:~$ sudo git checkout test/sedona-raster
  foo@bar:~$ sudo docker-compose up
  ```

2. Connect to [_localhost:8080_](http://localhost:8080/)

3. Execute a query, e.g.

  ```
  PREFIX : <http://www.semanticweb.org/spark-datatypes-test#>

  SELECT * WHERE {
    ?sub :hasMean ?obj .
  }
  ```
