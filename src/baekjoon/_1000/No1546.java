package baekjoon._1000;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1546 { // 백준 평균
    // https://www.acmicpc.net/problem/1546
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 과목 개수
        int n = Integer.parseInt(br.readLine());
        // 과목 점수
        int[] score = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println("원래 점수 : "+Arrays.toString(score));

        bw.write(String.valueOf(new No1546().fakeAvg(new No1546().fakeScore(n, score))));

        bw.flush();
        bw.close();
        br.close();

    }
    private double[] fakeScore(int n, int[] score){
        double[] fScore = new double[n];
        Arrays.sort(score);
//        System.out.println("score 정렬 : "+ Arrays.toString(score));
        double m = score[n-1]; // 가장 높은 점수
        fScore[n-1] = 1.0*100;  // m/m*100; 과 동일하다
        for(int i=0; i<n-1; i++){
            fScore[i] =  (score[i] / m) * 100;
        }

        return fScore;
    }
    private double fakeAvg(double[] fScore){
        double temp = 0.0;
        for(double d : fScore){
            temp += d;
        }
        temp = temp / fScore.length;
        return temp;
    }

}
