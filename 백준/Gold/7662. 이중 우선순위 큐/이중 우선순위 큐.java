import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char cmd = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (cmd == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (!map.isEmpty()) {
                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(key, map.get(key) - 1) == 1)
                        map.remove(key);
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}