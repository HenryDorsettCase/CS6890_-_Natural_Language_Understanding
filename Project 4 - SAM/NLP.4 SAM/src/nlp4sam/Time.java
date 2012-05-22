package nlp4sam;

public class Time extends Concept {

    String time;

    public Time(String t, String key) {
        super(key);
        time = t;
    }

    public String toString() {
        return time;
    }
}
