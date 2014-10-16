hadoop fs -mkdir -p hdfs://master1/user/ubuntu/data/weather/raw;


sudo mount /dev/xvdf /public_dataset/weather1
hadoop fs -put "file:///public_dataset/weather1/country-list.txt" "hdfs://master1/user/ubuntu/data/weather/raw/";
hadoop fs -put "file:///public_dataset/weather1/isd-history.csv" "hdfs://master1/user/ubuntu/data/weather/raw/";

hadoop fs -put "file:///public_dataset/weather1/gsod/2000" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2001" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2002" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2003" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2004" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2005" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2006" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2007" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2008" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/2009" "hdfs://master1/user/ubuntu/data/weather/raw";


hadoop fs -put "file:///public_dataset/weather1/gsod/1931" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1932" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1933" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1934" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1935" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1936" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1937" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1938" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1939" "hdfs://master1/user/ubuntu/data/weather/raw";
hadoop fs -put "file:///public_dataset/weather1/gsod/1940" "hdfs://master1/user/ubuntu/data/weather/raw";


hadoop fs -ls -h hdfs://master1/user/ubuntu/data/weather/staging;
hadoop fs -ls -h hdfs://master1/user/ubuntu/data/weather/raw;

hadoop fs -rm -r -skipTrash hdfs://master1/user/ubuntu/data/weather/staging;
hadoop fs -rm -r -skipTrash hdfs://master1/user/ubuntu/data/weather/raw;


hadoop fs -rm -r -skipTrash hdfs://master1/user/ubuntu/data/weather/raw/2000;
hadoop fs -rm -r -skipTrash hdfs://master1/user/ubuntu/data/weather/raw/2004;
hadoop fs -rm -r -skipTrash hdfs://master1/user/ubuntu/data/weather/raw/2005;


##hadoop fs -put "file:///public_dataset/weather1/gsod/200*" "hdfs://master1/user/ubuntu/data/weather/raw";
