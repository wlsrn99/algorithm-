package 펠린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    // 입력 문자열 배열
    public static String[] strs;
    // 입력 문자열 길이
    public static int len;
    // 홀수 개수인 문자
    public static String odd;

    // 문자와 등장 횟수를 저장하는 HashMap
    public static HashMap<String, Integer> map = new HashMap<>();
    // 에러 문자열
    public static String ERROR = "I'm Sorry Hansoo";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력 및 분리
        strs = br.readLine().split("");
        len = strs.length;


        // 문자와 등장 횟수를 저장하는 HashMap 생성
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // 회문이 가능한지 확인하고 결과 출력
        if (!canPalindrome()) {
            System.out.println(ERROR);
        } else {
            // 회문 만들기
            System.out.println(makePalindrome(getSortedList(), isOdd()));
        }
    }

    // 문자열의 길이가 홀수인지 확인
    public static boolean isOdd() {
        return len % 2 != 0;
    }

    // 등장 횟수에 따라 정렬된 문자열 리스트 반환
    public static ArrayList<String> getSortedList() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            for (int i = 0; i < map.get(s) / 2; i++) {
                list.add(s);
            }
        }
        Collections.sort(list);
        return list;
    }


    // 회문 생성
    public static String makePalindrome(ArrayList<String> strs, boolean isOdd) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        // 정렬된 문자열 리스트로부터 회문 생성
        for (String s : strs) sb.append(s);
        result.append(sb);
        if (isOdd) result.append(odd); // 홀수 개수인 문자가 존재할 경우 추가
        result.append(sb.reverse()); // 역순으로 회문 생성

        return result.toString();
    }

    // 회문이 가능한지 확인
    public static boolean canPalindrome() {
        // 문자열 길이가 짝수인 경우
        if (len % 2 == 0) {
            // 모든 문자의 등장 횟수가 짝수여야 회문이 가능
            for (Integer value : map.values()) {
                if (value % 2 != 0) return false;
            }
            return true;
        }

        // 문자열 길이가 홀수인 경우
        int cnt = 1; // 홀수 개수인 문자가 하나만 존재해야 하므로 카운트 유지
        for (String key : map.keySet()) {
            if (cnt < 0) return false; // 홀수 개수인 문자가 두 개 이상이라면 회문이 불가능
            if (map.get(key) % 2 != 0) { // 홀수 개수인 문자 발견 시
                cnt--;
                odd = key; // 홀수 개수인 문자 저장
            }
        }
        return true;
    }
}

