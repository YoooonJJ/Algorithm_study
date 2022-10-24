package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoDimensionalArray { // 프로그래머스 연습문제 2차원으로 만들기
    //https://school.programmers.co.kr/learn/courses/30/lessons/120842
    private void solution(int[] num_list, int n) {
        int len = num_list.length / n;
        int[][] result = new int[len][n];
        int temp = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = num_list[temp];
                temp++;
            }
        }
        System.out.println(Arrays.deepToString(result));
    }

    private void solution_2(int[] num_list, int n){
        int len = num_list.length;
        int[][] answer = new int[len/n][n];
        for(int i=0; i<len; i++){
            answer[i/n][i%n] = num_list[i];
        }
        System.out.println(Arrays.deepToString(answer));
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        int[] num_list = Arrays.stream(list).mapToInt(Integer::parseInt).toArray();
        new TwoDimensionalArray().solution(num_list, n);
        new TwoDimensionalArray().solution_2(num_list, n);
        br.close();
    }

}
