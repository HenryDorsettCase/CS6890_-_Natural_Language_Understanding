package nlp3_ca;

public class Human extends Concept {

    Name name;
    Gender gender;

    public Human(Name n, Gender g, String key) {
        super(key);
        name = n;
        gender = g;
    }

    public String toString() {
        return "HUMAN" + name + gender;
    }
}
