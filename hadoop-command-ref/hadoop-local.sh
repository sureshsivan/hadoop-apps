export HADOOP_CONF_DIR=/dev_tools/tools/hadoop/conf/conf.pseudo
export HADOOP_CONF_DIR=$HADOOP_CONF_ROOT/conf.pseudo
rm -rf /tmp/hadoop-suren/dfs/name/*;
rm -rf /dev_tools/tools/hadoop/logs/*;
rm -rf /dev_tools/tools/hadoop/data/dfs.data/*;
rm -rf /dev_tools/tools/hadoop/data/dfs.name/*;
rm -rf /dev_tools/tools/hadoop/data/fs.checkpoint/*;
rm -rf /dev_tools/tools/hadoop/data/hadoop.tmp/dfs/namesecondary/*;
hadoop namenode -format;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start namenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start secondarynamenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start datanode;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start nodemanager;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start resourcemanager;
mr-jobhistory-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start historyserver;



hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop namenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop secondarynamenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop datanode;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop nodemanager;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop resourcemanager;
mr-jobhistory-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop historyserver;




rm -rf /tmp/hadoop-suren/dfs/name/*;
rm -rf /dev_tools/tools/hadoop/logs/*;
rm -rf /dev_tools/tools/hadoop/data/dfs.data/*;
rm -rf /dev_tools/tools/hadoop/data/dfs.name/*;
rm -rf /dev_tools/tools/hadoop/data/fs.checkpoint/*;
rm -rf /dev_tools/tools/hadoop/data/hadoop.tmp/dfs/namesecondary/*;
hadoop namenode -format;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start namenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start secondarynamenode;
hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start datanode;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start nodemanager;
yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start resourcemanager;
mr-jobhistory-daemon.sh --config $HADOOP_CONF_ROOT/conf.local start historyserver;



hadoop fs -ls "hdfs://localhost/"

