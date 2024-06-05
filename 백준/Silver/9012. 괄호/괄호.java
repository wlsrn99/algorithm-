

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // "(" 가 항상 먼저 나와야하고 "("의 갯수만큼 ")"가 나와야 한다
        // "("가 나온만큼 Stack에 집어넣고 ")"가 나온만큼 뺐을때 갯수가 0이면 만족한다
        // ")" 가 더 많이 나오면 바로 false

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String input = br.readLine();
            if(isVps(input)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean isVps(String input){
        Stack<Character> parenthesis = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == '('){
                parenthesis.push(c);
            }else {
                if (parenthesis.isEmpty()) {
                    return false;
                }
                parenthesis.pop();
            }
        }
        return parenthesis.isEmpty();
    }
}
