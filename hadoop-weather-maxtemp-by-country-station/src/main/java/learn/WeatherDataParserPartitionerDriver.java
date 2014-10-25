package learn;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Date;

/**
 * Created by suren on 24/10/14.
 */
public class WeatherDataParserPartitionerDriver extends Configured implements Tool {


    @Override
    public int run(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.printf("Usage: %s [generic options] <input> <output>\n", getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        Job job = new Job(getConf());
        job.setJarByClass(getClass());

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(WeatherDataWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(WeatherDataWritable.class);

        long time = new Date().getTime();

        job.setMapperClass(WeatherMapper.class);
//        job.setCombinerClass(WeatherReducer.class);
        job.setReducerClass(WeatherReducer.class);
        job.setPartitionerClass(getPartitioner(getConf().get("app.part", "YEAR")));
        job.setJobName("Weather Data Parser With Partitioner");

        job.setNumReduceTasks(10);

        String outputPath = "hdfs://localhost/user/ubuntu/jar-jobs/output/" + time;
        boolean jobCompletion = false;
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        jobCompletion = job.waitForCompletion(true);
        System.out.println("#################################################");
        System.out.println("#################################################");
        System.out.println("PATH : " + "hdfs://localhost/user/ubuntu/jar-jobs/output/" + time);
        System.out.println("#################################################");
        System.out.println("#################################################");
        return jobCompletion ? 0 : 1;
    }

    public static void main(String[] args) throws Exception{
        int exitCode = ToolRunner.run(new WeatherDataParserPartitionerDriver(), args);
        System.exit(exitCode);
    }

    public Class<? extends Partitioner> getPartitioner(String partKey){
        Class<? extends Partitioner> part = null;
        if(partKey.equals("YEAR")){
            part = YearPartitioner.class;
        } else if(partKey.equals("COUNTRY")){
            part = CountryPartitioner.class;
        } else if(partKey.equals("COUNTRY_STATION")){
            part = CountryStationPartitioner.class;
        } else {
            part = YearPartitioner.class;
        }
        return part;
    }

}
