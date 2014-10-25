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


# Aliases created in ~/.bashrc file
function starthadoop(){
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start namenode;
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start secondarynamenode;
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start datanode;
        yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start nodemanager;
        yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start resourcemanager;
        mr-jobhistory-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo start historyserver;
}
function stophadoop(){
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop namenode;
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop secondarynamenode;
        hadoop-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop datanode;
        yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop nodemanager;
        yarn-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop resourcemanager;
        mr-jobhistory-daemon.sh --config $HADOOP_CONF_ROOT/conf.pseudo stop historyserver;
}

function startzoo(){
        zkServer.sh start;
}
function stopzoo(){
        zkServer.sh stop;
}
function starthbase(){
        start-hbase.sh;
        local-master-backup.sh  start   2;
        local-regionservers.sh start    3       4       5;
}
function stophbase(){
        stop-hbase.sh;
}

function starth(){
        starthadoop;
        startzoo;
        starthbase;
}
function stoph(){
        stophadoop;
        stopzoo;
        stophbase;
}





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

