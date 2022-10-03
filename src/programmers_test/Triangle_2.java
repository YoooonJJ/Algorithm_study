package programmers_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_2 { // 프로그래머스 연습문제 삼각형의 완성조건(2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120868
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = (br.readLine()).split(" ");
        int[] sides = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        new Triangle_2().solution_1(sides);
        new Triangle_2().solution_2(sides);
        br.close();
    }
    private void solution_1(int[] sides){
        int answer_1 = 0;
        Arrays.sort(sides);
        int min = sides[0];
        int max = sides[1];
        int temp = 0;

        // 나머지 한 변이 될 수 있는 정수가 들어갈 공간
        List<Integer> result = new ArrayList<Integer>();
        // 가장 긴 변이 max 인 경우
        temp = max-min+1;
        for(int i = temp; i < min+max; i++){
            result.add(i);
        }
        // 나머지 한 변이 가장 긴 변인 경우
        temp = max + min -1;
        for(int j = temp; j > max; j--){
            result.add(j);
        }
        // result 중복 제거
        for(int k=0; k<result.size(); k++){
            for(int l=0; l<result.size(); l++){
                if(k != l){
                    if (result.get(l).equals(result.get(k))){
                        result.remove(l);
                    }
                }
            }
        }
        answer_1 = result.size();
        System.out.println("solution_1 : " + answer_1);
    }

    private void solution_2(int[] sides){
        int answer_2 = 0;
        // 가장 긴 변은 나머지 두 변의 길이의 합보다 작아야 함.
        // int[] sides = {11, 7} 인 경우,
        int max = sides[0] + sides[1] -1; // max =  11 + 7 - 1 = 17
        int min = 0;

        if(sides[0] > sides[1]){
            min = sides[0] - sides[1];  // min = 11 - 7 = 4
        }else {
            min = sides[1] - sides[0];
        }
        answer_2 = max - min; // 17 - 4 = 13
        // 나머지 한 변이 될 수 있는 정수의 경우는 4부터 17까지. 총 13개
        System.out.println("solution_2 : " + answer_2);
    }
}
