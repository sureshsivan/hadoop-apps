package com.suresh.learn;

import com.google.common.hash.HashFunction;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by suren on 4/1/15.
 */
public class SparkWordCount {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[3]").setAppName("Word Count");
        System.out.println("#######################################");
        System.out.println(sparkConf.toDebugString());
        System.out.println("#######################################");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
//        HashFunction

        /**
         *
         * Hi Hello
         * Suresh
         * Hello Suresh
         * How Hi
         *
         *
         */
        String inputFilePath = "file:///tmp/testfile.txt";

        String outputFilePath = "file:///tmp/testfile.output";

        /**
         * [
         * {Hi Hello}   ,
         * {Suresh}     ,
         * {Hello Suresh},
         * {How Hi}
         * ]
         *
         *
         */
        JavaRDD<String> lines = sc.textFile(inputFilePath);


        /**
         * [
         * {Hi}         ,
         * {Hello}      ,
         * {Suresh}     ,
         * {Hello}      ,
         * {Suresh}     ,
         * {How}        ,
         * {Hi}         ,
         * ]
         *
         */
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) throws Exception {
                System.out.println("#### LINES : " + s);
                return Arrays.asList(s.split(" "));
            }
        });

        /**
         * [
         * {Hi, 1}         ,
         * {Hello, 1}      ,
         * {Suresh, 1}     ,
         * {Hello, 1}      ,
         * {Suresh, 1}     ,
         * {How, 1}        ,
         * {Hi, 1}         ,
         * ]
         *
         */
        JavaPairRDD<String, Integer> wcMapperOutput = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                System.out.println("#### WORDS : " + s);
                return new Tuple2<String, Integer>(s, 1);
//                return new Tuple2<String, Integer>(s.toLowerCase(), 1);
            }
        });

        /**
         * [
         * {Hi, 2}         ,
         * {Hello, 2}      ,
         * {Suresh, 2}     ,
         * {How, 1}        ,
         * ]
         *
         */
        JavaPairRDD<String, Integer> wcReducerOutput = wcMapperOutput.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }
        });

        wcReducerOutput.saveAsTextFile(outputFilePath);
        sc.stop();

    }

}
