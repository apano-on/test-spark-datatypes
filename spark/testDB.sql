DROP DATABASE IF EXISTS testDB CASCADE;

CREATE DATABASE IF NOT EXISTS testDB;
                          
CREATE TABLE testDB.test (
          id INT NOT NULL,
          testBoolean BOOLEAN NOT NULL,
          testByte BYTE NOT NULL,
          testTinyInt TINYINT NOT NULL,
          testShort SHORT NOT NULL,
          testSmallInt SMALLINT NOT NULL,
          testInt INT NOT NULL,
          testInteger INTEGER NOT NULL,
          testLong LONG NOT NULL,
          testBigInt BIGINT NOT NULL,
          testFloat FLOAT NOT NULL,
          testReal REAL NOT NULL,
          testDouble DOUBLE NOT NULL,
          testDate DATE NOT NULL,
          testTimestamp TIMESTAMP NOT NULL,
          testString STRING NOT NULL,
          testBinary BINARY NOT NULL,
          testDecimal DECIMAL(5,2) NOT NULL,
          testDec DEC(5,2) NOT NULL,
          testNumeric NUMERIC(5,2) NOT NULL);
          
INSERT INTO testDB.test
VALUES (1,FALSE,-128,127,-32768,32767,-2147483648,2147483647,-9223372036854775808,9223372036854775807,
10111111100010000000000000000000000000,10111111100010000000000000000000000000,10111111100010000000000000000000000000,CAST('2020-10-05' AS DATE),CAST('2020-10-05 16:24:46.15' AS TIMESTAMP),'PROVA123PROVA',CAST('PROVA123PROVA' AS BINARY),251.53,251.53,251.53);

CREATE TABLE testDB.pointraw (id int, _c0 string, _c1 string);

INSERT INTO testDB.pointraw VALUES(1, 1.1, 101.1);
INSERT INTO testDB.pointraw VALUES(2, 2.1, 102.1);

-- CREATE OR REPLACE TEMP VIEW pointdata AS
-- SELECT testDB.pointraw.id, ST_Point(cast(testDB.pointraw._c0 as Decimal(24,20)), cast(testDB.pointraw._c1 as Decimal(24,20))) AS pointshape
-- FROM testDB.pointraw;
