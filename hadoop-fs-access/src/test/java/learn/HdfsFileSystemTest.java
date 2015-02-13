package learn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.test.MiniDFSClusterManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 743522 on 13-02-2015.
 */
public class HdfsFileSystemTest {

    private MiniDFSCluster cluster;
    private FileSystem fs;

    @BeforeClass
    public void setupCluster() throws IOException {
        Configuration conf = new Configuration();
        cluster = new MiniDFSCluster.Builder(conf).build();
        fs = cluster.getFileSystem();
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
        System.out.println(fs.getFileStatus(new Path("/")));;
    }

    @Test(priority = 1)
    public void accessRootFolder() throws IOException {
        FileStatus fStatus = fs.getFileStatus(new Path("/"));
        assertNotNull(fStatus);
        assertEquals(fStatus.isDirectory(), true);
        assertEquals(fStatus.isSymlink(), false);
    }

}
