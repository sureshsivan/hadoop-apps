package learn;

import org.apache.hadoop.conf.Configuration;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by suren on 15/2/15.
 */
public class HadoopConfigurationTest {

    @Test
    public void testHAdoopConfigurationApi(){
        Configuration conf = new Configuration();
        conf.addResource("test-config.xml");

        Iterator<Map.Entry<String, String>> it = conf.iterator();

        while(it.hasNext()){
            Map.Entry<String, String> prop = it.next();
            System.out.println("####################################");
            System.out.println(prop.getKey());
            System.out.println(prop.getValue());
            System.out.println("####################################");
        }
        System.out.println(conf.get("height-color-arr"));

    }
}
