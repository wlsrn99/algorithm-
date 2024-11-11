

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] score;
    static int[][] maxDp;
    static int[][] minDp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        score = new int[n][3];
        maxDp = new int[n][3];
        minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int max = searchMax();
        int min = searchMin();
        System.out.println(max + " " + min);
    }

    private static int searchMax() {
        maxDp[0][0] = score[0][0];
        maxDp[0][1] = score[0][1];
        maxDp[0][2] = score[0][2];

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = score[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = score[i][1] + Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]);
            maxDp[i][2] = score[i][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);
        }

        return Math.max(Math.max(maxDp[n - 1][0], maxDp[n - 1][1]), maxDp[n - 1][2]);
    }

    private static int searchMin() {
        minDp[0][0] = score[0][0];
        minDp[0][1] = score[0][1];
        minDp[0][2] = score[0][2];

        for (int i = 1; i < n; i++) {
            minDp[i][0] = score[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = score[i][1] + Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]);
            minDp[i][2] = score[i][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        return Math.min(Math.min(minDp[n - 1][0], minDp[n - 1][1]), minDp[n - 1][2]);
    }
}