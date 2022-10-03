package programmers_test.level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class FindKim { // 프로그래머스 연습문제 서울에서 김서방 찾기
    //https://school.programmers.co.kr/learn/courses/30/lessons/12919
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] seoul = br.readLine().split(" ");
        String answer = new FindKim().solution_1(seoul);
        System.out.println(answer);
        answer = new FindKim().solution_2(seoul);
        System.out.println(answer);
        br.close();

    }
    private String solution_1(String[] seoul){
        String answer = "";
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = "김서방은 " + i+ "에 있다";
                break;
            }
        }
        return answer;
    }

    // Arrays 를 사용한다면 아래처럼 작성할 수 있다.
    private String solution_2(String[] seoul){
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + x + "에 있다";
    }
    // 이 방법은 seoul 문자열 배열을 List 형태로 변환해서 indexOf 로 반복한다.
    // 주어진 seoul 을 바로 반복문으로 활용할 수 있음에도
    // 다른 형태로 변환해서 사용하는 방식 메모리 활용에 좋지 않은것 같다.

}
