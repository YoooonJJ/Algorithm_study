package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayAvg { // 프로그래머스 연습문제 배열의 평균값
    // https://school.programmers.co.kr/learn/courses/30/lessons/120817
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        double result = new Solution().solution_1(numbers);
        System.out.println(result);
        result = new Solution().solution_2(numbers);
        System.out.println(result);
        result = new Solution().solution_3(numbers);
        System.out.println(result);

        br.close();
    }
}
class Solution{
    //테스트 채점 결과 속도 차이가 있었음.

    // 2.00ms ~ 2.88ms, 67.3MB ~ 78.3MB
    public double solution_1(int[] numbers){
        return Arrays.stream(numbers).average().orElse(0);
    }
    // 0.03ms ~ 0.04ms , 68MB ~ 84.8MB
    public double solution_2(int[] numbers){
        int temp = 0; int cnt = numbers.length;
        for(int i : numbers){
            temp += i;
        }
        return (double)temp/cnt;
    }
    // 0.78ms ~ 3.03ms , 72MB  73MB
    public double solution_3(int[] numbers){
        int total = Arrays.stream(numbers).sum();
        int cnt = numbers.length;
        return (double)total/cnt;
    }


}
