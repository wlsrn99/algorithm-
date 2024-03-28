package 평균;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String score = sc.nextLine();
        System.out.println(calculateAverage(N,score));
    }

    private static double calculateAverage(int n, String score){
        String[] oneScore = score.split(" ");
        double scoreSum = 0;
        double max = 0;

        for(String one : oneScore){
            double dOne = Double.parseDouble(one);
            if(max < dOne){
                max = dOne;
            }
            scoreSum += dOne;
        }

        return (scoreSum/max*100) / n;
    }
}
