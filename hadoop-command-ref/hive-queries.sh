SHOW TABLES;
SHOW FUNCTIONS;

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
ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'  LINES TERMINATED BY '\n'
LOCATION '/user/ubuntu/data/weather/staging/countries';
#TBLPROPERTIES ("skip.header.line.count"="1");

LOAD DATA LOCAL INPATH 'file:///public_dataset/weather1/country-list.txt'
INTO TABLE weather_countries_raw;

select st_code, st_name, country, state from weather_countries_raw limit 5;
select st_code, st_name, country, state from weather_countries_raw where fips_id !='"FIPS ID"' limit 5;
select count(1) from weather_countries_raw where fips_id =='"FIPS ID"';
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
