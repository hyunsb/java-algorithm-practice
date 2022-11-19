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
        System.out.println(T.solution2(str, word));
    }

    public int solution2(String a, String b){
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char c : b.toCharArray()) bm.put(c,bm.getOrDefault(c, 0) +1);
        int L = b.length()-1;
        for(int i=0; i<L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) +1);

        int lt = 0;
        for(int rt=L; rt<a.length(); rt++){
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) +1);
            if (am.equals(bm)) answer++;

            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }

    public int solution(String str, String word){
        HashMap<Character, Integer> wordMap = initializeHashMap(word);

        int lt = 0, count = 0;
        for(int rt=word.length()-1; rt<str.length(); rt++){
            HashMap<Character, Integer> strMap = initializeHashMap(str.substring(lt++, rt+1));
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


    private boolean isAnagram(HashMap<Character, Integer> firstWord, HashMap<Character, Integer> secondWord) {
        for(char key : firstWord.keySet())
            if(firstWord.get(key) != secondWord.get(key)) return false;
        return true;
    }
}
