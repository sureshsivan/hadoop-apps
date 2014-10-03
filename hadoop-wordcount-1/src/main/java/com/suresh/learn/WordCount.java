package com.suresh.learn;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;

/**
 * Created by suren on 2/10/14.
 */
public class WordCount {

    public static void main(String [] args) throws IOException, ClassNotFoundException, InterruptedException {

        JobConf wordCountJobConf = new JobConf();

//        MultipleInputs.addInputPath(wordCountJobConf, new Path(args[0]), TextInputFormat.class, null);


        wordCountJobConf.setJarByClass(WordCount.class);
        wordCountJobConf.setJobName("Simple Word count job");
//        wordCountJobConf.setMapperClass(null);
//        wordCountJobConf.setReducerClass(null);
//        wordCountJobConf.setPartitionerClass(null);
//        wordCountJobConf.setCombinerClass(null);

        FileInputFormat.addInputPath(wordCountJobConf, new Path(args[0]));
        FileOutputFormat.setOutputPath(wordCountJobConf, new Path(args[1]));

        JobClient.runJob(wordCountJobConf).waitForCompletion();

//        Job wordCountJob = new Job(wordCountJobConf);
//        boolean success = wordCountJob.waitForCompletion(true);
//        System.exit(success ? 0 : 1);
    }

}
