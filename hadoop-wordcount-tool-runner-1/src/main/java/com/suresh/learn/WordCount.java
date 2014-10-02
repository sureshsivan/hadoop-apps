package com.suresh.learn;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

import java.io.IOException;

/**
 * Created by suren on 2/10/14.
 */
public class WordCount extends Configured implements Tool{

    @Override
    public int run(String[] args) throws Exception {
        

        return 0;
    }

    public static void main(String [] args) throws IOException, ClassNotFoundException, InterruptedException {

    }

}
