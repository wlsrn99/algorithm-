package 상수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num;
        try {
            num = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String [] nums = num.split(" ");
        System.out.println(findLargeNum(nums[0], nums[1]));

    }

    private static String findLargeNum(String num1, String num2){
        String temp1 = "";
        String temp2 = "";
        for(int i = 2; i >= 0; i--){
            temp1 += num1.charAt(i);
            temp2 += num2.charAt(i);
        }
        return (Integer.parseInt(temp2) > Integer.parseInt(temp1)) ? temp2 : temp1;
    }
}
