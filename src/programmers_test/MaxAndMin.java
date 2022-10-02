package programmers_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAndMin { // 프로그래머스 연습문제 최댓값과 최솟값
    public static void main(String[] args) throws IOException {
        new MaxAndMin().solution();
    }
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] list = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        List<Integer> li = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        System.out.println(Arrays.stream(list).max().getAsInt());
        System.out.println(li.get(li.size() - 1));
        br.close();
    }
}
