package nlp4sam;

public class Ref extends Concept {

    String type;

    public Ref(String t, String key) {
        super(key);
        type = t;
    }

    public String toString() {
        return " :REF(" + type + ")";
    }
}
