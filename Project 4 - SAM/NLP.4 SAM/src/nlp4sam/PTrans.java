package nlp4sam;

public class PTrans extends Concept {

    Concept actor;
    Concept object;
    Concept from;
    Concept to;
    Time time;

    public PTrans(String key) {
        super(key);
        actor = new Concept("null");
        object = new Concept("null");
        from = new Concept("null");
        to = new Location("null", "null");
        time = new Time("null", "null");
    }

    public String toString() {
        String temp = "";
        temp += "(PTRANS\t:ACTOR(" + actor + ")\n";
        temp += "\t:OBJECT(" + object + ")\n";
        temp += "\t:FROM(" + from + ")\n";
        temp += "\t:TO(" + to + ")\n";
        temp += "\t:TIME(" + time + "))";
        return temp;
    }
}
