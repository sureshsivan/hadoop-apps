sudo find / -name "piggybank.jar";
pig;
REGISTER /dev_tools/pig_default/lib/piggybank.jar;
DEFINE SUBSTRING org.apache.pig.piggybank.evaluation.string.SUBSTRING();
DEFINE TRIM org.apache.pig.piggybank.evaluation.string.Trim();

raw_countries = LOAD 'hdfs://master1/user/ubuntu/data/weather/raw/country-list.txt' AS (row:chararray);
countries_headerless = FILTER raw_countries BY (NOT (INDEXOF(row, 'FIPS ID', 0) != -1));
countries_formatted = FOREACH countries_headerless  GENERATE
                    (chararray) TRIM(SUBSTRING(row, 0, 12)) AS country_code,
                    (chararray) TRIM(SUBSTRING(row, 12, 52)) AS country_name;
raw_stations = LOAD 'hdfs://master1/user/ubuntu/data/weather/raw/isd-history.csv'
                USING PigStorage(',')
                AS (usaf:chararray,
                    wban:chararray,
                    st_name:chararray,
                    ctry:chararray,
                    state:chararray,
                    lat:chararray,
                    lon:chararray,
                    elev:chararray);
stations_headerless = FILTER raw_stations BY (NOT (INDEXOF(usaf, '"USAF"', 0) != -1));
stations_formatted = FOREACH stations_headerless  GENERATE
                    (chararray) TRIM(REPLACE(usaf, '"', '')) AS station_id,
                    (chararray) TRIM(REPLACE(st_name, '"', '')) AS st_name,
                    (chararray) TRIM(REPLACE(ctry, '"', '')) AS country_code,
                    (chararray) TRIM(REPLACE(state, '"', '')) AS state,
                    (float) TRIM(REPLACE(lat, '"', '')) AS latitude,
                    (float) TRIM(REPLACE(lon, '"', '')) AS longitude,
                    (float) TRIM(REPLACE(elev, '"', '')) AS elevation;
raw_weather = LOAD 'hdfs://master1/user/ubuntu/data/weather/raw/200*/*' AS (row:chararray);
weather_headerless = FILTER raw_weather BY (NOT (INDEXOF(row, 'STN--', 0) != -1));
weather_formatted = FOREACH weather_headerless  GENERATE
	      (chararray)TRIM(SUBSTRING(row, 0, 6)) AS station_id,
	      (int)TRIM(SUBSTRING(row, 7,12)) AS wban,
	      (int)TRIM(SUBSTRING(row, 14, 22)) AS ymd,
	      (float)TRIM(SUBSTRING(row, 24, 29)) AS temp_avg,
	      (float)TRIM(SUBSTRING(row, 78, 82)) AS windspeed_avg,
	      (float)TRIM(SUBSTRING(row, 68, 72)) AS visibility,
	      (float)TRIM(SUBSTRING(row, 118, 122)) AS precipitation;

station_country_joined = JOIN countries_formatted by (country_code) , stations_formatted by (country_code);
station_country_weather_joined = JOIN station_country_joined by (station_id), weather_formatted by (station_id);
station_country_weather_projected = FOREACH station_country_weather_joined GENERATE
                                        weather_formatted::ymd,
                                        weather_formatted::temp_avg,
                                        weather_formatted::windspeed_avg,
                                        weather_formatted::visibility,
                                        weather_formatted::precipitation,
                                        countries_formatted::country_name,
                                        stations_formatted::st_name,
                                        stations_formatted::country_code,
                                        stations_formatted::state,
                                        stations_formatted::latitude,
                                        stations_formatted::longitude,
                                        stations_formatted::elevation;
weather_data = rank station_country_weather_projected;
STORE weather_data INTO 'hdfs://master1/user/ubuntu/data/weather/staging';
quit;

echo -e 'RECORD_ID\tDATE\tTEMP\tWINDSPD\tVISIB\tPERCIP\tCOUNTRY\tSTATIONNAME\tCOUNTRYCODE\tSTATE\tLATITUDE\tLONGITUDE\tELEVATION' > /tmp/_weather_header;
hadoop fs -moveFromLocal /tmp/_weather_header hdfs://master1/user/ubuntu/data/weather/staging;
hadoop fs -rm hdfs://master1/user/ubuntu/data/weather/staging/_SUCCESS;
hadoop fs -ls hdfs://master1/user/ubuntu/data/weather/staging;
hadoop fs -getmerge hdfs://master1/user/ubuntu/data/weather/staging/* /tmp/200__weather_data.tsv;
more /tmp/200__weather_data.tsv;
hadoop fs -mkdir hdfs://master1/user/ubuntu/data/weather/prod;
hadoop fs -moveFromLocal /tmp/200__weather_data.tsv hdfs://master1/user/ubuntu/data/weather/prod;
hadoop fs -cat hdfs://master1/user/ubuntu/data/weather/prod/200__weather_data.tsv | head;
hadoop fs -rmr hdfs://master1/user/ubuntu/data/weather/staging;
hadoop fs -rmr hdfs://master1/user/ubuntu/data/weather/raw;
hadoop fs -rm hdfs://master1/user/ubuntu/data/weather/*.tsv;

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

######################################################################################
######################################################################################