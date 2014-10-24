clone from github;
mvn package;
hadoop jar ./hadoop-weather-maxtemp-by-country-station/target/hadoopMaxTempByCountryStation-1.0-SNAPSHOT.jar WeatherDataParserDriver hdfs://localhost/data/weather/prod/weather_data.tsv ;
hadoop fs -cat