package nlp4sam;

import java.util.*;

public class ConceptualAnalyzer
{
    LinkedList<Concept> conceptsList;//cList
    LinkedList<Integer> requestsList;//rList

    public ConceptualAnalyzer() {
        conceptsList = new LinkedList<Concept>();
        requestsList = new LinkedList<Integer>();
    }

    public static void main(String[] args) {
        try {
            ConceptualAnalyzer ca = new ConceptualAnalyzer();
            LinkedList<Concept> LTM = new LinkedList<Concept>();//output becomes dependent on a a cList singleton
            Dictionary dict = new Dictionary();

            ca.printArgs(args);

            String typeScript = "";
            for (int i = 0; i < args.length; i++) {
                String currentWord = args[i];

                if (currentWord.equals(".")) {
                    LTM.addLast(ca.conceptsList.pollFirst());
                    ca.conceptsList.clear();
                    dict = new Dictionary();
                } 
                else {
                    if (args[i].equals("restaurant"))   { typeScript = "R"; }
                    if (args[i].equals("store"))        { typeScript = "S"; }

                    Concept c = dict.dictionary.get(currentWord);
                    ca.requestsList.addAll(c.getRequestList());
                    for (int r = ca.requestsList.size() - 1; r >= 0; r--) { ca.requestManager(c, r); }
                }
            }

            System.out.println("\nResult->");
            ca.scriptApplier(LTM, typeScript);

        }catch (Exception e) { System.out.println("ERROR: in main method"); }
    }

