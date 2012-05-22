package nlp4sam;

public class Human extends Animate {

    Name name;
    Gender gender;

    public Human(Name n, Gender g, String key) {
        super(key);
        name = n;
        gender = g;
    }

    public Human() {
        super("dummy");
        name = null;
        gender = null;
    }

    public String toString() {
        return "HUMAN" + name + gender;
    }
}
