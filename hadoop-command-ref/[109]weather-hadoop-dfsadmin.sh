hdfs dfsadmin -fs hdfs://master1 -report
hdfs fsck hdfs://master1/

hadoop secondarynamenode -checkpoint force;
hadoop secondarynamenode -checkpoint force;
hadoop secondarynamenode -geteditsize;