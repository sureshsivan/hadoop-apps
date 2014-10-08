SHOW TABLES;
SHOW FUNCTIONS;
SET -v;

DESCRIBE FUNCTION <function_name>;

hive -f ./script.hq
hive -e 'SELECT * FROM dummy'


########################################################################################################################
##   Station Names Table creation
########################################################################################################################
SET skip.header.line.count = 1;

CREATE TABLE
    weather_stations_raw
        (
         st_code STRING,
         wban STRING,
         st_name STRING,
         country STRING,
         fips_id STRING,
         state STRING,
         cal STRING,
         lat STRING,
         lon STRING,
         elev STRING
        )
COMMENT 'Weather Station Master Table - Raw Data including Header Row'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','  LINES TERMINATED BY '\n'
LOCATION '/user/ubuntu/data/weather/staging/stations';
#TBLPROPERTIES ("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH 'file:///public_dataset/weather1/ish-history.csv'
INTO TABLE weather_stations_raw;

select st_code, st_name, country, state from weather_stations_raw limit 5;
select st_code, st_name, country, state from weather_stations_raw where st_code !='"USAF"' limit 5;
select count(1) from weather_stations_raw where st_code =='"USAF"';
select count(1) from weather_stations_raw ;

CREATE TABLE
    weather_stations
COMMENT 'Weather Station Master Table'
LOCATION '/user/ubuntu/data/weather/stations'
    AS
        SELECT
             st_code,
             wban,
             st_name,
             country,
             fips_id,
             state,
             cal,
             lat,
             lon,
             elev
         FROM
             weather_stations_raw
         WHERE
             st_code !='"USAF"'
        ;

select count(1) from weather_stations_raw ;
select count(1) from weather_stations ;


select st_code, st_name, country, state from weather_stations_raw where st_code !='"USAF"' limit 5;
select st_code, st_name, country, state from weather_stations where st_code !='"USAF"' limit 5;

DROP TABLE weather_stations_raw;

hadoop fs -rm -r hdfs://master1/user/ubuntu/data/weather/staging/stations;
#######################################################################################



########################################################################################################################
##   Country Names
########################################################################################################################
SET skip.header.line.count = 1;

CREATE TABLE
    weather_countries_raw
        (
         fips_id STRING,
         country_name STRING
        )
COMMENT 'Country Data Master Table - Raw Data including Header Row'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ' '  LINES TERMINATED BY '\n'
LOCATION '/user/ubuntu/data/weather/staging/countries';
#TBLPROPERTIES ("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH 'file:///public_dataset/weather1/country-list.txt'
INTO TABLE weather_countries_raw;

select st_code, st_name, country, state from weather_countries_raw limit 5;
select st_code, st_name, country, state from weather_countries_raw where fips_id !='FIPS ID' limit 5;
select count(1) from weather_countries_raw where fips_id =='FIPS ID';
select count(1) from weather_countries_raw ;

CREATE TABLE
    weather_countries
COMMENT 'Country Data Master Table'
LOCATION '/user/ubuntu/data/weather/countries'
    AS
        SELECT
             fips_id,
             country_name
         FROM
             weather_countries_raw
         WHERE
             fips_id =='"FIPS ID"'
        ;

select count(1) from weather_countries_raw ;
select count(1) from weather_countries ;


select st_code, st_name, country, state from weather_countries_raw where fips_id =='"FIPS ID"'; limit 5;
select st_code, st_name, country, state from weather_countries where fips_id =='"FIPS ID"'; limit 5;

DROP TABLE weather_countries_raw;

hadoop fs -rm -r hdfs://master1/user/ubuntu/data/weather/staging/countries;
#######################################################################################



########################################################################################################################
##   Weather Data
########################################################################################################################
SET skip.header.line.count = 1;

CREATE TABLE
    weather_data_raw
        (
         weather_txt STRING
        )
COMMENT 'Weather Data Master Table - Raw Data including Header Row'
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'  LINES TERMINATED BY '\n'
LOCATION '/user/ubuntu/data/weather/staging/weather_data';
#TBLPROPERTIES ("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH 'file:///public_dataset/weather1/gsod/*'
INTO TABLE weather_data_raw;

select st_code, st_name, country, state from weather_data_raw limit 5;
select st_code, st_name, country, state from weather_data_raw where weather_txt like'STN%' limit 5;
select count(1) from weather_data_raw where weather_txt not like'STN%';
select count(1) from weather_data_raw ;

CREATE TABLE
    weather_countries
COMMENT 'Country Data Master Table'
LOCATION '/user/ubuntu/data/weather/countries'
    AS
        SELECT
             substr(weather_txt, 1, 6) as st_code,
             substr(weather_txt, 8, 5) as wban,
             substr(weather_txt, 15, 4) as year,
             substr(weather_txt, 19, 2) as month,
             substr(weather_txt, 21, 2) as day,
             substr(weather_txt, 25, 6) as temp,
             substr(weather_txt, 36, 6) as dew_pt,
             substr(weather_txt, 47, 6) as sl_pressure,
             substr(weather_txt, 69, 6) as visibility,
             substr(weather_txt, 79, 5) as wind_speed,
             substr(weather_txt, 126, 5) as snow_depth
         FROM
             weather_countries_raw
         WHERE
             weather_txt not like'STN%'
        ;

select count(1) from weather_countries_raw ;
select count(1) from weather_countries ;


select st_code, st_name, country, state from weather_countries_raw where fips_id =='"FIPS ID"'; limit 5;
select st_code, st_name, country, state from weather_countries where fips_id =='"FIPS ID"'; limit 5;

DROP TABLE weather_countries_raw;

hadoop fs -rm -r hdfs://master1/user/ubuntu/data/weather/staging/countries;
#######################################################################################
