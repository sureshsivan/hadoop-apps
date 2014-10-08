SHOW TABLES;

hive -f ./script.hq
hive -e 'SELECT * FROM dummy'

CREATE EXTERNAL TABLE       \
    weather_stations        \
        (                   \
         st_code STRING,    \
         wban STRING,       \
         st_name STRING,    \
         country STRING,    \
         fips STRING,       \
         state STRING,      \
         cal STRING,        \
         lat STRING,        \
         lon STRING,        \
         elev STRING        \
        )                   \
COMMENT 'Weather Station Master Table'                                  \
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','                           \
LOCATION 'hdfs://master1'                                               \
tblproperties ("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH '/public_dataset/weather1/ish-history.csv'       \
INTO TABLE weather_stations;


CREATE EXTERNAL TABLE    \
    weather_data \
        (st_code STRING,
         year STRING,
         );  \
    LOAD DATA LOCAL INPATH './...'  \
    OVERWRITE INTO TABLE weather_data;


DROP TABLE weather_data;


