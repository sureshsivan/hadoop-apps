package learn.partitioner;

import learn.domain.WeatherDataWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by suren on 19/10/14.
 */
public class CountryPartitioner extends Partitioner<Text, WeatherDataWritable>{



    @Override
    public int getPartition(Text text, WeatherDataWritable weatherDataWritable, int numPartitions) {
        return weatherDataWritable.getCountryCode().hashCode() % numPartitions;
    }
}
