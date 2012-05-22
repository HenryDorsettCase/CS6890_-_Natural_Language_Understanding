package nlp4sam;

public class Restaurant extends Concept {

    Name name;
    Ref ref;

    public Restaurant(String key) {
        super(key);
        name = new Name("null", key);
        ref = new Ref("null", "ref");
    }

    public Restaurant() {
        super("dummy");
        name = new Name("null", key);
        ref = new Ref("null", "ref");
    }

    public String toString() {
        return "RESTAURANT" + name + ref;
    }
}
