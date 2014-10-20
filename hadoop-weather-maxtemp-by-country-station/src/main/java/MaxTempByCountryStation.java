import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by suren on 19/10/14.
 */
public class MaxTempByCountryStation extends Configured implements Tool {


    @Override
    public int run(String[] args) throws Exception {

        return 0;
    }

    public static void main(String[] args) throws Exception{
        int exitCode = ToolRunner.run(new MaxTempByCountryStation(), args);
        System.exit(exitCode);
    }
}
