package nlp4sam;

import java.util.*;

public class Dictionary {

    John john;
    Went went;
    To to;
    The the;
    St store;
    He he;
    Got got;
    A a;
    Kite kite;
    Home home;
    Rstnt restaurant;
    Ordered ordered;
    Lobster lobster;
    Left left;

    public HashMap<String, Concept> dictionary;

    public Dictionary() {
        john = new John("1");
        went = new Went("2");
        to = new To("3");
        the = new The("4");
        store = new St("5");
        he = new He("6");
        got = new Got("7");
        a = new A("8");
        kite = new Kite("9");
        home = new Home("10");
        restaurant = new Rstnt("11");
        ordered = new Ordered("12");
        lobster = new Lobster("13");
        left = new Left("14");

        dictionary = new HashMap<String, Concept>();
        Concept con = john;
        dictionary.put("John", con);
        con = went;
        dictionary.put("went", con);
        con = to;
        dictionary.put("to", con);
        con = the;
        dictionary.put("the", con);
        con = store;
        dictionary.put("store", con);
        con = he;
        dictionary.put("He", con);
        con = got;
        dictionary.put("got", con);
        con = a;
        dictionary.put("a", con);
        con = kite;
        dictionary.put("kite", con);
        con = home;
        dictionary.put("home", con);
        con = restaurant;
        dictionary.put("restaurant", con);
        con = ordered;
        dictionary.put("ordered", con);
        con = lobster;
        dictionary.put("lobster", con);
        con = left;
        dictionary.put("left", con);
        //System.out.println(dictionary.toString());
    }

    public class John extends Human {
        public John(String key) {
            super(new Name("JOHN", key), new Gender("MALE", key), key);
            super.requestList.add(4);
            super.requestList.add(1);
        }
    }

    class Went extends PTrans {
        public Went(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }

    class To extends Concept {
        public To(String key) {
            super(key);
        }
    }

    class The extends Ref {
        The(String key) {
            super("DEF", key);
            super.requestList.add(1);
        }
    }

    class St extends Store {
        public St(String key) {
            super(key);
            super.requestList.add(7);
            super.requestList.add(5);
            super.requestList.add(1);
        }
    }

    public class He extends Human {
        public He(String key) {
            super(new Name("null", key), new Gender("MALE", key), key);
            super.requestList.add(4);
            super.requestList.add(1);
        }
    }

    class Got extends ATrans {
        public Got(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }

    class A extends Ref {
        A(String key) {
            super("INDEF", key);
            super.requestList.add(1);
        }
    }

    class Kite extends Product {
        public Kite(String key) {
            super("KITE", key);
            super.requestList.add(6);
            super.requestList.add(5);
            super.requestList.add(1);
        }
    }

    class Home extends Location {
        public Home(String key) {
            super("HOME", key);
            super.requestList.add(7);
            super.requestList.add(1);
        }
    }

    class Rstnt extends Restaurant {
        public Rstnt(String key) {
            super(key);
            super.requestList.add(7);
            super.requestList.add(5);
            super.requestList.add(1);
        }
    }

    class Lobster extends Product {
        public Lobster(String key) {
            super("LOBSTER", key);
            super.requestList.add(6);
            super.requestList.add(5);
            super.requestList.add(1);
        }
    }

    class Ordered extends ATrans {
        public Ordered(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }

    class Left extends PTrans {
        public Left(String key) {
            super(key);
            super.requestList.add(3);
            super.requestList.add(2);
            super.requestList.add(1);
            super.requestList.add(10);
        }
    }
}