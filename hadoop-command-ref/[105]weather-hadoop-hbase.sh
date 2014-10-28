#pig;
#
#set debug on;
#set mapreduce.task.io.sort.mb 20;
#weather_data_with_header = LOAD 'hdfs://localhost/data/weather/prod/weather_data.tsv'
#                AS (id:chararray,
#                    ymd:chararray,
#                    temp_avg:chararray,
#                    windspeed_avg:chararray,
#                    visibility:chararray,
#                    precipitation:chararray,
#                    country_name:chararray,
#                    st_name:chararray,
#                    country_code:chararray,
#                    state:chararray,
#                    latitude:chararray,
#                    longitude:chararray,
#                    elevation:chararray);
#
#STORE weather_data_with_header INTO 'hbase://weather_sample'
#    USING org.apache.pig.backend.hadoop.hbase.HBaseStorage(
#        'weather_data:dateymd,
#         weather_data:temp,
#         weather_data:windspeed,
#         weather_data:visibility,
#         weather_data:percipitation,
#         loc_data:country,
#         loc_data:station,
#         loc_data:station_code,
#         loc_data:state,
#         loc_data:latitude,
#         loc_data:longitude
#         loc_data:elevation'
#
#    );


hbase shell
create 'weather_sample_1', 'weather_data', 'loc_data'
hdfs://master1/user/ubuntu/data/weather/prod/200X_weather_data_subset.tsv
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,weather_data:dateymd,weather_data:temp,weather_data:windspeed,weather_data:visibility,weather_data:percipitation,loc_data:country,loc_data:station,loc_data:country_code,loc_data:state,loc_data:latitude,loc_data:longitude,loc_data:elevation weather_sample_1 hdfs://master1/user/ubuntu/data/weather/prod/200X_weather_data_subset.tsv;