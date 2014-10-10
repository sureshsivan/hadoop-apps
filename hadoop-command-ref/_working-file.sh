REGISTER /dev_tools/pig_default/lib/piggybank.jar
DEFINE SUBSTRING org.apache.pig.piggybank.evaluation.string.SUBSTRING();
DEFINE TRIM org.apache.pig.piggybank.evaluation.string.Trim();


hadoop fs -put /dev_tools/tmp/big_data/* "hdfs://localhost/data/weather/"
hadoop fs -mkdir /dev_tools/tmp/big_data/* "hdfs://localhost/data/weather/cleansed"

raw_countries = LOAD 'hdfs://localhost/data/weather/country-list.txt'
                AS (row:chararray);

countries_filtered = FILTER raw_countries BY (NOT (INDEXOF(row, 'FIPS ID', 0) != -1));

countries_master = FOREACH countries_filtered  GENERATE
                    (chararray) TRIM(SUBSTRING(row, 0, 12)) AS country_id,
                    (chararray) TRIM(SUBSTRING(row, 12, 20)) AS country_name;


to_print = LIMIT countries_master 10;
DUMP to_print;

STORE countries_master INTO 'hdfs://localhost/data/weather/cleansed/countries_master.tsv';



raw_stations = LOAD 'hdfs://localhost/data/weather/ish-history.csv'
                USING PigStorage(',')
                AS (usaf:chararray,
                    wban:chararray,
                    st_name:chararray,
                    ctry:chararray,
                    fips:chararray,
                    state:chararray,
                    call:chararray,
                    lat:chararray,
                    lon:chararray,
                    elev:chararray);

stations_filtered = FILTER raw_stations BY (NOT (INDEXOF(usaf, '"USAF"', 0) != -1));

station_master = FOREACH stations_filtered  GENERATE
                    (int) TRIM(REPLACE(usaf, '"', '')) AS station_id,
                    (chararray) TRIM(REPLACE(st_name, '"', '')) AS st_name,
                    (chararray) TRIM(REPLACE(ctry, '"', '')) AS country,
                    (chararray) TRIM(REPLACE(fips, '"', '')) AS fips,
                    (chararray) TRIM(REPLACE(state, '"', '')) AS state,
                    (float) TRIM(REPLACE(lat, '"', '')) AS latitude,
                    (float) TRIM(REPLACE(lon, '"', '')) AS longitude,
                    (float) TRIM(REPLACE(elev, '"', '')) AS elevation;

#to_print = LIMIT station_master 10;
#DUMP to_print;

STORE station_master INTO 'hdfs://localhost/data/weather/cleansed/station_master.tsv';










raw_weather = LOAD 'hdfs://localhost/data/weather/gsod/20*/*'
                AS (row:chararray);

#raw_weather = LOAD 'hdfs://master1/user/ubuntu/data/staging/weather/gsod/{2000,2001,2002}'
#                AS (row:chararray);


weather_filtered = FILTER raw_weather BY (NOT (INDEXOF(row, 'STN--', 0) != -1));

weather_master = FOREACH weather_filtered  GENERATE
	      (int)TRIM(SUBSTRING(row, 0, 6)) AS station,
	      (int)TRIM(SUBSTRING(row, 7,12)) AS wban,
	      (int)TRIM(SUBSTRING(row, 14, 22)) AS ymd,
	      (float)TRIM(SUBSTRING(row, 24, 29)) AS temp_avg,
	      (float)TRIM(SUBSTRING(row, 102, 107)) AS temp_max,
	      (float)TRIM(SUBSTRING(row, 110, 115)) AS temp_min,
	      (float)TRIM(SUBSTRING(row, 78, 82)) AS windspeed_avg,
	      (float)TRIM(SUBSTRING(row, 95, 99)) AS windspeed_max,
	      (float)TRIM(SUBSTRING(row, 68, 72)) AS visibility,
	      (float)TRIM(SUBSTRING(row, 118, 122)) AS precipitation;

#to_print = LIMIT weather_master 10;
#DUMP to_print;

STORE weather_master INTO 'hdfs://localhost/data/weather/cleansed/weather_master.tsv';


hadoop fs -getmerge /reports/some_output /mnt/hdfs/reports/some_output.txt