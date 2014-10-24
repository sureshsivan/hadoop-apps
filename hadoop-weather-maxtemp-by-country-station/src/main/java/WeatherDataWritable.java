import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by suren on 24/10/14.
 */
public class WeatherDataWritable implements Writable {

    private IntWritable year;
    private IntWritable month;
    private IntWritable day;
    private FloatWritable temp;
    private FloatWritable windspeed;
    private FloatWritable visibility;
    private FloatWritable percipitation;
    private Text countryName;
    private Text stationName;
    private Text countryCode;
    private Text stateCode;
    private FloatWritable latitude;
    private FloatWritable longitude;
    private FloatWritable elevation;

    private WeatherDataWritable(){
    }


    public static WeatherDataWritable getWeatherData(Text rawWeatherTxt){
        WeatherDataWritable data = new WeatherDataWritable();
        StringTokenizer tokenizer = new StringTokenizer(rawWeatherTxt.toString());
        int i = 0;
        String currentToken;
        while(tokenizer.hasMoreTokens()){
            currentToken = tokenizer.nextToken();
            switch (i){
                case 1:             //  First segment in TSV
                    data.setYear(new IntWritable(Integer.parseInt(currentToken.substring(0, 4))));
                    data.setMonth(new IntWritable(Integer.parseInt(currentToken.substring(4, 2))));
                    data.setDay(new IntWritable(Integer.parseInt(currentToken.substring(6, 2))));
                    break;
                case 2:             //  Second Segment in TSV
                    data.setTemp(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 3:
                    data.setWindspeed(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 4:
                    data.setVisibility(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 5:
                    data.setPercipitation(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 6:
                    data.setCountryName(new Text(currentToken));
                    break;
                case 7:
                    data.setStationName(new Text(currentToken));
                    break;
                case 8:
                    data.setCountryCode(new Text(currentToken));
                    break;
                case 9:
                    data.setStateCode(new Text(currentToken));
                    break;
                case 10:
                    data.setLatitude(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 11:
                    data.setLongitude(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                case 12:
                    data.setElevation(new FloatWritable(Integer.parseInt(currentToken)));
                    break;
                default:
                    break;
            }

            i++;
        }
        return data;
    }

    @Override
    public void write(DataOutput out) throws IOException {
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
    }

    @Override
    public void readFields(DataInput in) throws IOException {
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
        return "WeatherDataWritable{" +
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
