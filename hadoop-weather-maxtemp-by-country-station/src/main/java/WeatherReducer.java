import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by 743522 on 23-10-2014.
 */
public class WeatherReducer extends Reducer<Text, Text, Text, Text>{

    private int groupByFieldIdx;
    private String maxOrMin = "";
    private int valFieldIdx;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        Configuration config = context.getConfiguration();
        groupByFieldIdx = config.getInt("", 0);
        valFieldIdx = config.getInt("", 0);
        maxOrMin = config.get("", "MAX");
        super.setup(context);
    }

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
    }
}
