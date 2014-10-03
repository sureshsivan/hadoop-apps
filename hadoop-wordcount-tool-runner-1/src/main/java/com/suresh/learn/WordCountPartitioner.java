package com.suresh.learn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.Arrays;

/**
 * Created by suren on 3/10/14.
 */
public class WordCountPartitioner extends Partitioner<Text, IntWritable> {

    @Override
    public int getPartition(Text key, IntWritable val, int numPartitions) {

        char[] weight1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] weight2 = {'k', 'k', 'm', 'n', 'o', 'q', 'r', 's', 't', 'u'};

        if(Arrays.asList(weight1).contains(key.toString().charAt(0))){
            return 0;
        } else if(Arrays.asList(weight1).contains(key.toString().charAt(0))){
            return 1;
        } else {
            return 2;
        }

    }
}
