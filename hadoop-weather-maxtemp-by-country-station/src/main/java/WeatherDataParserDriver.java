import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
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
public class WeatherDataParserDriver extends Configured implements Tool {

    public static final float INVALID_TEMP = 99.9F;
    public static final float INVALID_WINDSPEED = 99.9F;
    public static final float INVALID_VISIBILITY = 99.9F;
    public static final float INVALID_PERCIPITATION = 99.9F;


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
        job.setCombinerClass(WeatherReducer.class);
        job.setReducerClass(WeatherReducer.class);
//        job.setPartitionerClass(WordCountPartitioner.class);
        job.setJobName("Weather Data Parser");

//        job.setNumReduceTasks(4);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://master1/user/ubuntu/jar-jobs/output/" + time));
        System.out.println("#################################################");
        System.out.println("PATH :" + "hdfs://master1/user/ubuntu/jar-jobs/output/" + time);
        System.out.println("#################################################");
        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception{
        int exitCode = ToolRunner.run(new WeatherDataParserDriver(), args);
        System.exit(exitCode);
    }
}
