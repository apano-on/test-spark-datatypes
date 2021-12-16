FROM debian

RUN apt update
RUN apt install wget default-jdk git python3 -y
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
COPY SedonaSQLTemplate-assembly-0.1.0.jar SedonaSQLTemplate-assembly-0.1.0.jar
COPY rain_raster_ds rain_raster_ds

RUN chmod +x start.sh

RUN cd ${SPARK_HOME}/jars && \
wget "https://search.maven.org/remotecontent?filepath=org/apache/sedona/sedona-python-adapter-3.0_2.12/1.1.0-incubating/sedona-python-adapter-3.0_2.12-1.1.0-incubating.jar" && \
wget "https://search.maven.org/remotecontent?filepath=org/apache/sedona/sedona-viz-3.0_2.12/1.1.0-incubating/sedona-viz-3.0_2.12-1.1.0-incubating.jar" && \
wget  "https://search.maven.org/remotecontent?filepath=org/datasyslab/geotools-wrapper/1.1.0-25.2/geotools-wrapper-1.1.0-25.2.jar"
COPY spark-defaults.conf /opt/spark/conf/spark-defaults.conf

EXPOSE 8050
EXPOSE 8051
EXPOSE 10000

CMD [ "./start.sh" ]
