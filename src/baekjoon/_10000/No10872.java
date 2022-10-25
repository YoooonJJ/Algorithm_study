package baekjoon._10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10872 { // 백준 팩토리얼
    // https://www.acmicpc.net/problem/10872
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i=1; i<=n; i++){ // 반복문 사용
            result *= i;
        }
        System.out.println(result);
        System.out.println(new No10872().solution(n));
        br.close();
    }
    private int solution(int n){
        if( n == 1 || n == 0) return 1;
        return n * solution(n-1);
    }
    // n-1 씩 하여 메소드를 다시 호출한다.
    // n 이 10 이라면 10 * 9 * 8 * ... 2 * 1 이 된다.


}
