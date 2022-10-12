package programmers_test.level_0;

import java.io.*;

public class DividePizza { // 프로그래머스 연습문제 피자 나눠 먹기(2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120815
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = new DividePizza().solution_1(n);
        bw.write(String.valueOf(result));
        bw.write("\n");

        result = new DividePizza().solution_2(n);
        bw.write(String.valueOf(result));
        bw.write("\n");

        result = new DividePizza().solution_3(n);
        bw.write(String.valueOf(result));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();

    }

    // 최소 공배수를 이용한 풀이   // 0.01 ~ 0.03ms, 65 ~ 80MB
    private int solution_1(int num){
        System.out.println("피자 먹을 인원  : " + num);
        int lcm = getLcm(num,6);
        num = (num % 6 == 0) ? (num/6) : lcm;

        System.out.println("필요한 피자 조각 개수 : " + lcm);
        if(lcm % 6 == 0){
            return lcm/6;
        }
        return num;
    }
    private int getGdc(int a, int b){
        System.out.println("getGdc 계산.. a: " + a + ", b: "+ b);
        if(a%b == 0){
            System.out.println("최대 공약수는 " + b);
            return b;
        }
        return getGdc(b, (a%b));
    }
    private int getLcm(int a, int b){
        System.out.println("최소공배수는 ("+ a+"*"+b+")/"+getGdc(a,b) + " = " + (a*b)/getGdc(a,b) );
        return (a*b)/getGdc(a,b);
    }

    // solution_1 을 간결하게
    private int solution_2(int num){
        return getLcm(num, 6)/6;
    }
    // lcm 은 num 과 6 의 최소 공배수 이므로
    // getLcm 을 통해 얻는 값은 주어지는 총 피자 조각의 개수이며 6의 배수이다.


    // 반복문으로 풀기  // 0.02ms ~ 0.03ms, 67MB ~ 86MB
    private int solution_3(int n){
        int answer = 0;
        for(int i=1; i<=n; i++){
            double temp = (i*6.0)/n;
            System.out.println(
                    "피자 먹을 사람 수 : " + n + " 명, " +
                    "인당 피자 조각 개수 : " + temp + " 개, " +
                    "피자 판 개수 : " + i );
            if(i * 6 % n == 0){
                answer = i;
                break;
            }
        }
        return answer;
    }
    // n의 범위가 크지 않기 때문에 실행 차이는 크지 않음.
}
