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


######################################################################################
