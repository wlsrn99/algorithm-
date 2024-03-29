package 숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sangGeunCard = br.readLine();
        int M = Integer.parseInt(br.readLine());
        String cardType = br.readLine();

        String[] sgc = sangGeunCard.split(" ");
        Map <String, Integer>sangGeunCardType = new HashMap<>();
        for(int i = 0; i < N; i++){
            sangGeunCardType.put(sgc[i],sangGeunCardType.getOrDefault(sgc[i],0)+1);
        }

        StringBuilder sb = new StringBuilder();
        String[] cardTypeKeys = cardType.split(" ");

        for(String key : cardTypeKeys){
            Integer sangGeunCardValue = sangGeunCardType.get(key);

            if(sangGeunCardValue != null) {
                sb.append(sangGeunCardValue).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
