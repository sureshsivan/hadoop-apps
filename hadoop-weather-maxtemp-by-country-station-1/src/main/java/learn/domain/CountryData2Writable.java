package learn.domain;

import org.apache.hadoop.io.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by suren on 24/10/14.
 */
public class CountryData2Writable implements Writable {

    private IntWritable station = new IntWritable();
    private IntWritable wban = new IntWritable();
    private Text stationName = new Text();
    private Text countryCode = new Text();
    private Text stateCodeUs = new Text();
    private FloatWritable latitude = new FloatWritable();
    private FloatWritable longitude = new FloatWritable();
    private FloatWritable elevation = new FloatWritable();

    public static CountryData2Writable getCountryData2Writable(CountryData2 countryData2){
        CountryData2Writable writable = new CountryData2Writable();
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

    public Text getStationName() {
        return stationName;
    }

    public void setStationName(Text stationName) {
        this.stationName = stationName;
    }

    public Text getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Text countryCode) {
        this.countryCode = countryCode;
    }

    public Text getStateCodeUs() {
        return stateCodeUs;
    }

    public void setStateCodeUs(Text stateCodeUs) {
        this.stateCodeUs = stateCodeUs;
    }

    public FloatWritable getLatitude() {
        return latitude;
    }

    public void setLatitude(FloatWritable latitude) {
        this.latitude = latitude;
    }

    public FloatWritable getLongitude() {
        return longitude;
    }

    public void setLongitude(FloatWritable longitude) {
        this.longitude = longitude;
    }

    public FloatWritable getElevation() {
        return elevation;
    }

    public void setElevation(FloatWritable elevation) {
        this.elevation = elevation;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        try {
        } catch (Exception e) {
            station.write(out);
            wban.write(out);
            stationName.write(out);
            countryCode.write(out);
            stateCodeUs.write(out);
            latitude.write(out);
            longitude.write(out);
            elevation.write(out);
            e.printStackTrace();
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        try {
        } catch (Exception e) {
            station.readFields(in);
            wban.readFields(in);
            stationName.readFields(in);
            countryCode.readFields(in);
            stateCodeUs.readFields(in);
            latitude.readFields(in);
            longitude.readFields(in);
            elevation.readFields(in);
            e.printStackTrace();
        }
    }
}
