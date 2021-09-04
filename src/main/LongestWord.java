package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a .txt file, find the longest word in the file that
 * could be displayed on a seven segment display.
 *
 * @author Hritik "Ricky" Gupta
 * @version 2021.7.6.1
 */
public class LongestWord {

    private ArrayList<String> words = new ArrayList<>();

    public LongestWord(String filename) throws IOException {
        Scanner in = new Scanner(new File(filename));
        while (in.hasNext()) {
            this.words.add(in.next());
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        LongestWord longestWord = new LongestWord(args[0]);
        String currentLongestWord = "";
        ArrayList<String> longestWords = new ArrayList<>();

        for (String word : longestWord.words) {
            if (word.matches(".*[gikmqsvwxz].*")) { //checks if word can be displayed
                continue;
            }
            if (word.length() < currentLongestWord.length()) { //checks if word is longer than current
                continue;
            }

            currentLongestWord = word;

            if (longestWords.size() == 0) { //adds word to list if list is currently empty
                longestWords.add(word);
            } else if (longestWords.get(0).length() < word.length()) { //adds word to list if length is greater than length of first item in list
                longestWords.clear();
                longestWords.add(word);
            } else if (longestWords.get(0).length() == word.length()) { //adds word to list if length is the same as first item in the list
                longestWords.add(word);
            }
        }

        System.out.println("List of longest words: " + longestWords);
        System.out.println("List length: " + longestWords.size());
        System.out.println("Length of longest words: " + currentLongestWord.length());
    }
}
