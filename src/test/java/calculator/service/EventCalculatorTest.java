package calculator.service;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EventCalculatorTest {

    @Test
    void returnSlowResponseIds() throws IOException {
        EventCalculator eventCalculator = new EventCalculator();

        FileInputStream file = new FileInputStream("src/main/resources/logfile.txt");
        String data = IOUtils.toString(file, "UTF-8");
        List<String> slowResponseList = eventCalculator.returnSlowResponseIds(data);

        assertTrue(slowResponseList.size() >0);
        assertTrue(slowResponseList.get(0).equals("scsmbstgra"));
        assertFalse(slowResponseList.contains("scsmbstgrb"));

    }
}