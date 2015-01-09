package learn.parser.spi;

import learn.domain.StationData2;
import learn.parser.Parseble;
import learn.parser.Parser;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public class StationData2Parser<T extends Parseble> implements Parser<StationData2> {

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
    public StationData2 parseFromText(Text rawTxt) {
        return parseFromText(rawTxt.toString());
    }

    @Override
    public StationData2 parseFromText(String stringData) {
        StationData2 data = new StationData2();
        String[] dataSplit = stringData.split(getSplit());
        data.setStation(Integer.parseInt(dataSplit[0]));
        data.setWban(Integer.parseInt(dataSplit[1]));
        data.setStationName(dataSplit[2]);
        data.setCountryCode((dataSplit[3]));
        data.setLatitude(Float.parseFloat(dataSplit[4]));
        data.setLongitude(Float.parseFloat(dataSplit[5]));
        data.setElevation(Float.parseFloat(dataSplit[6]));
        return data;
    }
}
