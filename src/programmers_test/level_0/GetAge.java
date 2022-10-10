package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class GetAge { // 프로그래머스 연습문제 나이 출력
    // https://school.programmers.co.kr/learn/courses/30/lessons/120820
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(br.readLine());
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        System.out.println(year);
        System.out.println(year-age+1);
        br.close();
    }
}
