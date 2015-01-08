package learn.domain;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by suren on 24/10/14.
 */
public class WeatherData1Writable implements Writable {

    private IntWritable year = new IntWritable();
    private IntWritable month = new IntWritable();
    private IntWritable day = new IntWritable();
    private FloatWritable temp = new FloatWritable();
    private FloatWritable windspeed = new FloatWritable();
    private FloatWritable visibility = new FloatWritable();
    private FloatWritable percipitation = new FloatWritable();
    private Text countryName = new Text();
    private Text stationName = new Text();
    private Text countryCode = new Text();
    private Text stateCode = new Text();
    private FloatWritable latitude = new FloatWritable();
    private FloatWritable longitude = new FloatWritable();
    private FloatWritable elevation = new FloatWritable();

    private WeatherData1Writable(){
    }


    public static WeatherData1Writable getWeatherData1Writable(WeatherData1 weather){

        WeatherData1Writable data = new WeatherData1Writable();
        data.setYear(new IntWritable(weather.getYear()));
        data.setMonth(new IntWritable(weather.getMonth()));
        data.setDay(new IntWritable(weather.getDay()));
        data.setTemp(new FloatWritable(weather.getTemp()));
        data.setWindspeed(new FloatWritable(weather.getWindspeed()));
        data.setVisibility(new FloatWritable(weather.getVisibility()));
        data.setPercipitation(new FloatWritable(weather.getPercipitation()));
        data.setCountryName(new Text(weather.getCountryName()));
        data.setStationName(new Text(weather.getStationName()));
        data.setCountryCode(new Text(weather.getCountryCode()));
        data.setStateCode(new Text(weather.getStateCode()));
        data.setLatitude(new FloatWritable(weather.getLatitude()));
        data.setLongitude(new FloatWritable(weather.getLongitude()));
        data.setElevation(new FloatWritable(weather.getElevation()));
        return data;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        try {
            year.write(out);
            month.write(out);
            day.write(out);
            temp.write(out);
            windspeed.write(out);
            visibility.write(out);
            percipitation.write(out);
            countryName.write(out);
            stationName.write(out);
            countryCode.write(out);
            stateCode.write(out);
            latitude.write(out);
            longitude.write(out);
            elevation.write(out);
        } catch (Exception e) {
            this.toString();
            e.printStackTrace();
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        try {
            year.readFields(in);
            month.readFields(in);
            day.readFields(in);
            temp.readFields(in);
            windspeed.readFields(in);
            visibility.readFields(in);
            percipitation.readFields(in);
            countryName.readFields(in);
            stationName.readFields(in);
            countryCode.readFields(in);
            stateCode.readFields(in);
            latitude.readFields(in);
            longitude.readFields(in);
            elevation.readFields(in);
        } catch (Exception e) {
            this.toString();
            e.printStackTrace();
        }
    }


    public IntWritable getYear() {
        return year;
    }

    public IntWritable getMonth() {
        return month;
    }

    public IntWritable getDay() {
        return day;
    }

    public FloatWritable getTemp() {
        return temp;
    }

    public FloatWritable getWindspeed() {
        return windspeed;
    }

    public FloatWritable getVisibility() {
        return visibility;
    }

    public FloatWritable getPercipitation() {
        return percipitation;
    }

    public Text getCountryName() {
        return countryName;
    }

    public Text getStationName() {
        return stationName;
    }

    public Text getCountryCode() {
        return countryCode;
    }

    public Text getStateCode() {
        return stateCode;
    }

    public FloatWritable getLatitude() {
        return latitude;
    }

    public FloatWritable getLongitude() {
        return longitude;
    }

    public FloatWritable getElevation() {
        return elevation;
    }

    public void setYear(IntWritable year) {
        this.year = year;
    }

    public void setMonth(IntWritable month) {
        this.month = month;
    }

    public void setDay(IntWritable day) {
        this.day = day;
    }

    public void setTemp(FloatWritable temp) {
        this.temp = temp;
    }

    public void setWindspeed(FloatWritable windspeed) {
        this.windspeed = windspeed;
    }

    public void setVisibility(FloatWritable visibility) {
        this.visibility = visibility;
    }

    public void setPercipitation(FloatWritable percipitation) {
        this.percipitation = percipitation;
    }

    public void setCountryName(Text countryName) {
        this.countryName = countryName;
    }

    public void setStationName(Text stationName) {
        this.stationName = stationName;
    }

    public void setCountryCode(Text countryCode) {
        this.countryCode = countryCode;
    }

    public void setStateCode(Text stateCode) {
        this.stateCode = stateCode;
    }

    public void setLatitude(FloatWritable latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(FloatWritable longitude) {
        this.longitude = longitude;
    }

    public void setElevation(FloatWritable elevation) {
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return "learn.domain.WeatherDataWritable{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", temp=" + temp +
                ", windspeed=" + windspeed +
                ", visibility=" + visibility +
                ", percipitation=" + percipitation +
                ", countryName=" + countryName +
                ", stationName=" + stationName +
                ", countryCode=" + countryCode +
                ", stateCode=" + stateCode +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", elevation=" + elevation +
                '}';
    }
}
