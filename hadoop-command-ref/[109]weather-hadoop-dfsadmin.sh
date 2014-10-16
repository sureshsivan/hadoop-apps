hdfs dfsadmin -fs hdfs://master1 -report;
hdfs dfsadmin -report;
hdfs fsck hdfs://master1/;
hdfs dfs -expunge;

hadoop secondarynamenode -checkpoint force;
hadoop secondarynamenode -checkpoint force;
hadoop secondarynamenode -geteditsize;