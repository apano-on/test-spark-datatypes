### SparkSQL --> XML Schema datatypes conversion in OntopSpark

</br>

SparkSQL reference : <https://spark.apache.org/docs/latest/sql-ref-datatypes.html>

W3C reccomended mappings : <https://www.w3.org/2001/sw/rdb2rdf/wiki/Mapping_SQL_datatypes_to_XML_Schema_datatypes>

</br>

| Spark datatype | SparkSQL name | W3C reccomandation | ONTOP default | OntopSpark |
|----------------|---------------|--------------------|---------------|---------------|
| BooleanType | BOOLEAN | xsd:boolean | xsd:boolean | |
| ByteType | BYTE, TINYINT | xsd:integer or subtype | xsd:integer | xsd:byte |
| ShortType | SHORT, SMALLINT | xsd:integer or subtype | xsd:integer | xsd:short |
| IntegerType | INT, INTEGER | xsd:integer or subtype | xsd:integer | xsd:int |
| LongType | LONG, BIGINT | xsd:integer or subtype | xsd:integer | xsd:long |
| FloatType | FLOAT, REAL | xsd:float or xsd:double | xsd:double | xsd:float |
| DoubleType | DOUBLE | xsd:double | xsd:double | |
| DateType | DATE | xsd:date | xsd:date | |
| TimestampType | TIMESTAMP | xsd:dateTime | xsd:dateTime | |
| StringType | STRING | xsd:string | xsd:string | |
| BinaryType | BINARY | xsd:hexBinary or xsd:base64Binary | xsd:hexBinary | |
| DecimalType | DECIMAL, DEC, NUMERIC | xsd:decimal | xsd:decimal | |

</br>

## Running the test

1. Build and run Apache Spark

  ```console
  foo@bar:~$ sudo ./docker-build.sh
  foo@bar:~$ sudo docker-compose -f docker-compose-spark.yml up
  ```

2. Wait Apache Spark complete startup, then run OntopSpark in another console window

  ```console
  foo@bar:~$ sudo docker-compose -f docker-compose-ontop.yml up
  ```

2. Connect to [_localhost:8080_](http://localhost:8080/)

3. Execute the query, and check the datatypes

  ```
  PREFIX : <http://www.semanticweb.org/spark-datatypes-test#>

  SELECT * WHERE {
    ?sub ?pred ?obj .
  }
  ```
