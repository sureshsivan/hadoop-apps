##  To Put whole weather dataset folder into HDFS
hadoop fs -put public_dataset/weather1 hdfs://master1/user/ubuntu/data/staging/weather;

## To List files loaded into HDFS
hadoop fs -lsr hdfs://master1/user/ubuntu/data/staging/weather;


## Continue with [pig-weather.pig] file to do cleanup on weather files
## Like removing header rows
## That file also has some excercises
