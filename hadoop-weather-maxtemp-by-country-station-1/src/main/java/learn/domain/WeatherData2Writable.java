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
