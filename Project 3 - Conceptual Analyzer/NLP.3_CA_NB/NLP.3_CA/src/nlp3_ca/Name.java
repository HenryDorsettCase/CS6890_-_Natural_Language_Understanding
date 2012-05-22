package nlp3_ca;

public class Name extends Concept {

    String name;

    public Name(String n, String key) {
        super(key);
        name = n;
    }

    public String toString() {
        return " :NAME(" + name + ")";
    }
}
