package programmers_test.level_0;

import java.io.*;
import java.util.Arrays;

public class PlusFraction { // 프로그래머스 연습문제 분수의 덧셈
    // https://school.programmers.co.kr/learn/courses/30/lessons/120808
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int denum1 = Integer.parseInt(str[0]);
        int num1 = Integer.parseInt(str[1]);
        int denum2 = Integer.parseInt(str[2]);
        int num2 = Integer.parseInt(str[3]);

        int[] result = new PlusFraction().solution(denum1, num1, denum2, num2);
        bw.write(Arrays.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
    private int[] solution(int denum1, int num1, int denum2, int num2){
        int[] answer = new int[2];
        // 분자 구하기
        int denum = denum1 * num2 + denum2 * num1;
        System.out.println(denum);  // 1*4 + 3*2 = 4+6 = 10
        // 분모 구하기
        int num = num1 * num2;
        System.out.println(num); // 2*4 = 8;

        // 분자와 분모의 최대공약수가 1이 아닌 경우 최대공약수로 나눈다.
        int gdc = new PlusFraction().getGdc(denum, num);
        if(gdc != 1){
            denum /= gdc;
            num /= gdc;
        }
        answer[0] = denum;
        answer[1] = num;

        return answer;
    }
    private int getGdc(int a, int b){
        if(a % b == 0){
            return b;
        }
        return getGdc(b, (a%b));
    }
}
