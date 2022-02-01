package calculator;

import calculator.service.EventCalculator;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "-----------Slowest responses-----------" );


        FileInputStream file = new FileInputStream(args[0]);
//        FileInputStream file = new FileInputStream("src/main/resources/logfile.txt");
        String data = IOUtils.toString(file, "UTF-8");

        EventCalculator eventCalculator = new EventCalculator();

        List<String> slowResponseList =  eventCalculator.returnSlowResponseIds(data);


        System.out.println("Response IDs that takes more than 4ms:");
        for(String slowRespRecord : slowResponseList){
            System.out.println(slowRespRecord);
        }
    }
}
