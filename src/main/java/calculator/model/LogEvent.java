package calculator.model;

import java.util.Objects;

public class LogEvent {

    private String id;
    private String state; //Todo enum
    private String type; //Todo enum ?
    private String host;
    private long timestamp;

    public LogEvent(){

    }

    public LogEvent(String id, String state, String type, String host, long timestamp){
        this.id=id;
        this.state=state;
        this.type =type;
        this.host = host;
        this.timestamp = timestamp;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEvent logEvent = (LogEvent) o;
        return timestamp == logEvent.timestamp &&
                id.equals(logEvent.id) &&
                state.equals(logEvent.state) &&
                Objects.equals(type, logEvent.type) &&
                Objects.equals(host, logEvent.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, type, host, timestamp);
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
