package 회사에있는사람;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, String> person = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String record = sc.nextLine();
            String[] detailRecord = record.split(" ");
            person.put(detailRecord[0], detailRecord[1]);
        }

        String[] result = checkWorkingPerson(person);
        for(String p : result){
            System.out.println(p);
        }
    }

    //일하고있는 사람을 확인해주는 메서드
    private static String[] checkWorkingPerson(Map<String,String> person){
        List<String> workingPerson = new ArrayList<>();

        Set<String> keys = person.keySet();
        for(String key: keys){
            if(person.get(key).equals("enter")){
                workingPerson.add(key);
            }
        }

        String[] sortedPerson = workingPerson.toArray(new String[0]); // 현재 일하고있는 사람 배열
        Arrays.sort(sortedPerson);

        String[] reversePerson = new String[sortedPerson.length];
        for(int i = 0; i < sortedPerson.length; i++){
            reversePerson[i] = sortedPerson[sortedPerson.length - i - 1];
        }
        return reversePerson;// 일하고 있는 사람 역순으로 정렬한 배열
    }
}
