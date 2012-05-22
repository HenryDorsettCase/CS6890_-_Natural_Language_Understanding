package nlp3_ca;

public class Gender extends Concept {

    String gender;

    public Gender(String g, String key) {
        super(key);
        gender = g;
    }

    public String toString() {
        return " :GENDER(" + gender + ")";
    }
}
