package programmers_test.level_0;

import java.io.*;

public class AlienDictionary { // 프로그래머스 연습문제 외계어 사전
    // https://school.programmers.co.kr/learn/courses/30/lessons/120869
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] spell = br.readLine().split(" ");
        String[] dic = br.readLine().split(" ");
        int result = new AlienDictionary().solution(spell, dic);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    private int solution(String[] spell, String[] dic){
        int answer = 0;
        for (String s : dic) {
            int cnt = 0;
            for (String value : spell) {
                if (s.contains(value)) {
                    cnt++;
                }
            }
            if (cnt == spell.length) {
                answer = 1;
            } else if (answer != 1) {
                answer = 2;
            }
        }
        return answer;
    }
}