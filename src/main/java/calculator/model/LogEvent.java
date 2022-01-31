package calculator.model;

public class LogEvent {

    private String id;
    private String state; //Todo enum
    private String applicationLog; //Todo enum ?
    private String host;
    private long timeStamp;

    public LogEvent(String id, String state, String applicationLog, String host, long timeStamp){
        this.id=id;
        this.state=state;
        this.applicationLog =applicationLog;
        this.host = host;
        this.timeStamp = timeStamp;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return  id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setApplicationLog(String applicationLog) {
        this.applicationLog = applicationLog;
    }

    public String getApplicationLog() {
        return applicationLog;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
    
}
