import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] heights = new int[257];
        int minHeight = 256;
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                heights[height]++;
                minHeight = Math.min(minHeight, height);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        
        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int time = 0;
            int inventory = B;
            
            for (int h = 0; h <= 256; h++) {
                if (heights[h] > 0) {
                    if (h < targetHeight) {
                        time += (targetHeight - h) * heights[h];
                        inventory -= (targetHeight - h) * heights[h];
                    } else if (h > targetHeight) {
                        time += 2 * (h - targetHeight) * heights[h];
                        inventory += (h - targetHeight) * heights[h];
                    }
                }
            }
            
            if (inventory >= 0 && time <= minTime) {
                minTime = time;
                resultHeight = targetHeight;
            }
        }
        
        System.out.println(minTime + " " + resultHeight);
    }
}