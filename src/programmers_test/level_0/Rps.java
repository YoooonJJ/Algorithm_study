package programmers_test.level_0;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Rps { // 프로그래머스 연습문제 가위바위보
    // https://school.programmers.co.kr/learn/courses/30/lessons/120839
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rsp = br.readLine();
        String result = new Rps().solution(rsp);

        bw.write(result);
        bw.write("\n");

        result = new Rps().solution_2(rsp);
        bw.write(result);
        bw.write("\n");

        result = new Rps().solution_3(rsp);
        bw.write(result);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();

    }
    // 가위 : 2 , 바위 : 0 , 보 : 5
    private String solution(String rsp){
        StringBuilder answer = new StringBuilder();
        String[] input = rsp.split("");
        for(String s : input){
            switch(s){
                case "0":
                    answer.append("5");
                    break;
                case "2":
                    answer.append("0");
                    break;
                case "5":
                    answer.append("2");
                    break;
            }
        }
        return answer.toString();
    }

    // Stream 사용
    private String solution_2(String rsp){
        return Arrays.stream(rsp.split("")).map(s -> s.equals("2") ? "0" : s.equals("0")? "5" : "2").collect(Collectors.joining());
    }
    // Arrays.stream 을 사용하여 배열로 각각 매핑한 다음 해당 값들을 모아서 반환
    // Collection 을 사용했기 때문에 Collectors.joining()
    // String 이라면 String.joining()


    // replace 사용
    private String solution_3(String rsp){
        rsp = rsp.replaceAll("2", "1")
                .replaceAll("5", "2")
                .replaceAll("0","5")
                .replaceAll("1", "0");
        return rsp;
    }
}
