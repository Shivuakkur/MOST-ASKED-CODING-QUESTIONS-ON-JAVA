package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given a list of words, write a program to find the longest word
 * made of other words in the list.
 * Returns all possible occurrences.
 *
 * EXAMPLE
 * Input: "cat", "banana", "dog", "nana", "my", "walk", "walker",
 *        "baby", "dogwalkers", "s", "babymybaby"
 * Output: ["dogwalkers", "babymybaby"]
 */
public class Q07 {
    public static ArrayList<String> findLongestWord(String[] words) {
        if (words == null) return null;
        sortWordsByLength(words);
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String word : words) {
            map.put(word, true);
        }
        int maxLen = 0;
        for (String word : words) {
            if (isValidWord(word, true, map) && word.length() >= maxLen) {
                result.add(word);
                maxLen = word.length();
            }
        }
        return result;
    }

    private static void sortWordsByLength(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer) o2.length()).compareTo(o1.length());
            }
        });
    }

    private static boolean isValidWord(String word, boolean isOriginal, HashMap<String, Boolean> map) {
        if (!isOriginal && map.containsKey(word)) {
            return map.get(word);
        }
        for (int i = 1; i < word.length(); ++i) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (map.containsKey(left) &&
                map.get(left) == true &&
                isValidWord(right, false, map)) {
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] a = {"cat", "banana", "dog", "nana", "my", "walk",
                      "walker", "baby", "dogwalkers", "s", "babymybaby"};
        println(findLongestWord(a));
        a = new String[] {"A", "A", "A", "B", "C", "ABC", "AAA", "BAA", "B"};
        println(findLongestWord(a));
    }
}
