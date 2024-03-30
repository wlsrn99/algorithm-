package 추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //추월하는 차
        // 나온 차들 중에서 현재 인덱스 숫자가 오른쪽에 위치한 숫자들보다 클 때
//        ZG508OK  0
//        PU305A   1
//        RI604B   2
//        ZG206A   3
//        ZG232ZF  4

//        PU305A   1  0
//        ZG232ZF  4  1
//        ZG206A   3  2
//        ZG508OK  0  3
//        RI604B   2  4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> cars = new HashMap<>();

        for(int i = 0; i < N; i++){
            cars.put(br.readLine(), i);
        }

        int count = 0;
        int[] outCars = new int[N];
        for(int i = 0; i < N; i++){
            outCars[i] = cars.get(br.readLine());
        }

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(outCars[i] > outCars[j]){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
