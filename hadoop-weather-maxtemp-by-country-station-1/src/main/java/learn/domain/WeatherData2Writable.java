package learn.domain;

import org.apache.hadoop.io.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by suren on 24/10/14.
 */
public class WeatherData2Writable implements Writable {

    private IntWritable station = new IntWritable();
    private IntWritable wban = new IntWritable();

    private IntWritable year = new IntWritable();
    private IntWritable month = new IntWritable();
    private IntWritable day = new IntWritable();

    private FloatWritable temperature = new FloatWritable();
    private IntWritable temperatureReadCnt = new IntWritable();

    private FloatWritable dewPt = new FloatWritable();
    private IntWritable dewPtReadCnt = new IntWritable();

    private FloatWritable seaLvlPressure = new FloatWritable();
    private IntWritable seaLvlPressureReadCnt = new IntWritable();

    private FloatWritable stationPressure = new FloatWritable();
    private IntWritable stationPressureReadCnt = new IntWritable();

    private FloatWritable visibility = new FloatWritable();
    private IntWritable visibilityReadCnt = new IntWritable();

    private FloatWritable windspeed = new FloatWritable();
    private IntWritable windspeedReadCnt = new IntWritable();

    private FloatWritable maxSustainedWindspeedForDay = new FloatWritable();
    private FloatWritable maxWindGustForDay = new FloatWritable();
    private FloatWritable maxTemperatureForDay = new FloatWritable();
    private BooleanWritable maxTempDerivedFromHourlyData = new BooleanWritable();
    private FloatWritable minTemperatureForDay = new FloatWritable();
    private BooleanWritable minTempDerivedFromHourlyData = new BooleanWritable();

    private FloatWritable percipitation = new FloatWritable();
    private FloatWritable snowDepth = new FloatWritable();

    private Text frshttIndicator = new Text();

    private BooleanWritable fogDay = new BooleanWritable();
    private BooleanWritable rainOrDrizzleDay = new BooleanWritable();
    private BooleanWritable snowOrIcePelletDay = new BooleanWritable();
    private BooleanWritable hailDay = new BooleanWritable();
    private BooleanWritable thunderDay = new BooleanWritable();
    private BooleanWritable tornadoOrFunnelCloudDay = new BooleanWritable();


    public static WeatherData2Writable getWeatherData2Writable(WeatherData2 weatherData2){
        WeatherData2Writable writable = new WeatherData2Writable();
        return writable;
    }

    public IntWritable getStation() {
        return station;
    }

    public void setStation(IntWritable station) {
        this.station = station;
    }

    public IntWritable getWban() {
        return wban;
    }

    public void setWban(IntWritable wban) {
        this.wban = wban;
    }

    public IntWritable getYear() {
        return year;
    }

    public void setYear(IntWritable year) {
        this.year = year;
    }

    public IntWritable getMonth() {
        return month;
    }

    public void setMonth(IntWritable month) {
        this.month = month;
    }

    public IntWritable getDay() {
        return day;
    }

    public void setDay(IntWritable day) {
        this.day = day;
    }

    public FloatWritable getTemperature() {
        return temperature;
    }

    public void setTemperature(FloatWritable temperature) {
        this.temperature = temperature;
    }

    public IntWritable getTemperatureReadCnt() {
        return temperatureReadCnt;
    }

    public void setTemperatureReadCnt(IntWritable temperatureReadCnt) {
        this.temperatureReadCnt = temperatureReadCnt;
    }

    public FloatWritable getDewPt() {
        return dewPt;
    }

    public void setDewPt(FloatWritable dewPt) {
        this.dewPt = dewPt;
    }

    public IntWritable getDewPtReadCnt() {
        return dewPtReadCnt;
    }

    public void setDewPtReadCnt(IntWritable dewPtReadCnt) {
        this.dewPtReadCnt = dewPtReadCnt;
    }

    public FloatWritable getSeaLvlPressure() {
        return seaLvlPressure;
    }

    public void setSeaLvlPressure(FloatWritable seaLvlPressure) {
        this.seaLvlPressure = seaLvlPressure;
    }

    public IntWritable getSeaLvlPressureReadCnt() {
        return seaLvlPressureReadCnt;
    }

    public void setSeaLvlPressureReadCnt(IntWritable seaLvlPressureReadCnt) {
        this.seaLvlPressureReadCnt = seaLvlPressureReadCnt;
    }

    public FloatWritable getStationPressure() {
        return stationPressure;
    }

    public void setStationPressure(FloatWritable stationPressure) {
        this.stationPressure = stationPressure;
    }

    public IntWritable getStationPressureReadCnt() {
        return stationPressureReadCnt;
    }

    public void setStationPressureReadCnt(IntWritable stationPressureReadCnt) {
        this.stationPressureReadCnt = stationPressureReadCnt;
    }

    public FloatWritable getVisibility() {
        return visibility;
    }

    public void setVisibility(FloatWritable visibility) {
        this.visibility = visibility;
    }

    public IntWritable getVisibilityReadCnt() {
        return visibilityReadCnt;
    }

    public void setVisibilityReadCnt(IntWritable visibilityReadCnt) {
        this.visibilityReadCnt = visibilityReadCnt;
    }

    public FloatWritable getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(FloatWritable windspeed) {
        this.windspeed = windspeed;
    }

    public IntWritable getWindspeedReadCnt() {
        return windspeedReadCnt;
    }

    public void setWindspeedReadCnt(IntWritable windspeedReadCnt) {
        this.windspeedReadCnt = windspeedReadCnt;
    }

