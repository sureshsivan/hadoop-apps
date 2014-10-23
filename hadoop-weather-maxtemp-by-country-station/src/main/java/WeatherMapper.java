import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by 743522 on 23-10-2014.
 */
public class WeatherMapper extends Mapper<LongWritable, Text, Text, Text> {


    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        super.setup(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        super.map(key, value, context);
    }
}
