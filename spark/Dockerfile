FROM debian

RUN apt update
RUN apt install wget default-jdk git python3 gdal-bin -y
RUN apt-get install -y curl

WORKDIR /tmp

RUN wget http://downloads.apache.org/spark/spark-3.1.2/spark-3.1.2-bin-hadoop3.2.tgz
RUN tar xvf spark-*
RUN mv spark-3.1.2-bin-hadoop3.2 /opt/spark

RUN apt install procps -y

ENV SPARK_HOME=/opt/spark
ENV PATH=${PATH}:${SPARK_HOME}/bin:${SPARK_HOME}/sbin
ENV PYSPARK_PYTHON=/usr/bin/python3

WORKDIR /home

COPY start.sh start.sh
COPY testDB.sql testDB.sql
COPY 2000_01_precip.tif 2000_01_precip.tif

RUN chmod +x start.sh

#NOTE: In the future the jars can be retrieved from maven / they can either be downloaded manually or pulled from maven at build time
RUN cd ${SPARK_HOME}/jars && \
wget "https://mvnrepository.com/artifact/org.locationtech.rasterframes/rasterframes_2.12/0.10.0" && \
wget "https://mvnrepository.com/artifact/org.locationtech.rasterframes/pyrasterframes_2.12/0.10.0" && \
wget "https://mvnrepository.com/artifact/org.locationtech.rasterframes/rasterframes-datasource_2.12/0.10.0"

COPY spark-defaults.conf /opt/spark/conf/spark-defaults.conf

EXPOSE 8050
EXPOSE 8051
EXPOSE 10000

CMD [ "./start.sh" ]
