/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.log4j.{Level, Logger}
import org.apache.sedona.core.formatMapper.shapefileParser.ShapefileReader
import org.apache.sedona.core.spatialRDD.SpatialRDD
import org.apache.sedona.core.utils.SedonaConf
import org.apache.sedona.sql.utils.{Adapter, SedonaSQLRegistrator}
import org.apache.sedona.viz.core.Serde.SedonaVizKryoRegistrator
import org.apache.sedona.viz.sql.utils.SedonaVizRegistrator
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.{DataFrameWriter, SaveMode, SparkSession}
import org.locationtech.jts.geom.{Coordinate, Geometry, GeometryFactory}

object ScalaExample extends App{
  Logger.getLogger("org").setLevel(Level.WARN)
  Logger.getLogger("akka").setLevel(Level.WARN)

  var sparkSession:SparkSession = SparkSession.builder()
    .config("spark.serializer",classOf[KryoSerializer].getName)
    .config("spark.kryo.registrator", classOf[SedonaVizKryoRegistrator].getName)
    .appName("SedonaSQL-demo")
    .enableHiveSupport()
    .getOrCreate()


  var geotiffDF = sparkSession.read.format("geotiff")
    .option("dropInvalid", true)
    // Below change the link to either a folder or file e.g. ".load("2000_01_precip.tif")"
    // The folder or file needs to be added via the spark Dockerfile, and nothing else is needed here
    .load("rain_raster_ds")
  geotiffDF.printSchema()

  var geotiffDF_simplified = geotiffDF.selectExpr("image.origin as origin",
    "image.wkt as geom",
    "image.height as height",
    "image.width as width",
    "image.data as data",
    "image.nBands as bands")
  geotiffDF_simplified.printSchema()

  System.out.println("Create geotiff table")

  // Overwrite to avoid any duplication
  geotiffDF_simplified.write.mode("overwrite").option("header",true).saveAsTable("default.my_geotiff_table")

  System.out.println("All SedonaSQL tables have been materialized!")

}

