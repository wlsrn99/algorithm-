import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] inputHeights = br.readLine().split(" ");
        int[] topHeights = new int[N];
        
        for (int i = 0; i < N; i++) {
            topHeights[i] = Integer.parseInt(inputHeights[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[N];
        
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && topHeights[stack.peek()] <= topHeights[i]) {
                stack.pop();
            }
            
            results[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
