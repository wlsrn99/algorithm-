package 추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //추월하는 차
        //처음 들어올때 차량별 각각 인덱스를 저장하고
        //나간 순서대로 차량별 처음 인덱스를 저장
        //-> 저장된 인덱스가 오른쪽에 위치한 숫자들보다 클 때 추월이라고 판단 가능하다

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
        // 처음 들어오는 차를 저장
        for(int i = 0; i < N; i++){
            cars.put(br.readLine(), i);
        }

        int count = 0;  // 추월한 횟수 저장
        int[] outCars = new int[N]; // 각 차량이 빠져나가는 순서
        //나간순서대로 차량의 처음 들어왔던 인덱스를 저장하는 배열
        for(int i = 0; i < N; i++){
            outCars[i] = cars.get(br.readLine());
        }

        // 저장된 인덱스가 오른쪽에 위치한 인덱스보다 클 때 추월
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
