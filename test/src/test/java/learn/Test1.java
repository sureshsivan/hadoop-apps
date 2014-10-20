package learn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.StringUtils;
import org.junit.Test;

import java.io.*;

/**
 * Created by suren on 20/10/14.
 */
public class Test1 {


    @Test
    public void testIntegerToHex() throws IOException {
//        System.out.println(StringUtils.("1"));
        IntWritable i1 = new IntWritable(-2);
        Text t = new Text();
        t.set("211");
        IntWritable i2 = new IntWritable(2);
        LongWritable l1 = new LongWritable(1L);
        LongWritable l2 = new LongWritable(2L);

        System.out.println(serialize(i1));
        System.out.println(serialize(i1).length);
        System.out.println(serialize(i2));
        System.out.println(serialize(i2).length);
        System.out.println(serialize(l1));
        System.out.println(serialize(l1).length);
        System.out.println(serialize(l2));
        System.out.println(serialize(l2).length);
        System.out.println(serialize(t));
        System.out.println(serialize(t).length);


        System.out.println("#E#############################");
        for (byte b : serialize(t)){
            System.out.println(b);
        }
        System.out.println("#E#############################");

//        byte b = 127;

        System.out.println("#E#############################");
        System.out.println(StringUtils.byteToHexString(serialize(i1)));
        System.out.println(StringUtils.byteToHexString(serialize(t)));
        System.out.println(StringUtils.byteToHexString(serialize(i2)));
        System.out.println(StringUtils.byteToHexString(serialize(l1)));
        System.out.println(StringUtils.byteToHexString(serialize(l2)));

        System.out.println("#E#############################");


        System.out.println(StringUtils.byteToHexString(org.apache.commons.codec.binary.StringUtils.getBytesUtf8("1")));
    }

    public static byte[] serialize(Writable writable) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        writable.write(dataOut);
        dataOut.close();
        return out.toByteArray();
    }

    public static byte[] deserialize(Writable writable, byte[] bytes)
            throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream dataIn = new DataInputStream(in);
        writable.readFields(dataIn);
        dataIn.close();
        return bytes;
    }

}
