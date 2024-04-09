package 스카이라인쉬운거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 50,000)
n개의 줄에는 왼쪽부터 스카이라인을 보아 갈 때 스카이라인의 고도가 바뀌는 지점의 좌표 x와 y가 주어진다.
(1 ≤ x ≤ 1,000,000. 0 ≤ y ≤ 500,000) 첫 번째 지점의 x좌표는 항상 1이다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] skyline = new int[n][2];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            skyline[i][0] = Integer.parseInt(input[0]);
            skyline[i][1] = Integer.parseInt(input[1]);
        }

        int size = skyline.length;
        int y = skyline[0][1];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(y);
        //건물의 높이가 작아지면 건물이 끝났기 때문에 빼준다
        for(int i = 1; i < size; i++){
            y = skyline[i][1];
            while(!stack.isEmpty() && stack.peek() > y){
                count++;
                stack.pop();
            }
        //건물의 높이가 같으면 같은 건물이므로 넣지않는다
            if(!stack.isEmpty() && stack.peek() == y){
                continue;
            }
        //그 외에 경우 현재 건물을 넣어준다
            stack.push(y);
        }
        //건물이 남아있는 경우 개수를 세어준다
        while (!stack.isEmpty()){
            if(stack.pop() > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
