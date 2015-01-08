package learn.mapper;

import learn.domain.WeatherData1;
import learn.domain.WeatherData1Writable;
import learn.parser.Parser;
import learn.parser.spi.WeatherData1Parser;
import learn.parser.spi.WeatherParserFactory;
import learn.util.InvalidData;
import learn.util.RecordCounter;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by 743522 on 23-10-2014.
 */
public class WeatherMapper extends Mapper<LongWritable, Text, Text, WeatherData1Writable> {

    Parser<WeatherData1> parser = new WeatherParserFactory<WeatherData1>().getParser();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        context.getCounter(RecordCounter.RECORD_COUNTER).increment(1);

        //  Skip If it is a header Record.
        if(value.toString().startsWith("RECORD_ID")){
            context.getCounter(RecordCounter.HEADER_RECORD).increment(1);
            return;
        }

        if(value.toString().split(((WeatherData1Parser)parser).getSplit()).length < 1){
            context.getCounter(RecordCounter.JUNK_RECORD).increment(1);
            return;
        }

        WeatherData1 datum = parser.parseFromText(value);

        //  If all the weather data is wrong - skip that record.
        if((datum.getTemp() == WeatherConstants.INVALID_TEMP) &&
                (datum.getWindspeed() == WeatherConstants.INVALID_WINDSPEED) &&
                (datum.getVisibility() == WeatherConstants.INVALID_VISIBILITY) &&
                (datum.getPercipitation() == WeatherConstants.INVALID_PERCIPITATION)){
            // Increment Counter for All Wrong Data
            context.getCounter(RecordCounter.ALL_MISSING).increment(1);
            return;
        }



        WeatherData1Writable writableDatum = WeatherData1Writable.getWeatherData1Writable(datum);

        context.write(new Text((writableDatum.getCountryName().toString()) + ":" + (writableDatum.getYear().toString())), writableDatum);

    }
}
