hadoop fs -mkdir -p hdfs://master1/user/ubuntu/data/weather/raw;
hadoop fs -put "file:///public_dataset/bakup/weather/gsod/200*/*" "hdfs://master1/user/ubuntu/data/weather/raw";
