

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String modifiedInput = input.replace("::", ":#:");
        String[] contractionIp = modifiedInput.split(":");


        StringBuilder sb = new StringBuilder();
        int totalSize = contractionIp.length;

        for(int i = 0; i < totalSize; i++){
            int size = contractionIp[i].length();
            // :일경우
            if(contractionIp[i].equals("#")){
                for(int j = 0; j < 8 - (totalSize-1); j++){
                    sb.append("0000").append(":");
                }
            }else {
                if (size != 4) {
                    //:가 아니고 문자열의 길이가 부족할 때
                    for (int j = size; j < 4; j++) {
                        sb.append("0");
                    }
                    sb.append(contractionIp[i]);
                } else { // 문자열의 길이가 4일때
                    sb.append(contractionIp[i]);
                }
                sb.append(":");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
