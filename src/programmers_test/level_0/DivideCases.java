package programmers_test.level_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class DivideCases { // 프로그래머스 연습문제 구슬을 나누는 경우의 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120840
    // 서로 다른 n개 중 m개를 뽑는 경우의 수 공식
    // n! / (n-m)! x m!


    // 조합 (순열과는 달리 순서에 상관없음)
    // nCr = n-1Cr-1 + n-1Cr
    // 하나의 원소를 선택할 경우 + 하나의 원소를 선택하지 않을 경우
    // 1,2,3 중에서 2개를 뽑는 조합( 3C2 )
    // (1, X) - 1을 뽑는 경우 (1,2),(1,3)   => 2C1
    // (X, X) - 1을 뽑지 않는 경우 (2,3)     => 2C2
    private int solution_1(int balls, int share){
        if( balls == share || share == 0) {
            return 1;
        }else{
            return solution_1(balls-1, share-1) + solution_1(balls-1, share);
        }
    }

    // BigInteger : 문자열 형태로 이루어진 숫자의 범위가 무한한 클래스
    // 무한의 정수가 들어갈 수 있는 경우 사용한다. ( long 보다 큰 범위 수용 가능 )
    // divide 나눗셈
    // multiply 곱셈
    // add 덧셈
    private BigInteger solution_2(int balls, int share){
        return getFactorial(balls).divide(getFactorial(balls-share).multiply(getFactorial(share)));
    }   // 3개 중 2개를 선택하는 거라면 6/(1*2)  // 5개중 3개를 선택하는 거라면 120 / (2*6)
        // 3! / (3-1)! * 2!
    private BigInteger getFactorial(int num){
        BigInteger answer = new BigInteger("1");
        BigInteger from = new BigInteger("1");
        BigInteger to = new BigInteger(String.valueOf(num));

        for(BigInteger i = from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE)){
            answer = answer.multiply(i);
        }   // BigInteger 의 값을 비교할 때 compareTo 를 사용한다.
            // 맞으면 0, 틀리면 -1을 리턴한다.
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int balls = Integer.parseInt(st.nextToken());
        int share = Integer.parseInt(st.nextToken());

        int result = new DivideCases().solution_1(balls, share);
        System.out.println(result);

        System.out.println(new DivideCases().solution_2(balls, share));

        br.close();
    }
}
