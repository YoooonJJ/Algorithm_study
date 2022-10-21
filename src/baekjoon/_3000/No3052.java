package baekjoon._3000;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class No3052 { // 백준 나머지
    //https://www.acmicpc.net/problem/3052
    private int solution(int[] num){
        Set<Integer> set = new HashSet<>();
        for(int i : num) set.add(i % 42);
        return set.size();
    }
    // 나머지 값이 중복될 수 있으므로 중복을 제외하는 Set 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[10];
        for(int i=0; i<num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int result = new No3052().solution(num);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
