package nlp3_ca;

import java.util.*;

public class Concept {

    String key;
    LinkedList<Integer> requestList;

    public Concept(String k) {
        key = k;
        requestList = new LinkedList<Integer>();
    }

    public LinkedList<Integer> getRequestList() {
        return requestList;
    }

    public String toString() {
        return key;
    }
}
