package baekjoon._2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2908 { // 백준 상수
    // https://www.acmicpc.net/problem/2908
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        new No2908().solution_1(a,b);
        new No2908().solution_2(a,b);

        br.close();
    }
    // int 배열 사용
    private void solution_1(int a, int b){
        int[] arrA = new int[3];
        for(int i=0; i < arrA.length; i++){
            arrA[i] = a % 10;
            a /= 10;
        }
        int[] arrB = new int[3];
        for(int j=0; j < arrB.length; j++){
            arrB[j] = b % 10;
            b /= 10;
        }
        int tempA = 0; int tempB = 0;
        for(int i : arrA){ tempA *= 10; tempA += i;}
        for(int i : arrB){ tempB *= 10; tempB += i;}

        int result = Math.max(tempA, tempB);
        System.out.println(result);
    }

    // StringBuilder 사용 (StringBuffer 도 동일함)
    private void solution_2(int a, int b){
        StringBuilder sb;
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        sb = new StringBuilder(strA);
        int revA = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(strB);
        int revB = Integer.parseInt(sb.reverse().toString());

        int result = Math.max(revA, revB);
        System.out.println(result);
    }
}
