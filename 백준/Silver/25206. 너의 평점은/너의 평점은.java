import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // split으로 띄어쓰기 기준 배열 만들기
        // 평균 = (학점 x 과목평점)의 합 / 학점의 총합
        int gradeNum = 20;
        Scanner sc = new Scanner(System.in);

        double majorSum = 0;
        double gradesSum = 0;

        while(gradeNum > 0){
            String grade = sc.nextLine();
            double[] majorGrade = findMajorGrade(grade);
            if(majorGrade[1] == -1){
                gradeNum--;
                continue;
            }
            majorSum += (majorGrade[0] * majorGrade[1]);
            gradesSum += majorGrade[0];
            gradeNum--;
        }

        System.out.println(majorSum / gradesSum);
    }

    private static double[] findMajorGrade(String grade){
        String[] gradeDetail = grade.split(" ");
        double[] majorGrade = new double[2];

        majorGrade[0] = Double.parseDouble(gradeDetail[1]); //학점

        switch (gradeDetail[2]) { //과목평점
            case "A+":
                majorGrade[1] = 4.5;
                break;
            case "A0":
                majorGrade[1] = 4.0;
                break;
            case "B+":
                majorGrade[1] = 3.5;
                break;
            case "B0":
                majorGrade[1] = 3.0;
                break;
            case "C+":
                majorGrade[1] = 2.5;
                break;
            case "C0":
                majorGrade[1] = 2.0;
                break;
            case "D+":
                majorGrade[1] = 1.5;
                break;
            case "D0":
                majorGrade[1] = 1.0;
                break;
            case "F":
                majorGrade[1] = 0.0;
                break;
            default:
                majorGrade[1] = -1;
                break;
        }
    return majorGrade;
    }
}
