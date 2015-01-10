package learn.parser.spi;

import learn.domain.WeatherData2;
import learn.parser.Parseble;
import learn.parser.Parser;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public class WeatherData2Parser<T extends Parseble> implements Parser<WeatherData2> {

    @Override
    public WeatherData2 parseFromText(Text rawTxt) {
        return parseFromText(rawTxt.toString());
    }

    @Override
    public WeatherData2 parseFromText(String stringData) {
        WeatherData2 data = new WeatherData2();
        data.setStation(Integer.parseInt(stringData.substring(0, 6).trim()));
        data.setWban(Integer.parseInt(stringData.substring(7, 12).trim()));
        data.setYear(Integer.parseInt(stringData.substring(14, 18).trim()));
        data.setMonth(Integer.parseInt(stringData.substring(18, 20).trim()));
        data.setDay(Integer.parseInt(stringData.substring(20, 22).trim()));
        data.setTemperature(Float.parseFloat(stringData.substring(24, 30).trim()));
        data.setTemperatureReadCnt((Integer.parseInt(stringData.substring(31, 33).trim())));
        data.setDewPt(Float.parseFloat(stringData.substring(35, 41).trim()));
        data.setDewPtReadCnt(Integer.parseInt(stringData.substring(42, 44).trim()));
        data.setSeaLvlPressure(Float.parseFloat(stringData.substring(46, 52).trim()));
        data.setSeaLvlPressureReadCnt(Integer.parseInt(stringData.substring(53, 55).trim()));
        data.setStationPressure(Float.parseFloat(stringData.substring(57, 63).trim()));
        data.setStationPressureReadCnt(Integer.parseInt(stringData.substring(64, 66).trim()));
        data.setVisibility(Float.parseFloat(stringData.substring(68, 73).trim()));
        data.setVisibilityReadCnt(Integer.parseInt(stringData.substring(74, 76).trim()));
        data.setWindspeed(Float.parseFloat(stringData.substring(78, 83).trim()));
        data.setWindspeedReadCnt(Integer.parseInt(stringData.substring(84, 86).trim()));
        data.setMaxSustainedWindspeedForDay(Float.parseFloat(stringData.substring(88, 93).trim()));
        data.setMaxWindGustForDay(Float.parseFloat(stringData.substring(95, 100).trim()));
        data.setMaxTemperatureForDay(Float.parseFloat(stringData.substring(102, 108).trim()));
        data.setMaxTempDerivedFromHourlyData(WeatherConstants.STR_INDICATOR_FLAG_ASTERICK.equals(stringData.substring(108, 109).trim()));
        data.setMinTemperatureForDay(Float.parseFloat(stringData.substring(110, 116).trim()));
        data.setMinTempDerivedFromHourlyData(WeatherConstants.STR_INDICATOR_FLAG_ASTERICK.equals(stringData.substring(116, 117).trim()));
        data.setPercipitation(Float.parseFloat(stringData.substring(118, 123).trim()));
        data.setSnowDepth(Float.parseFloat(stringData.substring(125, 130).trim()));
        data.setFrshttIndicator(stringData.substring(132, 138).trim());

        data.setFogDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_FOG_DAY_DATA_INDEX));
        data.setRainOrDrizzleDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_RAIN_OR_DRIZZLE__DAY_DATA_INDEX));
        data.setSnowOrIcePelletDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_SNOW_OR_ICE_PELLET_DAY_DATA_INDEX));
        data.setHailDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_HAIL_DAY_DATA_INDEX));
        data.setThunderDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_THUNDER_DAY_DATA_INDEX));
        data.setTornadoOrFunnelCloudDay(WeatherConstants.CHAR_INDICATOR_FLAG_ONE == data.getFrshttIndicator().charAt(WeatherConstants.FRSHTT_TORNADO_OR_FUNNEL_CLOUD_DAY_DATA_INDEX));

        data.setStationData(null);  //  parse Station Data from distributed cache
        data.setCountryData(null);  //  parse Country Data from distributed cache

        return data;
    }


}
