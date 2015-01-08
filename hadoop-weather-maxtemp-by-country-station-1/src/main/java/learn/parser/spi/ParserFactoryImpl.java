package learn.parser.spi;

import learn.domain.WeatherData1;
import learn.parser.Parser;
import learn.parser.ParserFactory;

/**
 * Created by suren on 8/1/15.
 */
public class ParserFactoryImpl implements ParserFactory {

    private static ParserFactoryImpl INSTANCE = new ParserFactoryImpl();

    private ParserFactoryImpl(){

    }

    public static ParserFactoryImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public Parser getParser(String name) {
        Parser parser = null;
        if(name.equals(WeatherData1Parser.class.getName())){
            parser = new WeatherData1Parser();
        }
        return parser;
    }
}
