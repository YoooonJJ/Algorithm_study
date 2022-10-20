package programmers_test.level_0;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PairOfNumber { // 프로그래머스 연습문제 순서쌍의 개수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120836
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = new PairOfNumber().solution_1(n);

        bw.write(String.valueOf(result));
        bw.write("\n");

        result = new PairOfNumber().solution_2(n);
        bw.write(String.valueOf(result));
        bw.write("\n");

        result = new PairOfNumber().solution_3(n);
        bw.write(String.valueOf(result));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    // Collection 을 사용하지 않아도 n%i == 0 일때 answer++ 으로 문제 풀이가 된다.
    // HashMap 사용
    private int solution_1(int n){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            if(n % i == 0){
                map.put(i, (n/i));
            }
        }
        return map.size();
    }

    // HashSet 사용 Set 의 forEach 를 사용해봄.
    private int solution_2(int n){
        AtomicInteger answer = new AtomicInteger();
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<= n; i++){
            if(n % i == 0) set.add(i);
        }
        set.forEach(e1 -> {
            set.forEach(e2 -> {
                if (e1 * e2 == n) {
                    answer.getAndIncrement();
                }
            });
        });
        // set 내부에 접근하는 변수 e1은 Integer
        // int answer = 0; 으로 선언했을 경우 answer 를 형변환 해야 접근 가능하다고 나온다.
        // AtomicInteger  :  int 자료형을 가지고 있는 wrapping 클래스
        // 멀티쓰레드 환경에서 동시성을 보장한다고 한다..
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/atomic/AtomicInteger.html
        return answer.get();
    }

    // IntStream 사용
    private int solution_3(int n){
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
    // 1부터 n까지 범위 내에서 n을 나눴을 때 나머지가 0인 정수의 개수를 센다.

}
