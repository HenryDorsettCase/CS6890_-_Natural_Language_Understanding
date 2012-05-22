package nlp3_ca;

import java.util.*;

public class Words {

    John john;
    Mary mary;
    Gave gave;
    A a;
    Book book;
    To to;
    Took took;
    Chicago chicago;
    public HashMap<String, Concept> dictionary;

    public Words() {
        john = new John("1");
        mary = new Mary("2");
        gave = new Gave("3");
        a = new A("4");
        book = new Book("5");
        to = new To("6");
        took = new Took("7");
        chicago = new Chicago("8");

        Concept con;
        dictionary = new HashMap<String, Concept>();
        con = john;
        dictionary.put("John", con);
        con = mary;
        dictionary.put("Mary", con);
        con = gave;
        dictionary.put("gave", con);
        con = a;
        dictionary.put("a", con);
        con = book;
        dictionary.put("book", con);
        con = to;
        dictionary.put("to", con);
        con = took;
        dictionary.put("took", con);
        con = chicago;
        dictionary.put("Chicago", con);
    }

    public class John extends Human {

        public John(String key) {
            super(new Name("JOHN", key), new Gender("MALE", key), key);
            super.requestList.add(4);
            super.requestList.add(1);
        }
    }

    class Gave extends ATrans {

        public Gave(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }

    class Mary extends Human {

        public Mary(String key) {
            super(new Name("MARY", key), new Gender("FEMALE", key), key);
            super.requestList.add(4);
            super.requestList.add(1);
        }
    }

    class A extends Ref {

        A(String key) {
            super("INDEF", key);
            super.requestList.add(1);
        }
    }

    class Book extends Obj {

        public Book(String key) {
            super("BOOK", key);
            super.requestList.add(6);
            super.requestList.add(5);
            super.requestList.add(1);
        }
    }

    class To extends Concept {

        public To(String key) {
            super(key);
        }
    }

    class Took extends PTrans {

        public Took(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }

    class Chicago extends City {

        public Chicago(String key) {
            super("CHICAGO", key);
            super.requestList.add(7);
            super.requestList.add(1);
        }
    }
}
