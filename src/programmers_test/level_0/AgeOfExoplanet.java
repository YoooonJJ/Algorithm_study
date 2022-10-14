package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AgeOfExoplanet { // 프로그래머스 연습문제 외계행성의 나이
    // https://school.programmers.co.kr/learn/courses/30/lessons/120834

    // HashMap 활용
    private String solution_1(int age){
        StringBuilder answer = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        char ch = 'a';
        for(int i=0; i<10; i++){
            map.put(i,ch);
            ch++;
        }
        String[] str = String.valueOf(age).split("");
        int[] temp = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        for(int e : temp){
            answer.append(map.get(e));
        }
        return answer.toString();
    }

    // charAt() 활용
    private String solution_2(int age){
        StringBuilder answer = new StringBuilder();
        String ageToStr = Integer.toString(age);

        for(int i=0; i<ageToStr.length(); i++){
            answer.append((char)(ageToStr.charAt(i) +49));
        }
        return answer.toString();

    }
    // 문자열로 형변환 할때 String.valueOf() 를 주로 사용했는데
    // Integer.toString()도 사용가능했다.
    // 49가 나온 이유 :  숫자 0의 아스키코드 값은 48, 소문자 a 의 아스키코드값은 97 이므로
    //                차이 값인 49를 더해야 0부터 9까지 입력했을 때 a 부터 j 까지의 아스키코드값을 구하게 된다.
    //                아스키 코드 값이 리턴되기 때문에 (ageToStr.charAt(i) +49) 이 부분을
    //                (char) 로 감싸주지 않는다면 아스키코드 값으로 입력된다.
    // 참고 : (int)char 를 출력하면 해당 문자의 아스키코드 값을 알 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(br.readLine());
        String result = new AgeOfExoplanet().solution_1(age);
        System.out.println(result);

        result = new AgeOfExoplanet().solution_2(age);
        System.out.println(result);

        br.close();
    }

}
