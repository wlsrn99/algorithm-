import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Set<Integer> numbers = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (!numbers.contains(a) && !numbers.contains(b) && !numbers.contains(c)) {
                count++;
            }

            numbers.add(a);
            numbers.add(b);
            numbers.add(c);
        }

        System.out.println(count);
    }
}
