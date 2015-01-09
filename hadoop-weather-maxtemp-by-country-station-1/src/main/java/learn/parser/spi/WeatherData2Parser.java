package learn.parser.spi;

import learn.domain.WeatherData1;
import learn.domain.WeatherData2;
import learn.parser.Parseble;
import learn.parser.Parser;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public class WeatherData2Parser<T extends Parseble> implements Parser<WeatherData2> {

//    private String split;
//
//    public String getSplit() {
//        return this.split == null ?
//                WeatherConstants.DEFAULT_SPLIT :
//                this.split;
//    }
//
//    public void setSplit(String split) {
//        this.split = split;
//    }

    @Override
    public WeatherData2 parseFromText(Text rawTxt) {
        return parseFromText(rawTxt.toString());
    }

    @Override
    public WeatherData2 parseFromText(String stringData) {
        WeatherData2 data = new WeatherData2();
//        data.se
        return data;
    }


}
