package learn.domain;

import learn.parser.Parseble;
import learn.parser.Parser;
import learn.parser.spi.StationData2Parser;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 * Created by suren on 24/10/14.
 */
public class CountryDataData2 implements Parseble {

    private String countryCode;
    private String countryName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryDataData2Writable getCountryDataData2Writable(){
        CountryDataData2Writable writable = new CountryDataData2Writable();
        writable.setCountryCode(new Text(getCountryCode()));
        writable.setCountryName(new Text(getCountryName()));
        return writable;
    }

    @Override
    public Parser<? extends Parseble> getParser() {
        return null;
    }
}
