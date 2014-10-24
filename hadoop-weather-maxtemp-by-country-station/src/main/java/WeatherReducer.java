import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by 743522 on 23-10-2014.
 */
public class WeatherReducer extends Reducer<Text, WeatherDataWritable, Text, Text>{

//    private int groupByFieldIdx;
//    private String maxOrMin = "";
//    private int valFieldIdx;
//
//    @Override
//    protected void setup(Context context) throws IOException, InterruptedException {
//        Configuration config = context.getConfiguration();
//        groupByFieldIdx = config.getInt("", 0);
//        valFieldIdx = config.getInt("", 0);
//        maxOrMin = config.get("", "MAX");
//        super.setup(context);
//    }

    private float minTemp = Float.MIN_VALUE;
    private float maxTemp = Float.MIN_VALUE;

    private float minWindspeed = Float.MIN_VALUE;
    private float maxWindSpeed = Float.MIN_VALUE;

    private float minVisibility = Float.MIN_VALUE;
    private float maxVisibility = Float.MIN_VALUE;

    private float minPercipitation = Float.MIN_VALUE;
    private float maxPercipitation = Float.MIN_VALUE;


    @Override
    protected void reduce(Text key, Iterable<WeatherDataWritable> values, Context context) throws IOException, InterruptedException {


        minTemp = Float.MIN_VALUE;
        maxTemp = Float.MIN_VALUE;

        minWindspeed = Float.MIN_VALUE;
        maxWindSpeed = Float.MIN_VALUE;

        minVisibility = Float.MIN_VALUE;
        maxVisibility = Float.MIN_VALUE;

        minPercipitation = Float.MIN_VALUE;
        maxPercipitation = Float.MIN_VALUE;
        
        for(WeatherDataWritable datum : values){
            if(datum.getTemp().get() != WeatherDataParserDriver.INVALID_TEMP){
                minTemp = minTemp < datum.getTemp().get() ? minTemp : datum.getTemp().get();
                maxTemp = maxTemp > datum.getTemp().get() ? maxTemp : datum.getTemp().get();
            } else {
                context.getCounter(InvalidData.TEMP_MISSING).increment(1);
            }

            if(datum.getWindspeed().get() != WeatherDataParserDriver.INVALID_WINDSPEED){
                minWindspeed = minWindspeed < datum.getWindspeed().get() ? minWindspeed : datum.getWindspeed().get();
                maxWindSpeed = maxWindSpeed > datum.getWindspeed().get() ? maxWindSpeed : datum.getWindspeed().get();
            } else {
                context.getCounter(InvalidData.WINDSPEED_MISSING).increment(1);
            }

            if(datum.getVisibility().get() != WeatherDataParserDriver.INVALID_VISIBILITY){
                minVisibility = minVisibility < datum.getVisibility().get() ? minVisibility : datum.getVisibility().get();
                maxVisibility = maxVisibility > datum.getVisibility().get() ? maxVisibility : datum.getVisibility().get();
            } else {
                context.getCounter(InvalidData.VISIBILITY_MISSING).increment(1);
            }

            if(datum.getPercipitation().get() != WeatherDataParserDriver.INVALID_PERCIPITATION){
                minPercipitation = minPercipitation < datum.getPercipitation().get() ? minPercipitation : datum.getPercipitation().get();
                maxPercipitation = maxPercipitation > datum.getPercipitation().get() ? maxPercipitation : datum.getPercipitation().get();
            } else {
                context.getCounter(InvalidData.PERCIPITATION_MISSING).increment(1);
            }

        }

        context.write(key, getOutputText());



    }
    
    public Text getOutputText(){
        Text out = new Text();
        StringBuffer sb = new StringBuffer();
        sb.append("MIN TEMP:" + minTemp);
        sb.append("  \t  ");
        sb.append("MAX TEMP:" + maxTemp);
        sb.append("  \t  ");

        sb.append("MIN WINDSPEED:" + minWindspeed);
        sb.append("  \t  ");
        sb.append("MAX WINDSPEED:" + maxWindSpeed);
        sb.append("  \t  ");

        sb.append("MIN VISIBILITY:" + minVisibility);
        sb.append("  \t  ");
        sb.append("MAX VISIBILITY:" + maxVisibility);
        sb.append("  \t  ");

        sb.append("MIN PERCIPITATION:" + minPercipitation);
        sb.append("  \t  ");
        sb.append("MAX PERCIPITATION:" + maxPercipitation);
        sb.append("  \t  ");

        out.set(sb.toString());

        return out;
    }
    
}
