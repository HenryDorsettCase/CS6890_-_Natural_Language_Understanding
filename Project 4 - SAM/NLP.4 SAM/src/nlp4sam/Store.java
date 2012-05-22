package nlp4sam;

public class Store extends Concept {

    Name name;
    Ref ref;

    public Store(String key) {
        super(key);
        name = new Name("null", key);
        ref = new Ref("null", "ref");
    }

    public Store() {
        super("dummy");
        name = new Name("null", key);
        ref = new Ref("null", "ref");
    }

    public String toString() {
        return "STORE" + name + ref;
    }
}
