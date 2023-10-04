package prog10;

import prog02.GUI;
import prog02.UserInterface;
import prog09.BTree;

import java.io.File;
import java.util.*;

public class Jumble {
    /**
     * Sort the letters in a word.
     *
     * @param word Input word to be sorted, like "computer".
     * @return Sorted version of word, like "cemoptru".
     */
    public static String sort(String word) {
        char[] sorted = new char[word.length()];
        for (int n = 0; n < word.length(); n++) {
            char c = word.charAt(n);
            int i = n;

            while (i > 0 && c < sorted[i - 1]) {
                sorted[i] = sorted[i - 1];
                i--;
            }

            sorted[i] = c;
        }

        return new String(sorted, 0, word.length());
    }

    public static void main(String[] args) {
        UserInterface ui = new GUI("Jumble");
        // UserInterface ui = new ConsoleUI();

        //Map<String,String> map = new TreeMap<String,String>();
        // Map<String,String> map = new PDMap();
        // Map<String,String> map = new LinkedMap<String,String>();
        //Map<String,String> map = new SkipMap<String,String>();
        //Map<String, String> map = new BTree<>();
        //Map<String, String> map = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        Scanner in = null;
        do {
            try {
                in = new Scanner(new File(ui.getInfo("Enter word file.")));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Try again.");
            }
        } while (in == null);

        int n = 0;
        while (in.hasNextLine()) {
            String word = in.nextLine();
            if (n++ % 1000 == 0) {
                System.out.println(word + " sorted is " + sort(word));
//                System.out.println("Testing remove on: " + word);
//                System.out.println("Put: " + word);
//                map.put(word, sort(word));
//                System.out.print("Get obtains " + word +": " );
//                if(!map.get(word).equals(sort(word))) {
//                    System.out.println("false");
//                    break;
//                }
//                else {
//                    System.out.println("true");
//                }
//                System.out.print("Remove returns " + word +": " );
//                if(!map.remove(word).equals(sort(word))) {
//                    System.out.println("false");
//                    break;
//                } else {
//                    System.out.println("true");
//                }
//                System.out.print("Get is now null: " );
//                if(map.get(word) != null) {
//                    System.out.println("false");
//                    break;
//                }else {
//                    System.out.println("true");
//                }
//                System.out.print("Remove is now null: ");
//                if(map.remove(word) != null) {
//                    System.out.println("false");
//                    break;
//                } else {
//                    System.out.println("true");
//                }
//                System.out.println("Re-Put: " + word);
//                map.put(word, sort(word));
            }

     if(map.containsKey(sort(word))) {
      List<String> listWords = map.get(sort(word));
       listWords.add(word);
      map.put(sort(word),listWords);




     } else {
      List<String> listWords = new ArrayList<String>();
       listWords.add(word);
       map.put(sort(word),listWords);



     }


            // EXERCISE: Insert an entry for word into map.
            // What is the key?  What is the value?
            ///

            ///
        }


        while (true) {
            String jumble = ui.getInfo("Enter jumble.");
            if (jumble == null)
                break;


            List<String> word;
            // EXERCISE:  Look up the jumble in the map.
            // What key do you use?
            ///
      word = map.get(sort(jumble));


     if (word == null)
        ui.sendMessage("No match for " + jumble);
     else
        ui.sendMessage(jumble + " unjumbled is " + word);
    }


            while (true) {
                String clue = ui.getInfo("Please give a clue");
                if (clue == null) {
                    return;
                }
                String sortedClue = sort(clue);
                int index;

                String stringLength = ui.getInfo("What is the length of the word");

                index = Integer.parseInt(stringLength);

                for (String key1 : map.keySet()) {
                    if (key1.length() == index) {
                        String key2 = "";
                        int key1index = 0;
                        for (int i = 0; i < sortedClue.length(); i++) {
                            if (key1index < key1.length() && sortedClue.charAt(i) == key1.charAt(key1index)) {
                                key1index++;
                            } else if (key1index < key1.length() && sortedClue.charAt(i) > key1.charAt(key1index)) {
                                continue;
                            } else {
                                key2 = key2 + sortedClue.charAt(i);
                            }
                        }

                        if (key1index == key1.length()) {
                            if (map.containsKey(key2)) {
                                ui.sendMessage(map.get(key1) + "" + map.get(key2));
                            }
                        }

                    }
                }
            }


        }
    }



        
    

