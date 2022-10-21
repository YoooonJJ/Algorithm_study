package baekjoon._4000;

import java.io.*;
import java.util.Arrays;

public class No4344 {  // 백준 평균은 넘겠지
    // https://www.acmicpc.net/problem/4344
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        String[] result = new String[c];
        String[] str;
        int total;
        double avg;

        for(int i=0; i<result.length; i++){
            str = br.readLine().split(" ");
            int[] temp = new int[Integer.parseInt(str[0])];
            for(int k=1; k < str.length; k++){
                temp[k-1] = Integer.parseInt(str[k]);
            }
            total = Arrays.stream(temp).sum();
            avg = (double)total / temp.length;
            int cnt = 0;
            for(double j : temp){
                if(j > avg) cnt++;
            }
            double per = ((double)cnt / (double)temp.length)*100.0;
            result[i] = String.format("%.3f", per);
        }
        for(String j : result) System.out.println(j+"%");
        br.close();
    }

}
