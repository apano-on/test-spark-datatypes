### SparkSQL --> XML Schema datatypes conversion in ONTOP

</br>

SparkSQL reference : <https://spark.apache.org/docs/latest/sql-ref-datatypes.html>

W3C reccomended mappings : <https://www.w3.org/2001/sw/rdb2rdf/wiki/Mapping_SQL_datatypes_to_XML_Schema_datatypes>

</br>

| Spark datatype | SparkSQL name | W3C reccomandation | ONTOP default | ONTOP change |
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

## HOW TO RUN

1. Run the commands

  ```console
  foo@bar:~$ sudo ./docker-build.sh
  foo@bar:~$ sudo docker-compose up
  ```

2. Connect to: _localhost:8080_

3. Execute the query

        PREFIX : <http://www.semanticweb.org/spark-datatypes-test#>

        SELECT * WHERE {
          ?sub ?pred ?obj .
        }
