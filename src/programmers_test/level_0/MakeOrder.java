package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeOrder { // 프로그래머스 연습문제 진료순서 정하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120835
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] emergency = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[] result = new MakeOrder().solution_1(emergency);
        System.out.println(Arrays.toString(result));

        result = new MakeOrder().solution_2(emergency);
        System.out.println(Arrays.toString(result));

        br.close();
    }

    // 이중 for문 사용
    private int[] solution_1(int[] emergency){
        int[] answer = new int[emergency.length];
        int[] tempArr;
        int num = 1;
        tempArr = Arrays.stream(emergency).toArray();
        Arrays.sort(tempArr);
        System.out.println(Arrays.toString(tempArr)); // 3 24 76
        System.out.println(Arrays.toString(emergency)); // 3 76 24

        for(int i = tempArr.length-1; i >= 0; i--){
            for(int j = 0; j < emergency.length; j++){
                if(tempArr[i] == emergency[j]){
                    answer[j] = num;
                    num++;
                }
            }
        }
        return answer;
    }

    // HashMap 사용
    private int[] solution_2(int[] emergency){
        int[] answer = new int[emergency.length];
        int[] temp = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for(int i = temp.length-1; i >= 0; i--){
            map.put(temp[i],idx++);
        }
        for(int i=0; i<emergency.length; i++){
            answer[i] = map.get(emergency[i]);
        }
        return answer;
    }

}