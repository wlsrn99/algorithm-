package 거북이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
# 요구 사항
F: 한 눈금 앞으로
B: 한 눈금 뒤로
L: 왼쪽으로 90도 회전
R: 오른쪽으로 90도 회전
L과 R명령을 내렸을 때, 로봇은 이동하지 않고, 방향만 바꾼다
명령을 나열한 것을 거북이 로봇의 컨트롤 프로그램
 항상 x축과 y축에 평행한 방향으로만 이동
 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이
 거북이는 가장 처음에 (0, 0)에 있고, 북쪽을 쳐다보고 있다

 거북이가 지나간 영역이 직사각형을 만들지 않는 경우도 있다. 예를 들어, FFLLFF인 경우에 거북이는 y축의 위로만 지나다닌다.
 이 경우에 거북이가 지나간 영역을 모두 포함하는 직사각형은 선분이고, 선분은 한 변이 0인 직사각형으로 생각할 수 있다. 따라서, 선분의 경우에 넓이는 0이 된다.
# 내가 생각한 논리
최소 x값과 최대 x값, 최소 y값과 최대 y값을 구한뒤
x와 y각각 최대 최소와의 차를 구한 절댓값을 곱하면 넓이가 나오지 않을까
L일때 왼쪽으로 90도 회전
-> 결국 오른쪽으로 270도 회전
R일때 오른쪽으로 90도 회전

초기값이 북쪽, 0 도라고 가정하면
0이 y값증가
90이 x값 증가
180이 y값 감소
270이 x값 감소

sum이 270보다 커질때 360을 빼면 방향이 나올 것이다
 */
public class Main {
    static int minX = 0;
    static int minY = 0;
    static int maxX = 0;
    static int maxY = 0;
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            char[] input = br.readLine().toCharArray();
            int size = input.length;


            int angle = 0; //각도

            for(int j = 0; j < size; j++){
                if(input[j] == 'F'){
                    coordinateF(angle);
                }else if(input[j] == 'B'){
                    coordinateB(angle);
                }else if(input[j] == 'L'){
                    //각도 + 270
                    angle += 270;
                    if(angle > 270){
                        angle -= 360;
                    }
                }else if(input[j] == 'R'){
                    //각도 + 90
                    angle += 90;
                    if(angle > 270){
                        angle -= 360;
                    }
                }
            }
            //직사각형의 넓이
            int area = Math.abs(maxY - minY) * Math.abs(maxX - minX);
            System.out.println(area);
            // 초기값 초기화
            minX = 0;
            minY = 0;
            maxX = 0;
            maxY = 0;
            x = 0;
            y = 0;
        }
    }

    // 앞으로 가기
    private static void coordinateF(int angle){
        if(angle == 90){
            x += 1;
        }else if(angle == 270){
            x -= 1;
        }else if(angle == 180){
            y -= 1;
        }else{
            y += 1;
        }
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
    }

    // 뒤로 가기
    private static void coordinateB(int angle){
        if(angle == 90){
            x -= 1;
        }else if(angle == 270){
            x += 1;
        }else if(angle == 180){
            y += 1;
        }else{
            y -= 1;
        }
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
    }

}
