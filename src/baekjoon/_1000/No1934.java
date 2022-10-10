package baekjoon._1000;

import java.io.*;
import java.util.StringTokenizer;

public class No1934 { // 백준 최소공배수
    // https://www.acmicpc.net/problem/1934
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lcm = new No1934().getLcm(a,b);
            System.out.println(lcm);
        }
        br.close();

    }
    private int getGdc(int a, int b){
        if(a % b == 0){
            return b;
        }
        return getGdc(b,a%b);
    }
    private int getLcm(int a, int b){
        return (a*b)/getGdc(a,b);
    }
}
