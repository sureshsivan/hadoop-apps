package learn.parser.spi;

import learn.domain.WeatherData1;
import learn.parser.Parser;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public class WeatherData1Parser implements Parser<WeatherData1>{

    private String split;

    public String getSplit() {
        return this.split == null ?
                WeatherConstants.DEFAULT_SPLIT :
                this.split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    @Override
    public WeatherData1 parseFromText(Text rawTxt) {
        WeatherData1 data = new WeatherData1();
        String[] dataSplit = rawTxt.toString().split(getSplit());
        data.setYear(Integer.parseInt(dataSplit[1].substring(0, 4)));
        data.setMonth(Integer.parseInt(dataSplit[1].substring(4, 6)));
        data.setDay(Integer.parseInt(dataSplit[1].substring(6, 8)));
        data.setTemp(Float.parseFloat(dataSplit[2]));
        data.setWindspeed(Float.parseFloat(dataSplit[3]));
        data.setVisibility(Float.parseFloat(dataSplit[4]));
        data.setPercipitation(Float.parseFloat(dataSplit[5]));
        data.setCountryName(dataSplit[6]);
        data.setStationName(dataSplit[7]);
        data.setCountryCode(dataSplit[8]);
        data.setStateCode(dataSplit[9]);
        data.setLatitude(Float.parseFloat(dataSplit[10]));
        data.setLongitude(Float.parseFloat(dataSplit[11]));
        data.setElevation(Float.parseFloat(dataSplit[12]));
        return data;
    }
}
