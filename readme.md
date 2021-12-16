## SparkSQL --> Simple example with raster data with SPARK VERSION 2.4.7

Rasterframes in SQL: https://rasterframes.io/languages.html#sql

Rasterframes jar: https://repo1.maven.org/maven2/org/locationtech/rasterframes/pyrasterframes_2.11/0.9.1/

Sample data are [rain raster data](/spark/2000_01_precip.tif) in North Carolina for one year period.

## Running the test

1. Build and run Apache Spark, run OntopSpark (NOT CURRENTLY WORKING)
  ```console
  foo@bar:~$ sudo git clone https://github.com/apano-on/test-spark-datatypes.git rasterframes-raster-test
  foo@bar:~$ sudo cd rasterframes-raster-test
  foo@bar:~$ sudo git checkout test/rasterframes
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
