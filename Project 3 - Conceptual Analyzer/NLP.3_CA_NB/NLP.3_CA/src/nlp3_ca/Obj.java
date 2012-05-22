package nlp3_ca;

public class Obj extends Concept {

    String type;
    Ref ref;

    public Obj(String t, String key) {
        super(key);
        type = t;
        ref = new Ref("null", "ref");
    }

    public String toString() {
        return type + ref;
    }
}
