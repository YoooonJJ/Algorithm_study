package programmers_test.level_0;

import java.io.*;

public class Babbling { // 프로그래머스 연습문제 옹알이
    // https://school.programmers.co.kr/learn/courses/30/lessons/120956
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] babbling = br.readLine().split(" ");
        int answer = new Babbling().solution_1(babbling);
        bw.write(String.valueOf(answer)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
    private int solution_1(String[] babbling){
        int answer_1 = 0;
        String[] str = {"aya", "ye" , "woo" , "ma"};
        for (String s : babbling) {
            int cnt = 0;
            for (String value : str) {
                if(s.contains(value)){
                    if(s.contains(value+""+value)){ // 동일한 단어 연속 불가
                        continue;
                    }
                    s = s.replace(value, "");
                    cnt++;
                }
            }
            if(cnt >= 1){ // 발음 가능한 음절 개수가 1 이상 일때
                if(s.equals("")){ // replace 된 String s 가 빈문자열이 되면
                    answer_1++; // 해당 babbling 배열의 인자는 발음 가능.
                }
            }
        }
        return answer_1;
    }
}
