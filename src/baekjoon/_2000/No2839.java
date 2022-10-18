package baekjoon._2000;

import java.io.*;

public class No2839 { // 백준 설탕배달
    // https://www.acmicpc.net/problem/2839
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // n >= 3 && n <= 5000
        bw.write(String.valueOf(new No2839().solution(n)));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
    // Greedy Algorithm 활용
    private int solution(int n){
        int answer = 0;
        while(true){
            if(n%5 == 0){
                answer += n/5;
//                System.out.println(answer);
                break;
            }else{
                n -= 3;
                answer ++;
            }
            if(n < 0){
                answer = -1;
                break;
            }
        }
        return answer;
    }
    // 가장 큰 값을 우선 선택한다.
    // 선택한 값들의 합이 적용시킬 값과 비교해 초과 하는는지 검사한다.
    // (합을 구하려면 연산을 여러번 해야 하므로 배수 유무를 확인했다)
    // 초과하면 가장 마지막에 선택한 값을 삭제하고 이전으로 돌아가 한단계 작은 값을 선택한다.
    // (큰 값인 5의 배수가 아니라면 작은 값인 3을 빼고 다시 반복문 실행)
    // 선택된 값들의 합이 적용시킬 값과 일치하는지 검사.
    // 일치하지 않으면 다시 반복한다.
    // (문제에서 정확히 떨어지지 않으면 -1 값을 출력하라고 지정하여 -1 반환)


}
