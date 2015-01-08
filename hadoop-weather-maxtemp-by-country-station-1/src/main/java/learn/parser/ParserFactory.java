package learn.parser;

/**
 * Created by suren on 8/1/15.
 */
public interface ParserFactory<T extends Parseble> {

    public Parser getParser();

}
