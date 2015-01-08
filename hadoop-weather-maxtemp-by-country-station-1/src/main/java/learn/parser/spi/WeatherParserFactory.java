package learn.parser.spi;

import learn.parser.Parseble;
import learn.parser.Parser;
import learn.parser.ParserFactory;

/**
 * Created by suren on 8/1/15.
 */
public class WeatherParserFactory<T extends Parseble> implements ParserFactory {

    private static WeatherParserFactory INSTANCE = new WeatherParserFactory();

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public WeatherParserFactory(){

    }

    public static WeatherParserFactory getInstance(){
        return INSTANCE;
    }

    @Override
    public Parser getParser() {
        return getType().getParser();
    }
}