    public FloatWritable getMaxSustainedWindspeedForDay() {
        return maxSustainedWindspeedForDay;
    }

    public void setMaxSustainedWindspeedForDay(FloatWritable maxSustainedWindspeedForDay) {
        this.maxSustainedWindspeedForDay = maxSustainedWindspeedForDay;
    }

    public FloatWritable getMaxWindGustForDay() {
        return maxWindGustForDay;
    }

    public void setMaxWindGustForDay(FloatWritable maxWindGustForDay) {
        this.maxWindGustForDay = maxWindGustForDay;
    }

    public FloatWritable getMaxTemperatureForDay() {
        return maxTemperatureForDay;
    }

    public void setMaxTemperatureForDay(FloatWritable maxTemperatureForDay) {
        this.maxTemperatureForDay = maxTemperatureForDay;
    }

    public BooleanWritable getMaxTempDerivedFromHourlyData() {
        return maxTempDerivedFromHourlyData;
    }

    public void setMaxTempDerivedFromHourlyData(BooleanWritable maxTempDerivedFromHourlyData) {
        this.maxTempDerivedFromHourlyData = maxTempDerivedFromHourlyData;
    }

    public FloatWritable getMinTemperatureForDay() {
        return minTemperatureForDay;
    }

    public void setMinTemperatureForDay(FloatWritable minTemperatureForDay) {
        this.minTemperatureForDay = minTemperatureForDay;
    }

    public BooleanWritable getMinTempDerivedFromHourlyData() {
        return minTempDerivedFromHourlyData;
    }

    public void setMinTempDerivedFromHourlyData(BooleanWritable minTempDerivedFromHourlyData) {
        this.minTempDerivedFromHourlyData = minTempDerivedFromHourlyData;
    }

    public FloatWritable getPercipitation() {
        return percipitation;
    }

    public void setPercipitation(FloatWritable percipitation) {
        this.percipitation = percipitation;
    }

    public FloatWritable getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(FloatWritable snowDepth) {
        this.snowDepth = snowDepth;
    }

    public Text getFrshttIndicator() {
        return frshttIndicator;
    }

    public void setFrshttIndicator(Text frshttIndicator) {
        this.frshttIndicator = frshttIndicator;
    }

    public BooleanWritable getFogDay() {
        return fogDay;
    }

    public void setFogDay(BooleanWritable fogDay) {
        this.fogDay = fogDay;
    }

    public BooleanWritable getRainOrDrizzleDay() {
        return rainOrDrizzleDay;
    }

    public void setRainOrDrizzleDay(BooleanWritable rainOrDrizzleDay) {
        this.rainOrDrizzleDay = rainOrDrizzleDay;
    }

    public BooleanWritable getSnowOrIcePelletDay() {
        return snowOrIcePelletDay;
    }

    public void setSnowOrIcePelletDay(BooleanWritable snowOrIcePelletDay) {
        this.snowOrIcePelletDay = snowOrIcePelletDay;
    }

    public BooleanWritable getHailDay() {
        return hailDay;
    }

    public void setHailDay(BooleanWritable hailDay) {
        this.hailDay = hailDay;
    }

    public BooleanWritable getThunderDay() {
        return thunderDay;
    }

    public void setThunderDay(BooleanWritable thunderDay) {
        this.thunderDay = thunderDay;
    }

    public BooleanWritable getTornadoOrFunnelCloudDay() {
        return tornadoOrFunnelCloudDay;
    }

    public void setTornadoOrFunnelCloudDay(BooleanWritable tornadoOrFunnelCloudDay) {
        this.tornadoOrFunnelCloudDay = tornadoOrFunnelCloudDay;
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

    @Override
    public void write(DataOutput out) throws IOException {
        try {
            station.write(out);
            wban.write(out);
            year.write(out);
            month.write(out);
            day.write(out);
            temperature.write(out);
            dewPt.write(out);
            seaLvlPressure.write(out);
            stationPressure.write(out);
            visibility.write(out);
            windspeed.write(out);
            maxSustainedWindspeedForDay.write(out);
            maxWindGustForDay.write(out);
            maxTemperatureForDay.write(out);
            minTemperatureForDay.write(out);
            percipitation.write(out);
            snowDepth.write(out);
            fogDay.write(out);
            rainOrDrizzleDay.write(out);
            snowOrIcePelletDay.write(out);
            hailDay.write(out);
            thunderDay.write(out);
            tornadoOrFunnelCloudDay.write(out);
        } catch (Exception e) {
            this.toString();
            e.printStackTrace();
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        try {
            station.readFields(in);
            wban.readFields(in);
            year.readFields(in);
            month.readFields(in);
            day.readFields(in);
            temperature.readFields(in);
            dewPt.readFields(in);
            seaLvlPressure.readFields(in);
            stationPressure.readFields(in);
            visibility.readFields(in);
            windspeed.readFields(in);
            maxSustainedWindspeedForDay.readFields(in);
            maxWindGustForDay.readFields(in);
            maxTemperatureForDay.readFields(in);
            minTemperatureForDay.readFields(in);
            percipitation.readFields(in);
            snowDepth.readFields(in);
            fogDay.readFields(in);
            rainOrDrizzleDay.readFields(in);
            snowOrIcePelletDay.readFields(in);
            hailDay.readFields(in);
            thunderDay.readFields(in);
            tornadoOrFunnelCloudDay.readFields(in);
        } catch (Exception e) {
            this.toString();
            e.printStackTrace();
        }
    }
}
