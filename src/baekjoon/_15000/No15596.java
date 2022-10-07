package baekjoon._15000;

import java.util.Scanner;

public class No15596 { // 백준 정수 N개의 합
    // https://www.acmicpc.net/problem/15596
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new No15596().makeArr(n);
        long result = new Test().sum(a);
        System.out.println(result);
        sc.close();
    }
    private int[] makeArr(int n){
        int[] arr = new int[n];
        for(int i=1; i<=n; i++){
           arr[i-1] = i;
        }
        return arr;
    }
}
class Test{
    public long sum(int[] a){
        long answer = 0;
        for(int e : a){
            answer += e;
        }
        return answer;
    }
}
