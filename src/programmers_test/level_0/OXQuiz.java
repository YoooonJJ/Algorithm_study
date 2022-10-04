package programmers_test.level_0;

import java.io.*;
import java.util.Arrays;

public class OXQuiz { // 프로그래머스 연습문제 OX퀴즈
    // https://school.programmers.co.kr/learn/courses/30/lessons/120907
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] quiz = br.readLine().split(",");

        String[] result = new OXQuiz().solution(quiz);
        bw.write(Arrays.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
    private String[] solution(String[] quiz){
        String[] answer = new String[quiz.length];
        String x = "X";
        String o = "O";
        String[] temp;
        int a,b,c;
        for(int i=0; i< quiz.length; i++){
            temp = quiz[i].split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[2]);
            c = Integer.parseInt(temp[4]);
            if(temp[1].equals("+")){
                answer[i] = c==a+b ? o : x;
            }else{
                answer[i] = c==a-b ? o : x;
            }
        }
        return answer;
    }
}
