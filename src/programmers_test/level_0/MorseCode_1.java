package programmers_test.level_0;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MorseCode_1 { // 프로그래머스 연습문제 모스부호(1)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120838
    private String solution(String[] letter){
        StringBuilder answer = new StringBuilder();
        // a ~ z 에 해당하는 모스부호
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                "--.", "....","..",".---","-.-",".-..","--","-.",
                "---",".--.", "--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        Map<String, String> codes = new HashMap<>();
        char a = 'a';
        for (String s : morse) {
            codes.put(s, String.valueOf(a++));
        }
        for (String str : letter) {
            answer.append(codes.get(str));
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] letter = br.readLine().split(" ");
        String result = new MorseCode_1().solution(letter);

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
