package nlp4sam;

public class Eat_Out_Script {

    Human diner;
    Restaurant restaurant;
    Product meal;
    Location someplace;

    public Eat_Out_Script() {
        diner = new Human();
        restaurant = new Restaurant();
        meal = new Product();
        someplace = new Location();
    }

    public String toString() {
        String temp = "";
        temp += "(EAT OUT\t:DINER(" + diner + ")\n";
        temp += "\t\t:RESTAURANT(" + restaurant + ")\n";
        temp += "\t\t:MEAL(" + meal + ")\n";
        temp += "\t\t:SOMEPLACE(" + someplace + "))";
        return temp;
    }
}
