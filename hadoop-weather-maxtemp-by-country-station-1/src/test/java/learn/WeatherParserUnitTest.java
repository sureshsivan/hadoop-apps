package learn;

import org.apache.hadoop.io.Text;
import org.testng.annotations.Test;

/**
 * Created by suren on 9/1/15.
 */
public class WeatherParserUnitTest {

    @Test
    public void testWeatherData2Parser(){
        //                    STN--- WBAN   YEARMODA    TEMP       DEWP      SLP        STP       VISIB      WDSP     MXSPD   GUST    MAX     MIN   PRCP   SNDP   FRSHTT
        Text val1 = new Text("030050 99999  19291001    45.3  4    40.0  4  1001.6  4  9999.9  0   17.1  4    4.5  4    8.9  999.9    51.1    44.1*  0.00I 999.9  000000");
        Text val2 = new Text("030050 99999  19291122    48.9  4    47.2  4  1001.8  4  9999.9  0    6.2  4   10.0  4   13.0  999.9  9999.9    48.0  99.99  999.9  010000");
        Text val3 = new Text("030050 99999  19291119    42.8  4    38.2  4   998.7  4  9999.9  0    9.3  4   19.2  4   36.9  999.9    46.9*   36.0  99.99  999.9  010000");
    }

}
