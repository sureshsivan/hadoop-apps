package learn.domain;

import learn.parser.Parseble;
import learn.parser.Parser;
import learn.parser.spi.WeatherData2Parser;
import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 24/10/14.
 */
public class WeatherData2 implements Parseble {

    private int station;
    private int wban;

    private int year;
    private int month;
    private int day;

    private float temperature;
    private int temperatureReadCnt;

    private float dewPt;
    private int dewPtReadCnt;

    private float seaLvlPressure;
    private int seaLvlPressureReadCnt;

    private float stationPressure;
    private int stationPressureReadCnt;

    private float visibility;
    private int visibilityReadCnt;

    private float windspeed;
    private int windspeedReadCnt;

    private float maxSustainedWindspeedForDay;
    private float maxWindGustForDay;
    private float maxTemperatureForDay;
    private boolean maxTempDerivedFromHourlyData;
    private float minTemperatureForDay;
    private boolean minTempDerivedFromHourlyData;

    private float percipitation;
    private float snowDepth;

    private String frshttIndicator;

    private boolean fogDay;
    private boolean rainOrDrizzleDay;
    private boolean snowOrIcePelletDay;
    private boolean hailDay;
    private boolean thunderDay;
    private boolean tornadoOrFunnelCloudDay;

    private StationData2 stationData;
    private CountryDataData2 countryData;

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public int getWban() {
        return wban;
    }

