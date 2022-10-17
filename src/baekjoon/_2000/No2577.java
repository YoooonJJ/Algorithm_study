package baekjoon._2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class No2577 { // 백준 숫자의 개수
    // https://www.acmicpc.net/problem/2577
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] result = new No2577().solution_2(a,b,c);
        for(int j : result){
            System.out.println(j);
        }
        br.close();
    }
    private int[] solution_1(int a, int b, int c){
        int temp = a*b*c;
        int[] arr = Stream.of(String.valueOf(temp).split("")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[10];

        for(int i=0; i<cnt.length; i++){
            for (int k : arr) {
                if(k == i){
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    private int[] solution_2(int a, int b, int c){
        int temp = a*b*c;
        List<Integer> list = new ArrayList<>();
        while(temp > 0){
            list.add(temp % 10);
            temp /= 10;
        }
        Integer[] tempArr = list.toArray(new Integer[0]);

        int[] arr = Arrays.stream(tempArr).mapToInt(Integer::intValue).toArray();
        int[] cnt = new int[10];

        for(int i=0; i<cnt.length; i++){
            for(int j : arr){
                cnt[i] += ( i == j ) ? 1 : 0;
            }
        }
        return cnt;
    }
    // int 형 숫자의 자릿수를 구해야 할 때
    // 1. 문자열로 변환해서 문자열의 길이를 잰다
    // 2. Math 클래스를 이용해 int 형 변수 자체의 길이를 구한다.
    //      (int)(Math.log10(num)+1)

}
