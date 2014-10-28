clone from github;
cd /tmp;
rm -r /tmp/hadoop-apps;
git clone https://github.com/v8-suresh/hadoop-apps.git;

rm -r /tmp/hadoop-apps;


cd hadoop-apps;
mvn package;
hadoop jar ./hadoop-weather-maxtemp-by-country-station/target/hadoopMaxTempByCountryStation-1.0-SNAPSHOT.jar WeatherDataParserDriver hdfs://localhost/data/weather/prod/weather_data.tsv ;
hadoop fs -cat