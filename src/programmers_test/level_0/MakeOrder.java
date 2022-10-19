package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
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

        result = new MakeOrder().solution_3(emergency);
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

    // Collections 사용
    private int[] solution_3(int[] emergency){
        int[] answer = new int[emergency.length];
        Integer[] temp = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        // int 형 배열인 emergency 의 값을 Integer 로 형변환해서 새 배열에 값을 입력
        Arrays.sort(temp, Collections.reverseOrder());
        // Collections.reverseOrder() 에 따라 temp 배열을 정렬한다.
        // 원래 배열의 순서를 역순으로

        for(int i=0; i<emergency.length; i++){
            answer[i] = Arrays.asList(temp).indexOf(emergency[i])+1;
            // 주어진 배열 emergency 에 i 인덱스 값을 가져와서
            // temp 를 stream 을 통해 List 형태로 변환 후 해당 emergency[i] 값이 있는 인덱스 번호를 가져온다.
            // 순서 값은 1부터 시작하므로 0번째 인덱스일때부터 1을 더하면서 연산.
            // i가 2일 때, emergency[2]는 24. 리스트 temp 에서 24값을 가진 인덱스는 1
            // answer[2] 의 값은 2가 된다.
        }
        return answer;
    }
}
