package nlp3_ca;

import java.util.*;

public class ConceptualAnalyzer {

    LinkedList<Concept> conceptsList;//cList
    LinkedList<Integer> requestsList;//rList

    public ConceptualAnalyzer() {
        conceptsList = new LinkedList<Concept>();
        requestsList = new LinkedList<Integer>();
    }

    public static void main(String[] args) {
        ConceptualAnalyzer ca = new ConceptualAnalyzer();

        if ((args[args.length - 1].contains(".") && args[args.length - 1].length() > 1) ||
                !args[args.length - 1].contains(".") || args.length == 0) {
            System.out.println("Enter the sentence in the following form:");
            System.out.println("\t John gave Mary a book .");
            System.out.println("\t Mary gave a book to John .");
            System.out.println("\t John took Mary to Chicago .");
            System.exit(0);
        }
        System.out.println("Sentence:  " + ca.getArgsString(args));

        Words dictionary = new Words();
        Concept LTM = new Concept("FINAL");//output becomes dependent on a a cList singleton

        for (int i = 0; i < args.length; i++) {
            String currentWord = args[i];
            if (currentWord.equals(".")) {
                LTM = ca.conceptsList.get(0);
                break;
            }
            Concept c = dictionary.dictionary.get(currentWord);
            ca.requestsList.addAll(c.getRequestList());
            for (int r = ca.requestsList.size() - 1; r >= 0; r--) {
                ca.requestManager(c, r);
            }

        }
        System.out.println("\nResult:");
        System.out.println(LTM.toString());
    }

    public void requestManager(Concept c, int r) {
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
                            temp.actor = (Human) conceptsList.get(checkPrv);
                            temp.from = (Human) conceptsList.get(checkPrv);
                            conceptsList.set(conceptsList.size() - 1, temp);
                            requestsList.remove(requestsList.get(r));
                            conceptsList.remove(checkPrv);
                            break;
                        }
                        if (conceptsList.get(conceptsList.size() - 1) instanceof PTrans) {
                            PTrans temp = (PTrans) conceptsList.get(conceptsList.size() - 1);
                            temp.actor = (Human) conceptsList.get(checkPrv);
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
                        Obj b = (Obj) conceptsList.get(conceptsList.size() - 1);
                        b.ref = (Ref) conceptsList.get(checkPrv);
                        conceptsList.set(conceptsList.size() - 1, b);
                        conceptsList.remove(checkPrv);
                        break;
                    }
                }
                requestsList.remove(requestsList.get(r));
                break;

            case 6:
                for (int checkPrv = conceptsList.size() - 1; checkPrv >= 0; checkPrv--) {
                    if (conceptsList.get(checkPrv) instanceof ATrans) {
                        ATrans temp = (ATrans) conceptsList.get(checkPrv);
                        temp.object = (Obj) conceptsList.get(conceptsList.size() - 1);
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
                        temp.to = (City) conceptsList.get(conceptsList.size() - 1);
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
        }//end switch
    }//end method

    String getArgsString(String[] args) {
        String temp = "";
        for (String i : args) {
            temp += i + " ";
        }
        return temp;
    }
}//end class

