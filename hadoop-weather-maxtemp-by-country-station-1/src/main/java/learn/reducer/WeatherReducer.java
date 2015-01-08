package learn.reducer;

import learn.util.InvalidData;
import learn.domain.WeatherDataWritable;
import learn.util.WeatherConstants;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by 743522 on 23-10-2014.
 */
public class WeatherReducer extends Reducer<Text, WeatherDataWritable, Text, Text>{

    private float minTemp = 0.0F;
    private float maxTemp = 0.0F;

    private float minWindspeed = 0.0F;
    private float maxWindSpeed = 0.0F;

    private float minVisibility = 0.0F;
    private float maxVisibility = 0.0F;

    private float minPercipitation = 0.0F;
    private float maxPercipitation = 0.0F;


    @Override
    protected void reduce(Text key, Iterable<WeatherDataWritable> values, Context context) throws IOException, InterruptedException {


        minTemp = 0.0F;
        maxTemp = 0.0F;

        minWindspeed = 0.0F;
        maxWindSpeed = 0.0F;

        minVisibility = 0.0F;
        maxVisibility = 0.0F;

        minPercipitation = 0.0F;
        maxPercipitation = 0.0F;
        
        for(WeatherDataWritable datum : values){
            if(datum.getTemp().get() != WeatherConstants.INVALID_TEMP){
                minTemp = datum.getTemp().get();
                minTemp = minTemp < datum.getTemp().get() ? minTemp : datum.getTemp().get();
                maxTemp = maxTemp > datum.getTemp().get() ? maxTemp : datum.getTemp().get();
            } else {
                context.getCounter(InvalidData.TEMP_MISSING).increment(1);
            }

            if(datum.getWindspeed().get() != WeatherConstants.INVALID_WINDSPEED){
                minWindspeed = datum.getWindspeed().get();
                minWindspeed = minWindspeed < datum.getWindspeed().get() ? minWindspeed : datum.getWindspeed().get();
                maxWindSpeed = maxWindSpeed > datum.getWindspeed().get() ? maxWindSpeed : datum.getWindspeed().get();
            } else {
                context.getCounter(InvalidData.WINDSPEED_MISSING).increment(1);
            }

            if(datum.getVisibility().get() != WeatherConstants.INVALID_VISIBILITY){
                minVisibility = datum.getVisibility().get();
                minVisibility = minVisibility < datum.getVisibility().get() ? minVisibility : datum.getVisibility().get();
                maxVisibility = maxVisibility > datum.getVisibility().get() ? maxVisibility : datum.getVisibility().get();
            } else {
                context.getCounter(InvalidData.VISIBILITY_MISSING).increment(1);
            }

            if(datum.getPercipitation().get() != WeatherConstants.INVALID_PERCIPITATION){
                minPercipitation = datum.getPercipitation().get();
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
