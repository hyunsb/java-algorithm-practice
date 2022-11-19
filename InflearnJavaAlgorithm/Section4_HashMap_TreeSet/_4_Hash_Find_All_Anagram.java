package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class _4_Hash_Find_All_Anagram {
    public static void main(String[] args) {
        _4_Hash_Find_All_Anagram T = new _4_Hash_Find_All_Anagram();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String word = sc.next();

        System.out.println(T.solution(str, word));
    }

    public int solution(String str, String word){
        HashMap<Character, Integer> wordMap = initializeHashMap(word);

        int lt = 0, count = 0;
        for(int rt=word.length()-1; rt<str.length(); rt++){
            System.out.println(str.substring(lt, rt+1));
            HashMap<Character, Integer> strMap = initializeHashMap(str.substring(lt++, rt+1));
            System.out.println(wordMap + " : " + strMap);
            if (isSameSize(wordMap, strMap) && isAnagram(wordMap,strMap))
                count += 1;
        }
        return count;
    }

    private HashMap<Character, Integer> initializeHashMap(String word){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }

    private boolean isSameSize(HashMap<Character, Integer> firstWord,
                               HashMap<Character, Integer> secondWord){
        return firstWord.size() == secondWord.size();
    }

//    private boolean isSameKey(HashMap<Character, Integer> firstWord, HashMap<Character, Integer> secondWord){
////        Set<Character> firstKeySet = firstWord.keySet();
////        Set<Character> secondKeySet = secondWord.keySet();
////
////        firstKeySet.retainAll(secondKeySet);
////        return firstKeySet.size() == secondKeySet.size();
//    }

    private boolean isAnagram(HashMap<Character, Integer> firstWord, HashMap<Character, Integer> secondWord) {
        for(char key : firstWord.keySet())
            if(firstWord.get(key) != secondWord.get(key)) return false;
        return true;
    }
}
