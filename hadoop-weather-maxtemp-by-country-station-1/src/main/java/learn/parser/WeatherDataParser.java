package learn.parser;

import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public interface WeatherDataParser<T> {

    public T parseFromText(Text txtData);

}
