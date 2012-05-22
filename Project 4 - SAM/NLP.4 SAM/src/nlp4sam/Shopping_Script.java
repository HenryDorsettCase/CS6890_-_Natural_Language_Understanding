package nlp4sam;

public class Shopping_Script {

    Human shopper;
    Store store;
    Product item;
    Location someplace;

    public Shopping_Script() {
        shopper = new Human();
        store = new Store();
        item = new Product();
        someplace = new Location();
    }

    public String toString() {
        String temp = "";
        temp += "(SHOPPING\t:SHOPPER(" + shopper + ")\n";
        temp += "\t\t :STORE(" + store + ")\n";
        temp += "\t\t :PRODUCT(" + item + ")\n";
        temp += "\t\t :SOMEPLACE(" + someplace + "))";
        return temp;
    }
}
