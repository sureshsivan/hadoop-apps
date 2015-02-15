package learn;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 743522 on 13-02-2015.மையாக உழைத்து உயரத்துக்கு வர வேண்டியுள்ளது. வந்த பிறகு, 'உயரத்தைத் தொட்டு விட்டோமே...' என்று உழைப்பதை நிறுத்தி விட்டால், தொழிலில் விபத்து ஏற்பட்டு விடும். உழைப்பு என்பது வருமானத்துக்காக மட்டுமல்ல, உடல் ஆரோக்கியம் மற்றும் மன நிம்மதிக்காகவும்தான்!'' என்று விளக்கம் அளித்தார்.
# படித்ததில் உணர்த
 */
public class HdfsFileSystemTest {

    private MiniDFSCluster cluster;
    private FileSystem fs;

    @BeforeClass
    public void setupCluster() throws IOException {
        Configuration conf = new Configuration();
        cluster = new MiniDFSCluster.Builder(conf).build();
        fs = cluster.getFileSystem();
        FSDataOutputStream fsos = fs.create(new Path("/dir/file"));
        fsos.write("Suresh".getBytes("UTF-8"));
        fsos.close();
    }


    @AfterClass
    public void tearDownCluster() throws IOException {
        if(fs != null)  fs.close();
        if(cluster != null) cluster.shutdown();
    }

    @Test(priority = 0,
            expectedExceptions = {FileNotFoundException.class,
                                    IOException.class})
    public void accessUnknownFile() throws IOException {
        fs.getFileStatus(new Path("unknown-file"));
    }

    @Test(priority = 1)
    public void accessRootFolder() throws IOException {
        FileStatus fStatus = fs.getFileStatus(new Path("/"));
        assertNotNull(fStatus);
        assertEquals(fStatus.isDirectory(), true);
        assertEquals(fStatus.isSymlink(), false);
    }

    @Test(priority = 2)
    public void testWrittenFile() throws IOException {
        Path path = new Path("/dir/file");
        FSDataInputStream fsis = fs.open(path);
        FileStatus fStatus = fs.getFileStatus(path);
//        Object o = fsis.readUTF();
//        assertEquals(fsis.readUTF(), "Suresh");
        assertEquals(fStatus.isDirectory(), false);
        assertEquals(fStatus.isSymlink(), false);
        assertEquals(fStatus.getLen(), 6L);
        fsis.close();
    }

}
