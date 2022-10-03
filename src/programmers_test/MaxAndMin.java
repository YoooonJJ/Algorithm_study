package programmers_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAndMin { // 프로그래머스 연습문제 최댓값과 최솟값
    // https://school.programmers.co.kr/learn/courses/30/lessons/12939
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        new MaxAndMin().solution_1(s);
        new MaxAndMin().solution_2(s);
        br.close();
    }
    private void solution_1(String s){
        int[] list = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int min = list[0];
        int max = list[list.length-1];
        System.out.println(min + " " + max);
        //System.out.println(Arrays.stream(list).max().getAsInt());
    }
    private void solution_2(String s) {
        List<Integer> li = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        System.out.println(li.get(0)+ " " +li.get(li.size() - 1));
    }
}
