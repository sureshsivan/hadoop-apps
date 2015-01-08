package learn.parser;

/**
 * Created by suren on 8/1/15.
 */
public interface Parseble {

    public Parser<? extends Parseble> getParser();

}
