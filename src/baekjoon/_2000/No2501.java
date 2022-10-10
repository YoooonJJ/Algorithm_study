package baekjoon._2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2501 { // 백준 약수 구하기
    // https://www.acmicpc.net/problem/2501
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] result = new No2501().divisor(n);
        System.out.println(Arrays.toString(result));
        if(result.length < k){
            System.out.println(0);
        }else{
            System.out.println(result[k-1]);
        }
        br.close();
    }
    private int[] divisor(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if( n % i == 0){
                list.add(i);
            }
        }
        Integer[] temp = list.toArray(new Integer[list.size()]);
        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }

}