    public void requestManager(Concept c, int r) {
        try {
            switch (requestsList.get(r)) {
                case 1:
                    conceptsList.add(c);
                    requestsList.remove(r);
                    break;

                case 2:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof Time) {
                            if (conceptsList.get(conceptsList.size() - 1) instanceof ATrans) {
                                ATrans temp = (ATrans) conceptsList.get(conceptsList.size() - 1);
                                temp.time = (Time) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, temp);
                                requestsList.remove(requestsList.get(r));
                                conceptsList.remove(checkPrv);
                                break;
                            }
                            if (conceptsList.get(conceptsList.size() - 1) instanceof PTrans) {
                                PTrans temp = (PTrans) conceptsList.get(conceptsList.size() - 1);
                                temp.time = (Time) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, temp);
                                requestsList.remove(requestsList.get(r));
                                conceptsList.remove(checkPrv);
                                break;
                            }
                        }
                    }
                    break;

                case 3:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof Human) {
                            if (conceptsList.get(conceptsList.size() - 1) instanceof ATrans) {
                                ATrans temp = (ATrans) conceptsList.get(conceptsList.size() - 1);
                                temp.to = (Human) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, temp);
                                requestsList.remove(requestsList.get(r));
                                conceptsList.remove(checkPrv);
                                break;
                            }

                            if (conceptsList.get(conceptsList.size() - 1) instanceof PTrans) {
                                PTrans temp = (PTrans) conceptsList.get(conceptsList.size() - 1);
                                temp.actor = (Human) conceptsList.get(checkPrv);
                                temp.object = (Human) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, temp);
                                requestsList.remove(requestsList.get(r));
                                conceptsList.remove(checkPrv);
                                break;
                            }
                        }
                    }
                    break;

                case 4:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof ATrans) {
                            ATrans temp = (ATrans) conceptsList.get(checkPrv);
                            temp.to = (Human) conceptsList.get(conceptsList.size() - 1);
                            conceptsList.set(checkPrv, temp);
                            conceptsList.remove(conceptsList.size() - 1);
                            break;
                        }
                        if (conceptsList.get(checkPrv) instanceof PTrans) {
                            PTrans temp = (PTrans) conceptsList.get(checkPrv);
                            temp.object = (Human) conceptsList.get(conceptsList.size() - 1);
                            conceptsList.set(checkPrv, temp);
                            conceptsList.remove(conceptsList.size() - 1);
                            break;
                        }
                    }
                    requestsList.remove(requestsList.get(r));
                    break;

                case 5:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof Ref) {
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Product) {
                                Product p = (Product) conceptsList.get(conceptsList.size() - 1);
                                p.ref = (Ref) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, p);
                                conceptsList.remove(checkPrv);
                            }
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Store) {
                                Store s = (Store) conceptsList.get(conceptsList.size() - 1);
                                s.ref = (Ref) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, s);
                                conceptsList.remove(checkPrv);
                            }
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Restaurant) {
                                Restaurant res = (Restaurant) conceptsList.get(conceptsList.size() - 1);
                                res.ref = (Ref) conceptsList.get(checkPrv);
                                conceptsList.set(conceptsList.size() - 1, res);
                                conceptsList.remove(checkPrv);
                            }
                            break;
                        }
                    }
                    requestsList.remove(requestsList.get(r));
                    break;

                case 6:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof ATrans) {
                            ATrans temp = (ATrans) conceptsList.get(checkPrv);
                            temp.object = (Product) conceptsList.get(conceptsList.size() - 1);
                            conceptsList.set(checkPrv, temp);
                            conceptsList.remove(conceptsList.size() - 1);
                            break;
                        }
                    }
                    requestsList.remove(requestsList.get(r));
                    break;

                case 7:
                    for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                        if (conceptsList.get(checkPrv) instanceof PTrans) {
                            PTrans temp = (PTrans) conceptsList.get(checkPrv);
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Store) 
                            {   temp.to = (Store) conceptsList.get(conceptsList.size() - 1); }
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Restaurant)
                            {   temp.to = (Restaurant) conceptsList.get(conceptsList.size() - 1); }
                            if (conceptsList.get(conceptsList.size() - 1) instanceof Location)
                            {   temp.to = (Location) conceptsList.get(conceptsList.size() - 1); }

                            conceptsList.set(checkPrv, temp);
                            conceptsList.remove(conceptsList.size() - 1);
                            break;
                        }
                    }
                    requestsList.remove(requestsList.get(r));
                    break;

                case 10:
                    conceptsList.add(new Time("PAST", "past"));
                    requestsList.remove(requestsList.get(r));
                    break;
            }
        } catch (Exception e) { System.out.println("ERROR: in requestManager"); }
    }

    void scriptApplier(LinkedList<Concept> LTM, String typeScript) {
        try {
            PTrans first = new PTrans("final");
            ATrans second = new ATrans("final");
            PTrans third = new PTrans("final");

            if (LTM.get(0) instanceof PTrans) { first = (PTrans) LTM.get(0); }
            if (LTM.get(1) instanceof ATrans) { second = (ATrans) LTM.get(1); }
            if (LTM.get(2) instanceof PTrans) { third = (PTrans) LTM.get(2); }

            if (typeScript.equals("S")) {
                Shopping_Script shoppingScript = new Shopping_Script();

                //Human extends Animate extends PP
                if (first.actor instanceof Human)       { shoppingScript.shopper = (Human) first.actor; }
                if (first.to instanceof Store)          { shoppingScript.store = (Store) first.to; }
                //Product extends Inanimate extends PP
                if (second.object instanceof Product)   { shoppingScript.item = (Product) second.object; }
                if (third.to instanceof Location)       { shoppingScript.someplace = (Location) third.to; }

                System.out.println(shoppingScript.toString());
            }

            if (typeScript.equals("R")) {
                Eat_Out_Script eatOutScript = new Eat_Out_Script();

                //Human extends Animate extends PP
                if (first.actor instanceof Human)       { eatOutScript.diner = (Human) first.actor; }
                if (first.to instanceof Restaurant)     { eatOutScript.restaurant = (Restaurant) first.to; }
                //Product extends Inanimate extends PP
                if (second.object instanceof Product)   { eatOutScript.meal = (Product) second.object; }
                if (third.to instanceof Location)       { eatOutScript.someplace = (Location) third.to; }

                System.out.println(eatOutScript.toString());
            }
        }catch (Exception e) { System.out.println("ERROR: in ScriptApplier"); }
    }

    public void printArgs(String[] args) {
        System.out.println("Input String->");
        for (String i : args) {System.out.print(i + " ");}
        System.out.println();
    }
}//end class CA
