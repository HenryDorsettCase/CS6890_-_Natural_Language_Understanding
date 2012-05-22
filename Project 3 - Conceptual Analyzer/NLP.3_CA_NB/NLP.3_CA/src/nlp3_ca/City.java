package nlp3_ca;

public class City extends Concept {

    Name name;

    public City(String n, String key) {
        super(key);
        name = new Name(n, key);
    }

    public String toString() {
        return "CITY" + name;
    }
}
