sudo -u hdfs hadoop fs -ls hdfs://master1;
sudo -u hdfs hadoop fs -chown ubuntu:ubuntu hdfs://172.31.18.160/user/ubuntu;
sudo find / -name "hadoop-examples.jar";
# Use this to copy all the data from client to HDFS - then use mv command to move it to [valid-data] directory
hadoop fs -mkdir -p hdfs://master1/user/ubuntu/data/input-data;
hadoop fs -mkdir -p hdfs://master1/user/ubuntu/data/valid-data;
hadoop fs -rm -r hdfs://master1/user/ubuntu/data/shakespeare-hdfs1/wordcount-output;

hadoop fs -put <dir> hdfs://master1/user/ubuntu/data/input-data;
hadoop fs -get hdfs://master1/user/ubuntu/data/input-data/<dir>;

hadoop jar /opt/cloudera/parcels/CDH-5.1.3-1.cdh5.1.3.p0.12/share/doc/hadoop-0.20-mapreduce/examples/hadoop-examples.jar    \
    wordcount  \
    hdfs://master1/user/ubuntu/data/shakespeare-hdfs1   \
    hdfs://master1/user/ubuntu/data/shakespeare-hdfs1/wordcount-output;
hadoop fs -rm -r hdfs://master1/user/ubuntu/data/wordcount-output


hadoop fs -count -q <dir>   # to get disk quota used



hadoop jar /opt/cloudera/parcels/CDH-5.1.3-1.cdh5.1.3.p0.12/share/doc/hadoop-0.20-mapreduce/examples/hadoop-examples.jar    \
 teragen <number of 100 byte rows> <output-dir>;
hadoop jar /opt/cloudera/parcels/CDH-5.1.3-1.cdh5.1.3.p0.12/share/doc/hadoop-0.20-mapreduce/examples/hadoop-examples.jar    \
 terasort <input dir> <output dir>;


