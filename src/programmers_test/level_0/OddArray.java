package programmers_test.level_0;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OddArray { // 프로그래머스 연습문제 짝수는 싫어요
    //https://school.programmers.co.kr/learn/courses/30/lessons/120813
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] result = new OddArray().solution_1(n);
        bw.write(Arrays.toString(result));
        bw.write('\n');

        result = new OddArray().solution_2(n);
        bw.write(Arrays.toString(result));
        bw.write('\n');

        result = new OddArray().solution_3(n);
        bw.write(Arrays.toString(result));
        bw.write('\n');

        bw.flush();
        bw.close();
        br.close();

    }
    private int[] solution_1(int n){
        int[] answer;
        if(n%2 != 0){
            answer = new int[(n/2)+1];
        }else{
            answer = new int[n/2];
        }
        int temp = 0;
        for(int i=1; i <= n; i++){
            if(i%2 != 0){
                answer[temp] = i;
                temp++;
            }
        }
        return answer;
    }
    private int[] solution_2(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%2 != 0){
                list.add(i);
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    // IntStream 사용
    private int[] solution_3(int n){
        return IntStream.rangeClosed(1, n).filter(value -> value%2 == 1).toArray();
    }
    // 반복문 사용시 중간에 break 나 return 되는 상황이 아니므로
    // 1부터 n까지 정해진 범위를 rangeClosed 의 파라미터 값으로 지정하고
    // IntStream 은 지정된 범위 내의 값들을 스트림으로 보내는 것.
    // 단 홀수만 필요하므로 filter 로 조건을 걸고, 반환 형태를 배열로 지정했다.
}
