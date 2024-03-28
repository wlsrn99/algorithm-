package 단어공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alphabet ="";
        try {
            alphabet = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(findMostAlphabet(alphabet.toUpperCase()));

    }

    private static Character findMostAlphabet(String word){
        Map<Character, Integer> alphabetNum = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            alphabetNum.put(word.charAt(i), alphabetNum.getOrDefault(word.charAt(i), 0) + 1);
        }

        int max = 0;
        char most = '?';

        Set<Character> keys = alphabetNum.keySet();
        for(char key : keys){
            if(max < alphabetNum.get(key)){
                max = alphabetNum.get(key);
                most = key;
            }else if(max == alphabetNum.get(key)){
                most = '?';
            }
        }
        return most;
    }
}
