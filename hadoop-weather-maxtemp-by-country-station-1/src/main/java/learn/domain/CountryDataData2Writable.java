package learn.domain;

import learn.parser.Parseble;
import learn.parser.Parser;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by suren on 24/10/14.
 */
public class CountryDataData2Writable implements Writable {

    private Text countryCode = new Text();
    private Text countryName = new Text();

    public Text getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Text countryCode) {
        this.countryCode = countryCode;
    }

    public Text getCountryName() {
        return countryName;
    }

    public void setCountryName(Text countryName) {
        this.countryName = countryName;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        try {
            countryCode.write(out);
            countryName.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        try {
            countryCode.readFields(in);
            countryName.readFields(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
