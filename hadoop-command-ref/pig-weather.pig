pig;

######################################################################################
# Country Data
######################################################################################
raw_countries = LOAD 'hdfs://master1/user/ubuntu/data/staging/weather/country-list.txt'
                AS (row:chararray);

countries_filtered = FILTER raw_stations BY (NOT (INDEXOF(row, 'FIPS ID', 0)));

countries_master = FOREACH countries_filtered  GENERATRE
                    (chararray)TRIM(SUBSTRING(row, 0, 12)) AS country_id,
                    (chararray)TRIM(SUBSTRING(row, 12, 20)) AS country_name;

#to_print = LIMIT countries_master by 10;
#DUMP to_print;

STORE station_master INTO 'hdfs://master1/user/ubuntu/data/prod/weather';
######################################################################################



######################################################################################
# Stations Data
######################################################################################
raw_stations = LOAD 'hdfs://master1/user/ubuntu/data/staging/weather/ish-history.csv'
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

header_filtered = FILTER raw_stations BY (NOT (usaf MATCHES '\"USAF\"'));

station_master = FOREACH header_filtered  GENERATRE
                    (int) TRIM(REPLACE(usaf, "\"", "")) AS station_id,
                    (chararray) TRIM(REPLACE(st_name, "\"", "")) AS st_name,
                    (chararray) TRIM(REPLACE(ctry, "\"", "")) AS country,
                    (chararray) TRIM(REPLACE(fips, "\"", "")) AS fips,
                    (chararray) TRIM(REPLACE(state, "\"", "")) AS state,
                    (float) TRIM(REPLACE(lat, "\"", "")) AS latitude,
                    (float) TRIM(REPLACE(lon, "\"", "")) AS longitude,
                    (float) TRIM(REPLACE(elev, "\"", "")) AS elevation;

#to_print = LIMIT station_master by 10;
#DUMP to_print;

STORE station_master INTO 'hdfs://master1/user/ubuntu/data/prod/weather';
######################################################################################



######################################################################################
# Weather Data
######################################################################################
raw_weather = LOAD 'hdfs://master1/user/ubuntu/data/staging/weather/gsod/20*/*'
                AS (row:chararray);

#raw_weather = LOAD 'hdfs://master1/user/ubuntu/data/staging/weather/gsod/{2000,2001,2002}'
#                AS (row:chararray);


weather_filtered = FILTER raw_weather BY (NOT (INDEXOF(row, 'USAF', 0)));

weather_master = FOREACH weather_filtered  GENERATRE
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

#to_print = LIMIT weather_master by 10;
#DUMP to_print;

STORE station_master INTO 'hdfs://master1/user/ubuntu/data/prod/weather';

######################################################################################




######################################################################################
######################################################################################
#   PIG Excercises
######################################################################################
######################################################################################

countries = LOAD 'hdfs://master1/user/ubuntu/data/prod/weather/countries_master'
            USING PigStorage('\t')
            AS (country_id:chararray,
                country_name:chararray);

ten_countries = LIMIT countries by 10;
dump ten_countries;


