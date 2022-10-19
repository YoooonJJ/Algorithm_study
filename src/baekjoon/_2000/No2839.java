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
        bw.write(String.valueOf(new No2839().dpSolution(n)));
        bw.flush();
        bw.close();
        br.close();
    }

    // Greedy Algorithm 활용
    private int solution(int n) {
        int answer = 0;
        while (true) {
            if (n % 5 == 0) {
                answer += n / 5;
                break;
            } else {
                n -= 3;
                answer++;
            }
            if (n < 0) {
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


    //     Dynamic Programming 활용 해보기
//     https://www.youtube.com/watch?v=5Lu34WIx2Us 참고
    private int dpSolution(int n) {
        int[] bag = new int[n + 1];
        // 5보다 작은 값들 중 3을 제외하면 정확히 나누어 떨어지지 않으므로 -1을 반환해야 한다.
        bag[1] = -1;
        bag[2] = -1;
        bag[3] = 1;
        if (n >= 4) {
            bag[4] = -1;
        }

        for (int i = 5; i <= n; i++) { // 5부터 n까지 반복 하면서 배열을 채운다.
            System.out.println("i = " + i + " 일 때");
            if (i % 3 == 0 || bag[i - 3] > 0) {
                // 3으로 나누어 떨어지거나 bag[i-3]의 값이 -1,0 이 아닌 경우
                bag[i] = bag[i - 3] + 1;
                // i가 6이라면 bag[6] = bag[3]+1 이므로, 2 가 된다.
            }
            if (i % 5 == 0 || bag[i - 5] > 0) {
                // i가 5의 배수이거나 bag[i-5] 가 -1, 0 이 아닌 경우
                if (bag[i] != 0) { //
                    System.out.println(bag[i] + " " + (bag[i - 5] + 1));
                    bag[i] = Math.min(bag[i], bag[i - 5] + 1);

                } else {
                    bag[i] = bag[i - 5] + 1;
                    // i가 5일 때 bag[0] 의 값은 1이 된다.
                }
            }
            if (bag[i] == 0) {
                bag[i] = -1;
            }
            System.out.println("bag[" + i + "] = " + bag[i]);
        }
        return bag[n];
    }
}