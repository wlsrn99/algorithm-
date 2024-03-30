package N과M_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 자연수의 개수
    static int M; // 수열의 길이
    static List<String> sortedNaturalNumsList; // 오름차순으로 정렬된 자연수

    static String[] selectedSequence; // 선택된 수열
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        M = Integer.parseInt(NM[1]);

        String[] naturalNums = br.readLine().split(" ");
        sortedNaturalNumsList = new ArrayList<>();
        for (String num : naturalNums) {
            sortedNaturalNumsList.add(num);
        }
        Collections.sort(sortedNaturalNumsList);
        N = sortedNaturalNumsList.size();
        selectedSequence = new String[N];
        check = new boolean[N];


        Set<String> result = new LinkedHashSet<>();
        findSequence(0, result);
        for(String arr : result){
            System.out.println(arr);
        }
    }

    private static void findSequence(int selectedIdx, Set<String> result) {
        if (selectedIdx == M) {
            String resultOne = "";
            for (int i = 0; i < M; i++) {
                resultOne += selectedSequence[i] + " ";
            }
            result.add(resultOne);
            resultOne = "";
            return;
        }

        for (int i = 0; i < N; i++) {
//            if (!check[i]) {
//                check[i] = true;
                selectedSequence[selectedIdx] = sortedNaturalNumsList.get(i);
                findSequence(selectedIdx + 1, result);
//                check[i] = false;
//            }
        }
    }
}
