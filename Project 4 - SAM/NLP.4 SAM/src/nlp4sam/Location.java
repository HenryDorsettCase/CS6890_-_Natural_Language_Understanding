package nlp4sam;

public class Location extends Concept {

    Name name;

    public Location(String n, String key) {
        super(key);
        name = new Name(n, key);
    }

    public Location() {
        super("dummy");
        name = new Name("dummy", "dummy");
    }

    public String toString() {
        return "LOCATION" + name;
    }
}
