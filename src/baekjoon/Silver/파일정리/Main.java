package 파일정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> extension = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String fileList = br.readLine();
            String[] file = fileList.split("\\."); //이스케이프 문자로 특수 문자 처리

            extension.put(file[1], extension.getOrDefault(file[1], 0) + 1);
        }

        Set<String> sortedExtension = new TreeSet<>(extension.keySet());

        StringBuilder sb = new StringBuilder();
        for (String key : sortedExtension) {
            sb.append(key).append(" ").append(extension.get(key)).append("\n");
        }
        System.out.print(sb);
    }
}
