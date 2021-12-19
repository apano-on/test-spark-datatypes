FROM debian

RUN apt update
RUN echo "deb http://security.debian.org/debian-security stretch/updates main" >> /etc/apt/sources.list
RUN mkdir -p /usr/share/man/man1 && \
    apt-get update -y && \
    apt-get install -y openjdk-8-jdk

RUN apt-get install unzip -y && \
    apt-get autoremove -y
RUN apt install wget openjdk-8-jdk git python3 gdal-bin -y
RUN apt-get install -y curl

WORKDIR /tmp

RUN wget https://archive.apache.org/dist/spark/spark-2.4.7/spark-2.4.7-bin-hadoop2.7.tgz
RUN tar xvf spark-*
RUN mv spark-2.4.7-bin-hadoop2.7 /opt/spark

RUN apt install procps -y

ENV SPARK_HOME=/opt/spark
ENV PATH=${PATH}:${SPARK_HOME}/bin:${SPARK_HOME}/sbin
ENV PYSPARK_PYTHON=/usr/bin/python3

WORKDIR /home

COPY start.sh start.sh
COPY testDB.sql testDB.sql
COPY 2000_01_precip.tif 2000_01_precip.tif

RUN chmod +x start.sh

COPY pyrasterframes-assembly-0.9.1.jar ${SPARK_HOME}/jars/pyrasterframes-assembly-0.9.1.jar
COPY pyrasterframes-assembly-0.9.1.jar pyrasterframes-assembly-0.9.1.jar
COPY config-1.4.1.jar ${SPARK_HOME}/jars/config-1.4.1.jar
COPY config-1.4.1.jar config-1.4.1.jar

RUN cd ${SPARK_HOME}/jars && \
wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/rasterframes_2.11/0.9.1/rasterframes_2.11-0.9.1.jar" && \
wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/pyrasterframes_2.11/0.9.1/pyrasterframes_2.11-0.9.1.jar" && \
wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/rasterframes-datasource_2.11/0.9.1/rasterframes-datasource_2.11-0.9.1.jar"

RUN wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/pyrasterframes_2.11/0.9.1/pyrasterframes_2.11-0.9.1.jar"

RUN wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/rasterframes_2.11/0.9.1/rasterframes_2.11-0.9.1.jar" && \
wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/pyrasterframes_2.11/0.9.1/pyrasterframes_2.11-0.9.1.jar" && \
wget "https://repo1.maven.org/maven2/org/locationtech/rasterframes/rasterframes-datasource_2.11/0.9.1/rasterframes-datasource_2.11-0.9.1.jar"

COPY spark-defaults.conf /opt/spark/conf/spark-defaults.conf

EXPOSE 8050
EXPOSE 8051
EXPOSE 10000

CMD [ "./start.sh" ]
