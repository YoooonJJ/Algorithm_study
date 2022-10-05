package baekjoon._1000;

import baekjoon._15000.No15596;

import java.io.*;

public class No1110 {// 백준 더하기 사이클
    // https://www.acmicpc.net/problem/1110
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int result = new No1110().solution(Integer.parseInt(str));
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
    private int solution(int n){
        int a,b,c,d;
        if(n < 10){  // 입력받은 수를 한자리 숫자로
            a = 0;
            b = n;
        } else {
            a = n/10;
            b = n%10;
        }
        int cnt = 0;
        while(true){
            // 26.  2 + 6 = 8 -> 84. 8 + 4 = 12.
            // a 와 b 를 더한 숫자를 다시 한자리 숫자로
            c = (a+b)%10;
            d = (b*10)+c;
            cnt ++; // 입력된 정수가 0이더라도 한번은 덧셈을 진행하게 됨.
            if(d == n){
                break;
            }
            a = d/10;
            b = d%10;
        }
        return cnt;
    }

}
