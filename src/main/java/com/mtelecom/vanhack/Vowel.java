package com.mtelecom.vanhack;

import java.util.HashSet;

/**
 * Hello world!
 */
public class Vowel {

    // Returns true if x is vowel.
    static boolean isVowel(char x) {
        // Function to check whether a character is vowel or not
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
    }

    static int vowelsubstring(String s) {
        int word = 0;
        HashSet<Character> hash = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)) == true) {
                hash.add(s.charAt(i));
                if (hash.size() == 5)   {
                    word++;
                }
            } else {
                hash.clear();
            }
        }
        return word;
    }

    static int vowelsubstringOld(String s) {
        int word = 0;
        HashSet<Character> hash = new HashSet<Character>();
        // To store vowels
        // Outer loop picks starting character and
        // inner loop picks ending character.
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // If current character is not vowel,
                // then no more result substrings
                // possible starting from str[i].
                if (isVowel(s.charAt(j)) == false)
                    break;
                // If vowel, then we insert it in hash
                hash.add(s.charAt(j));
                // If all vowels are present in current
                // substring
                if (hash.size() == 5) {
                    word++;
                    System.out.print(s.substring(i, j + 1) + " ");
                }
            }
            hash.clear();
        }
        return word;
    }

}
