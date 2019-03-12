package org.elvaston.coderpad.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a dictionary and a string of letters fine the longest word(s) that can be
 * made from the letters
 * for example, Dictionary {to, toe, toes} w/ input oet we get the output toe.
 * introduce ? to represent any letter.
 */
public class LongestWord {

    static class Dictionary {
        Map<Integer, Map<String, List<String>>> dictionaryOfLength = new HashMap<>();


        public Dictionary(String[] entries) {
            Arrays.asList(entries).forEach(entry -> {
                String sortedEntry = Arrays.stream(entry.split("")).sorted().collect(Collectors.joining());
                Integer length = sortedEntry.length();

                Map<String, List<String>> dictionary = new HashMap<>();

                if (dictionaryOfLength.containsKey(sortedEntry.length())) {
                    dictionary = dictionaryOfLength.get(length);
                }
                if (dictionary.containsKey(sortedEntry)) {
                    dictionary.get(sortedEntry).add(entry);
                } else {
                    dictionary.put(sortedEntry, new ArrayList<>(Collections.singletonList(entry)));
                }
                dictionaryOfLength.put(length, dictionary);
            });
        }

        private String sort(String word) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        private Set<String> getAnagrams(String input) {
            Set<String> anagrams = new HashSet<>();
            String sortedInput = sort(input);
            for (int i = input.length(); i >= 1; i--) {
                if (dictionaryOfLength.containsKey(i)) {
                    for (Map.Entry<String, List<String>> m: dictionaryOfLength.get(i).entrySet()) {
                        System.out.println(m.getKey() + "=" + input + "_" + sortedInput);
                        char[] dictionaryChars = m.getKey().toCharArray();
                        char[] inputChars = sortedInput.toCharArray();

                        for (int j = 0; j < sortedInput.length(); j++) {
                            char letter = inputChars[j];
                            for (int k = 0; k < dictionaryChars.length; k++) {
                                if (dictionaryChars[k] == letter && inputChars[j] != 'X') {
                                    dictionaryChars[k] = 'X';
                                    inputChars[j] = 'X';
                                }
                            }
                        }
                        boolean matched = true;
                        for (char c : dictionaryChars) {
                            if (c != 'X') {
                                matched = false;
                            }
                        }
                        if (matched) {
                            anagrams.addAll(m.getValue());
                        }
                    }
                }
                if (!anagrams.isEmpty()) {
                    return anagrams;
                }
            }
            return anagrams;
        }
    }

    private static Set<String> longestWord(String letters, Dictionary dictionary) {
        Set<String> result = dictionary.getAnagrams(letters);
        System.out.println(result);
        return result;
    }

    private static boolean doTestsPass() {
        Dictionary dictionary = new Dictionary(new String[]{"to", "toe", "toes",
            "doe", "dog", "dogs",
            "god", "book", "banana"});

        boolean result = new HashSet<>(Collections.singletonList("toe")).equals(longestWord("toe", dictionary));
        result &= new HashSet<>(Arrays.asList("doe", "dog", "god")).equals(longestWord("doeg", dictionary));
        result &= new HashSet<>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dictionary));
        return result;
    }

    /**
     * Main method to run the tests.
     * @param args probably empty
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}