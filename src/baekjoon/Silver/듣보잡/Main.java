package 듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        //듣도 못한 사람의 수 N
        //보도 못한 사람의 수 M

        Set<String> notHeardPeople = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        for(int i = 0; i < N; i++){
            notHeardPeople.add(br.readLine());
        }

        int count = 0;
        Set<String> result = new TreeSet<>();
        for(int i = 0; i < M; i++){
            String notSeePerson = br.readLine();
            if(notHeardPeople.contains(notSeePerson)){
                result.add(notSeePerson);
                count++;
            }
        }

        System.out.println(count);
        for(String r : result){
            System.out.println(r);
        }


    }
}
