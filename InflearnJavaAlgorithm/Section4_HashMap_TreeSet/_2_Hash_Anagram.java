package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class _2_Hash_Anagram {

    public static void main(String[] args) {
        _2_Hash_Anagram T = new _2_Hash_Anagram();
        Scanner sc = new Scanner(System.in);

        String firstWord = sc.next();
        String SecondWord = sc.next();
        System.out.println(T.solution(firstWord, SecondWord));

    }

    private static final String YES = "YES";
    private static final String NO = "NO";

    public String solution(String firstWord, String secondWord){
        HashMap<Character, Integer> firstWordAlphabetCount = initializeAlphabetCount(firstWord);
        HashMap<Character, Integer> SecondWordAlphabetCount = initializeAlphabetCount(secondWord);

        if(isSameSize(firstWordAlphabetCount, SecondWordAlphabetCount)
                && isSameKey(firstWordAlphabetCount, SecondWordAlphabetCount)
                && isAnagram(firstWordAlphabetCount, SecondWordAlphabetCount))
            return YES;

        return NO;
    }

    private HashMap<Character, Integer> initializeAlphabetCount(String word){
        HashMap<Character, Integer> alphabetCount = new HashMap<>();
        for(char alphabet : word.toCharArray())
            alphabetCount.put(alphabet, alphabetCount.getOrDefault(alphabet, 0) + 1);
        return alphabetCount;
    }

    private boolean isSameSize(HashMap<Character, Integer> firstWord,
                               HashMap<Character, Integer> secondWord){
        return firstWord.size() == secondWord.size();
    }

    private boolean isSameKey(HashMap<Character, Integer> firstWord, HashMap<Character, Integer> secondWord){
        Set<Character> firstKeySet = firstWord.keySet();
        Set<Character> secondKeySet = secondWord.keySet();

        firstKeySet.retainAll(secondKeySet);
        return firstKeySet.size() == secondKeySet.size();
    }

    private boolean isAnagram(HashMap<Character, Integer> firstWord, HashMap<Character, Integer> secondWord) {
        for(char key : firstWord.keySet())
            if(firstWord.get(key) != secondWord.get(key)) return false;
        return true;
    }


}
