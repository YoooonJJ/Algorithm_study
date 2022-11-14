package programmers_test.level_1;

import java.util.Scanner;

public class IntegerSquareRoot {
    // 프로그래머스 연습문제 정수 제곱근 판별
    //https://school.programmers.co.kr/learn/courses/30/lessons/12934

    private long solution_1(long n){
        long answer = 0;
        boolean check = false;
        for(long i = 1; i*i <= n; i++){
            if( i * i == n){
                check = true;
                answer = i;
            }
        }
        if(check){
            return (answer+1)*(answer+1);
        }else{
            return -1;
        }
    }

    private long solution_2(long n){
        if(Math.pow((int)Math.sqrt(n),2) == n){
            return (long)Math.pow(Math.sqrt(n)+1 ,2);
        }
        return -1;
    }

    private long solution_3(long n){
        double d = Math.sqrt(n);
        return (Math.floor(d) == d) ? (long) Math.pow(d + 1, 2) : -1;
    }
    // Math.floor 내림
    // Math.ceil  올림
    // Math.round 반올림
    // d가 d를 내림 한것과 동일 하다면 d는 제곱근

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long answer = new IntegerSquareRoot().solution_1(n);
        System.out.println(answer);

        answer = new IntegerSquareRoot().solution_2(n);
        System.out.println(answer);

        answer = new IntegerSquareRoot().solution_3(n);
        System.out.println(answer);

        sc.close();

    }
}
