package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseString { // 프로그래머스 연습문제 문자열 뒤집기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120822

    // char 배열 사용 1
    private String solution_1(String my_string){
        String answer = "";
        char[] ch = my_string.toCharArray();
        for(int i = ch.length-1; i >= 0; i--){
            answer += String.valueOf(ch[i]);
        }
        return answer;
    }

    // subString 사용
    private String solution_2(String my_string){
        String answer = "";
        for(int i=my_string.length()-1; i>=0; i-- ){
            answer += my_string.substring(i,i+1);
        }
        return answer;
    }

    // StringBuffer reverse 사용
    private String solution_3(String my_string){
       return new StringBuffer(my_string).reverse().toString();
    }
    // toString() 을 하지 않으면 return type 이 StringBuffer 가 되어
    // main 에서 result = String.valueOf(리턴값); 을 써야 한다.

    // char 배열 사용 2 (swap)
    private String solution_4(String my_string){
        String answer = "";
        char[] chars = my_string.toCharArray();
        for(int i=0; i<chars.length/2; i++){
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        answer += String.valueOf(chars);
        return answer;
    }
    // 입력받은 문자열의 길이의 절반만큼만 반복하면서
    // 맨 처음과 맨 끝 글자부터 서로 바뀌는 형태.

    // char 배열을 String 형태로 변환하고자 할때
    // String answer = Arrays.toString(chars); 는 출력시 배열형태 그대로 출력된다.
    // 대신 String.valueOf(chars)를 사용하게 되면 문자 배열의 문자를 포함하는 문자열이 된다.

    // String.valueOf() 는 String.copyValueOf() 와 출력결과는 동일하다.
    // valueOf(char[] data) 는 char 배열 인수의 문자열 표현을 리턴
    // copyValueOf(char[] data) 는 지정된 문자배열과 동일한 문자열을 리턴
    // 현재 java api 에서는 성능도 구현도 동일하다고 나와있다.

    // String.valueOf()
    //테스트 1 〉	통과 (1.65ms, 73.1MB)
    //테스트 2 〉	통과 (1.50ms, 77.2MB)
    //테스트 3 〉	통과 (1.29ms, 71.1MB)
    //테스트 4 〉	통과 (1.23ms, 75.1MB)
    //테스트 5 〉	통과 (1.13ms, 76.6MB)

    // String.copyValueOf()
    //테스트 1 〉	통과 (1.32ms, 82.7MB)
    //테스트 2 〉	통과 (1.33ms, 76.2MB)
    //테스트 3 〉	통과 (1.18ms, 77.1MB)
    //테스트 4 〉	통과 (1.63ms, 72.8MB)
    //테스트 5 〉	통과 (1.25ms, 75.2MB)






    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String my_string = br.readLine();

        String result = new ReverseString().solution_1(my_string);
        sb.append(result).append("\n");

        result = new ReverseString().solution_2(my_string);
        sb.append(result).append("\n");

        result = new ReverseString().solution_3(my_string);
        sb.append(result).append("\n");

        result = new ReverseString().solution_4(my_string);
        sb.append(result).append("\n");


        System.out.println(sb);
        br.close();
    }

}
