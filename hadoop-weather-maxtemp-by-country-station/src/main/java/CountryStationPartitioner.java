import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by suren on 19/10/14.
 */
public class CountryStationPartitioner extends Partitioner<String, String>{

    @Override
    public int getPartition(String s, String s2, int numPartitions) {
        return 0;
    }
}
