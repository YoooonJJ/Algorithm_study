package baekjoon._11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11653 { // 백준 소인수분해
    // https://www.acmicpc.net/problem/11653
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        new No11653().factorization_1(n);
        new No11653().factorization_2(n);
        br.close();
    }
    private void factorization_1(int n){
        int i = 2;
        while(n >= i){
            if(n % i == 0){
                System.out.println(i);
                n /= i;
            }else{
                i++;
            }
        }
    }
    private void factorization_2(int n){
        for(int i = 2; i<= n; i++){
            while(n % i == 0){
                System.out.println(i);
                n/=i;
            }
        }
    }

}
