package programmers_test.level_0;

import java.io.*;

public class ArmyAnt { // 프로그래머스 연습문제 개미 군단
    // https://school.programmers.co.kr/learn/courses/30/lessons/120837
    // 백준 2839번과 유사한 문제  Greedy algorithm 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int hp = Integer.parseInt(br.readLine());
        int result = new ArmyAnt().solution_1(hp);
        bw.write(String.valueOf(result));
        bw.write("\n");

        result = new ArmyAnt().solution_2(hp);
        bw.write(String.valueOf(result));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution_1(int hp){  // 5, 3, 1
        int answer = 0;
        while(true){
            System.out.println("hp : "+ hp);
            if(hp % 5 == 0){
                answer += (hp / 5);
                break;
            }else if( hp >= 3 ){
                hp -= 3;
                answer++;
            }else {
                answer += hp;
                break;
            }
        }
        return answer;
    }
    private int solution_2(int hp){
        return (hp / 5)+((hp % 5)/ 3)+((hp % 5)% 3);
    }
    // hp 를 큰 값부터 나눈 몫을 더하고 나머지를 합한다
}
