package baekjoon._1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1978 { // 백준 소수찾기
    // https://www.acmicpc.net/problem/1978
    private int solution_1(int n, int[] numbers){
        int answer = 0;
        for(int i=0; i<n; i++){
            if(numbers[i] == 1){
                continue;
            }
            answer += new No1978().isPrime(numbers[i]);
        }
        return answer;
    }

    private int isPrime(int num){
        for(int i=2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int result = new No1978().solution_1(n,numbers);
        System.out.println(result);
        br.close();

    }
}
/*
Math.sqrt()
java.lang.Math 클래스의 sqrt() 메소드
double 타입의 인수를 전달하면 인수에 대한 double 타입의 제곱근 값을 리턴한다.
Math.sqrt(9)  -> 3.0
Math.sqrt(-1) -> NaN
제곱근은 음수가 나올 수 없으므로 음수 값이 인수로 전달되면 NaN(Not a Number) 리턴
* */