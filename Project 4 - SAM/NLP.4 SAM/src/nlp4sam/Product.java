package nlp4sam;

public class Product extends Inanimate {

    String type;
    Ref ref;

    public Product(String t, String key) {
        super(key);
        type = t;
        ref = new Ref("null", "ref");
    }

    public Product() {
        super("dummy");
        type = null;
        ref = new Ref("null", "ref");
    }

    public String toString() {
        return type + ref;
    }
}
