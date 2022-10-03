package programmers_test.level_1;

import java.io.*;

public class MakeStrangeString { // 프로그래머스 연습문제 이상한 문자 만들기
    // https://school.programmers.co.kr/learn/courses/30/lessons/12930
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String answer = new MakeStrangeString().solution(s);
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
    private String solution(String s){
        StringBuilder answer = new StringBuilder();
        char[] chArr = s.toCharArray();
        char ch;
        int index = 0;
        for(int i = 0; i < chArr.length; i++){
            if(String.valueOf(chArr[i]).equals(" ")){
                answer.append(" ");
                index = 0;
            }else {
                ch = chArr[i];
                if(index % 2 == 0){
                    chArr[i] = Character.toUpperCase(ch);
                }else{
                    chArr[i] = Character.toLowerCase(ch);
                }
                index++;
                answer.append(chArr[i]);
            }
        }
        return answer.toString();
    }
}