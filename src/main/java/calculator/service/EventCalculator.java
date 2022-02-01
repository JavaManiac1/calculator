package calculator.service;

import calculator.model.LogEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.groupingBy;

public class EventCalculator {

    public List<String> returnSlowResponseIds (String data) throws IOException {

        return groupAndFindSlowResponses(createObjectListFromText(data));
    }

    private List<LogEvent> createObjectListFromText(String data) throws IOException {


        List<String> listOfStrings = new ArrayList<>(Arrays.asList(data.split("\\r?\\n")));

        //list of strings to list of objects
        List<LogEvent> logEvents = new ArrayList<>();

        for (String l : listOfStrings) {
            ObjectMapper jacksonObjMapper = new ObjectMapper();
            LogEvent logEvent = jacksonObjMapper.readValue(l, LogEvent.class);
            logEvents.add(logEvent);
        }

        return logEvents;
    }

    private List<String> groupAndFindSlowResponses(List<LogEvent> logEvents) {

        Map<String, List<LogEvent>> logEventListMap = logEvents.stream().collect(groupingBy(LogEvent::getId));

        List<String> slowResponseList = new ArrayList<>();

        logEventListMap.forEach((K, V) -> {
            if ((abs(V.get(0).getTimestamp() - V.get(1).getTimestamp())) > 4) slowResponseList.add(V.get(0).getId());
        });

        return  slowResponseList;
    }

}