    public void setWban(int wban) {
        this.wban = wban;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getTemperatureReadCnt() {
        return temperatureReadCnt;
    }

    public void setTemperatureReadCnt(int temperatureReadCnt) {
        this.temperatureReadCnt = temperatureReadCnt;
    }

    public float getDewPt() {
        return dewPt;
    }

    public void setDewPt(float dewPt) {
        this.dewPt = dewPt;
    }

    public int getDewPtReadCnt() {
        return dewPtReadCnt;
    }

    public void setDewPtReadCnt(int dewPtReadCnt) {
        this.dewPtReadCnt = dewPtReadCnt;
    }

    public float getSeaLvlPressure() {
        return seaLvlPressure;
    }

    public void setSeaLvlPressure(float seaLvlPressure) {
        this.seaLvlPressure = seaLvlPressure;
    }

    public int getSeaLvlPressureReadCnt() {
        return seaLvlPressureReadCnt;
    }

    public void setSeaLvlPressureReadCnt(int seaLvlPressureReadCnt) {
        this.seaLvlPressureReadCnt = seaLvlPressureReadCnt;
    }

    public float getStationPressure() {
        return stationPressure;
    }

    public void setStationPressure(float stationPressure) {
        this.stationPressure = stationPressure;
    }

    public int getStationPressureReadCnt() {
        return stationPressureReadCnt;
    }

    public void setStationPressureReadCnt(int stationPressureReadCnt) {
        this.stationPressureReadCnt = stationPressureReadCnt;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public int getVisibilityReadCnt() {
        return visibilityReadCnt;
    }

    public void setVisibilityReadCnt(int visibilityReadCnt) {
        this.visibilityReadCnt = visibilityReadCnt;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public int getWindspeedReadCnt() {
        return windspeedReadCnt;
    }

    public void setWindspeedReadCnt(int windspeedReadCnt) {
        this.windspeedReadCnt = windspeedReadCnt;
    }

    public float getMaxSustainedWindspeedForDay() {
        return maxSustainedWindspeedForDay;
    }

    public void setMaxSustainedWindspeedForDay(float maxSustainedWindspeedForDay) {
        this.maxSustainedWindspeedForDay = maxSustainedWindspeedForDay;
    }

    public float getMaxWindGustForDay() {
        return maxWindGustForDay;
    }

    public void setMaxWindGustForDay(float maxWindGustForDay) {
        this.maxWindGustForDay = maxWindGustForDay;
    }

    public float getMaxTemperatureForDay() {
        return maxTemperatureForDay;
    }

    public void setMaxTemperatureForDay(float maxTemperatureForDay) {
        this.maxTemperatureForDay = maxTemperatureForDay;
    }

    public boolean isMaxTempDerivedFromHourlyData() {
        return maxTempDerivedFromHourlyData;
    }

    public void setMaxTempDerivedFromHourlyData(boolean maxTempDerivedFromHourlyData) {
        this.maxTempDerivedFromHourlyData = maxTempDerivedFromHourlyData;
    }

    public float getMinTemperatureForDay() {
        return minTemperatureForDay;
    }

    public void setMinTemperatureForDay(float minTemperatureForDay) {
        this.minTemperatureForDay = minTemperatureForDay;
    }

    public boolean isMinTempDerivedFromHourlyData() {
        return minTempDerivedFromHourlyData;
    }

    public void setMinTempDerivedFromHourlyData(boolean minTempDerivedFromHourlyData) {
        this.minTempDerivedFromHourlyData = minTempDerivedFromHourlyData;
    }

    public float getPercipitation() {
        return percipitation;
    }

    public void setPercipitation(float percipitation) {
        this.percipitation = percipitation;
    }

    public float getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(float snowDepth) {
        this.snowDepth = snowDepth;
    }

    public String getFrshttIndicator() {
        return frshttIndicator;
    }

    public void setFrshttIndicator(String frshttIndicator) {
        this.frshttIndicator = frshttIndicator;
    }

    public boolean isFogDay() {
        return fogDay;
    }

    public void setFogDay(boolean fogDay) {
        this.fogDay = fogDay;
    }

    public boolean isRainOrDrizzleDay() {
        return rainOrDrizzleDay;
    }

    public void setRainOrDrizzleDay(boolean rainOrDrizzleDay) {
        this.rainOrDrizzleDay = rainOrDrizzleDay;
    }

    public boolean isSnowOrIcePelletDay() {
        return snowOrIcePelletDay;
    }

    public void setSnowOrIcePelletDay(boolean snowOrIcePelletDay) {
        this.snowOrIcePelletDay = snowOrIcePelletDay;
    }

    public boolean isHailDay() {
        return hailDay;
    }

    public void setHailDay(boolean hailDay) {
        this.hailDay = hailDay;
    }

    public boolean isThunderDay() {
        return thunderDay;
    }

    public void setThunderDay(boolean thunderDay) {
        this.thunderDay = thunderDay;
    }

    public boolean isTornadoOrFunnelCloudDay() {
        return tornadoOrFunnelCloudDay;
    }

    public void setTornadoOrFunnelCloudDay(boolean tornadoOrFunnelCloudDay) {
        this.tornadoOrFunnelCloudDay = tornadoOrFunnelCloudDay;
    }

    public StationData2 getStationData() {
        return stationData;
    }

    public void setStationData(StationData2 stationData) {
        this.stationData = stationData;
    }

    public CountryDataData2 getCountryData() {
        return countryData;
    }

    public void setCountryData(CountryDataData2 countryData) {
        this.countryData = countryData;
    }

    public WeatherData2Writable getWeatherData2Writable(){
        WeatherData2Writable writable = new WeatherData2Writable();
        writable.setStation(new IntWritable(getStation()));
        writable.setWban(new IntWritable(getWban()));
        writable.setYear(new IntWritable(getYear()));
        writable.setMonth(new IntWritable(getMonth()));
        writable.setDay(new IntWritable(getDay()));
        writable.setTemperature(new FloatWritable(getTemperature()));
        writable.setTemperatureReadCnt(new IntWritable(getTemperatureReadCnt()));
        writable.setDewPt(new FloatWritable(getDewPt()));
        writable.setDewPtReadCnt(new IntWritable(getDewPtReadCnt()));
        writable.setSeaLvlPressure(new FloatWritable(getSeaLvlPressure()));
        writable.setSeaLvlPressureReadCnt(new IntWritable(getSeaLvlPressureReadCnt()));
        writable.setStationPressure(new FloatWritable(getStationPressure()));
        writable.setStationPressureReadCnt(new IntWritable(getStationPressureReadCnt()));
        writable.setVisibility(new FloatWritable(getVisibility()));
        writable.setVisibilityReadCnt(new IntWritable(getVisibilityReadCnt()));
        writable.setWindspeed(new FloatWritable(getWindspeed()));
        writable.setWindspeedReadCnt(new IntWritable(getWindspeedReadCnt()));
        writable.setMaxSustainedWindspeedForDay(new FloatWritable(getMaxSustainedWindspeedForDay()));
        writable.setMaxWindGustForDay(new FloatWritable(getMaxWindGustForDay()));
        writable.setMaxTemperatureForDay(new FloatWritable(getMaxTemperatureForDay()));
        writable.setMaxTempDerivedFromHourlyData(new BooleanWritable(isMaxTempDerivedFromHourlyData()));
        writable.setMinTemperatureForDay(new FloatWritable(getMinTemperatureForDay()));
        writable.setMinTempDerivedFromHourlyData(new BooleanWritable(isMinTempDerivedFromHourlyData()));
        writable.setPercipitation(new FloatWritable(getPercipitation()));
        writable.setSnowDepth(new FloatWritable(getSnowDepth()));
        writable.setFrshttIndicator(new Text(getFrshttIndicator()));
        writable.setFogDay(new BooleanWritable(isFogDay()));
        writable.setRainOrDrizzleDay(new BooleanWritable(isRainOrDrizzleDay()));
        writable.setSnowOrIcePelletDay(new BooleanWritable(isSnowOrIcePelletDay()));
        writable.setHailDay(new BooleanWritable(isHailDay()));
        writable.setThunderDay(new BooleanWritable(isThunderDay()));
        writable.setTornadoOrFunnelCloudDay(new BooleanWritable(isTornadoOrFunnelCloudDay()));
        writable.setStationData(getStationData().getStationData2Writable());
        writable.setCountryData(getCountryData().getCountryDataData2Writable());

        return writable;
    }
    
    @Override
    public Parser<WeatherData2> getParser() {
        return new WeatherData2Parser<WeatherData2>();
    }

    @Override
    public String toString() {
        return "WeatherData2{" +
                "station=" + station +
                ", wban=" + wban +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", temperature=" + temperature +
                ", temperatureReadCnt=" + temperatureReadCnt +
                ", dewPt=" + dewPt +
                ", dewPtReadCnt=" + dewPtReadCnt +
                ", seaLvlPressure=" + seaLvlPressure +
                ", seaLvlPressureReadCnt=" + seaLvlPressureReadCnt +
                ", stationPressure=" + stationPressure +
                ", stationPressureReadCnt=" + stationPressureReadCnt +
                ", visibility=" + visibility +
                ", visibilityReadCnt=" + visibilityReadCnt +
                ", windspeed=" + windspeed +
                ", windspeedReadCnt=" + windspeedReadCnt +
                ", maxSustainedWindspeedForDay=" + maxSustainedWindspeedForDay +
                ", maxWindGustForDay=" + maxWindGustForDay +
                ", maxTemperatureForDay=" + maxTemperatureForDay +
                ", maxTempDerivedFromHourlyData=" + maxTempDerivedFromHourlyData +
                ", minTemperatureForDay=" + minTemperatureForDay +
                ", minTempDerivedFromHourlyData=" + minTempDerivedFromHourlyData +
                ", percipitation=" + percipitation +
                ", snowDepth=" + snowDepth +
                ", frshttIndicator='" + frshttIndicator + '\'' +
                ", fogDay=" + fogDay +
                ", rainOrDrizzleDay=" + rainOrDrizzleDay +
                ", snowOrIcePelletDay=" + snowOrIcePelletDay +
                ", hailDay=" + hailDay +
                ", thunderDay=" + thunderDay +
                ", tornadoOrFunnelCloudDay=" + tornadoOrFunnelCloudDay +
                '}';
    }
}
