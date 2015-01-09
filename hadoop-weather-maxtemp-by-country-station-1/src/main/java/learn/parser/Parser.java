package learn.parser;

import org.apache.hadoop.io.Text;

/**
 * Created by suren on 8/1/15.
 */
public interface Parser<T extends Parseble> {
    public T parseFromText(Text txtData);
    public T parseFromText(String stringData);
}
