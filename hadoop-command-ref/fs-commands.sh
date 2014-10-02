sudo -u hdfs hadoop fs -ls hdfs://master1;
sudo -u hdfs hadoop fs -chown ubuntu:ubuntu hdfs://172.31.18.160/user/ubuntu;
sudo find / -name "hadoop-examples.jar";
hadoop jar /opt/cloudera/parcels/CDH-5.1.3-1.cdh5.1.3.p0.12/share/doc/hadoop-0.20-mapreduce/examples/hadoop-examples.jar    \
    wordcount  \
    hdfs://master1/user/ubuntu/data/shakespeare-hdfs1   \
    hdfs://master1/user/ubuntu/data/shakespeare-hdfs1/wordcount-output;
hadoop fs -rm -r hdfs://master1/user/ubuntu/data/wordcount-output
