package learn;

import org.apache.hadoop.conf.Configuration;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by suren on 15/2/15.
 */
public class HadoopConfigurationTest {

    @Test
    public void testHAdoopConfigurationApi(){
        Configuration conf = new Configuration();
        conf.addResource("test-config.xml");

        for(Map.Entry<String, String> entry: conf){
            System.out.println("####################################");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("####################################");
        }

        System.out.println(conf.get("height-color-arr"));

    }
}
