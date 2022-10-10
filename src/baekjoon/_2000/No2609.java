package baekjoon._2000;

import java.io.*;

public class No2609 { // 백준 최대공약수와 최소공배수
    // https://www.acmicpc.net/problem/2609
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int gdc = new No2609().getGdc(a,b);
        int lcm = new No2609().getLcm(a,b);
        System.out.println("최대 공약수 : " + gdc);
        System.out.println("최소 공배수 : " + lcm);

        // 최소공배수
        System.out.println(a*b/gdc);

        br.close();
    }
    private int getGdc(int a, int b){
        System.out.println(a+" % " + b +" = " + a%b);
        if(a % b == 0){
            return b; // 나머지가 0이 될떄까지 나눈 수가 a,b 의 최대 공약수
        }
        return getGdc(b, a%b); // 나머지가 0이 아니면 0이 될때까지 나눈다.
    }
    // 유클리드 호제법 : 두 수의 최대 공약수를 구하는 알고리즘
    // 자연수 a와 b에 대해서 a를 b로 나눈 나머지를 r 이라고 한다면, a, b의 최대 공약수와 b,r의 최대공약수는 같다.
    // 60, 48 이 주어졌을 때,  60을 48로 나눈 나머지는 12.
    // 60 과 48의 최대공약수와  48과 12의 최대공약수는 같다는 것.

    // a 를 b로 나눈 나머지 r 을 구하고,  b 를 r 로 나눈 나머지 r' 을 구한다.
    // 나머지가 0이 될때 나눈수가 a,b 의 최대 공약수가 된다.

    // 유클리드 호제법에 따른 최소공배수는
    // 최소 공배수 : (a*b)/gdc(a,b)
    private int getLcm(int a, int b){
        return (a*b)/getGdc(a,b);
    }



    // 기초 수학 -----------------------
    // 최대공약수 Greatest Common Divisor, GDC
    // 0이 아닌 두 개 이상의 정수의 공통되는 약수 중에서 가장 큰 수  (약수는 어떤 수를 나누어떨어지게 하는 수)
    // ex)  12의 약수 : 1, 2, 3, 4, 6, 12
    //      18의 약수 : 1, 2, 3, 6, 9, 18
        // 12와 18의 공약수는 1,2,3,6 이고 이 중 6이 최대 공약수
        // gdc(12,18) = 6

    // 최대공약수를 구하는 방법 1 : 공약수로 나누기
        // 60과 48을 소인수 분해 해보자 -> 나누는 수는 꼭 공약수여야 한다.
        // 2 ) 60 48
        // 2 ) 30 24
        // 3 ) 15 12
        //      5  4  -> 5와 4는 공약수는 1밖에 없는 서로소
        // 60과 48의 최대 공약수는 2*2*3 = 2^2*3 = 12
    // 최대공약수를 구하는 방법 2 : 지수 이용
        // 소인수 분해해서 지수가 나오게 해야한다.
        // 60 = 2*2*3*5 = 2^2*3*5
        // 48 = 2*2*2*2*3 = 2^4*3
        // 여기에서 공통된 소수는 2와 3 임. 60은 2^2 이고, 48 은 2^4 인데 지수가 작을걸 씀.
        // 따라서 최대 공약수는 2^2*3 이 된다.
    // gdc(60, 48) = 12

    // 최소공배수 Lowest Common Multiple, LCM
    // 공배수 : 0이 아닌 두 수 이상의 여러 수의 공통된 배수(최소공배수의 배수)
    // 최소공배수는 공배수 중 최소인 수
    // 최소공배수를 구하는 방법은 최대공약수를 구하는 방법과 같다.

    // 최소공배수를 구하는 방법 1 : 공약수로 나누기
        // 최소 공배수는 공약수에 서로소까지 곱한다.
        // 서로소가 나올때까지 공약수로 나누고, 나온 공약수와 서로소를 모두 곱한다.
        // 60 과 48의 최소공배수는 2^4*3*5 = 240
    // 최소공배수를 구하는 방법 2 : 지수 이용
        //  두 수의 공통인 소수 중에서 지수가 더 큰걸 사용하고, 공통이 아닌 소수는 모두 다 사용한다.
        // 60 = 2^2*3*5
        // 48 = 2^4*3
        // 최소 공배수 = 2^4*3*5
    // lcm(60,48) = 240

}

