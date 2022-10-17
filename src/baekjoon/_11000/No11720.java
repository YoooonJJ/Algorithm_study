package baekjoon._11000;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11720 { // 백준 숫자의 합
    // https://www.acmicpc.net/problem/11720
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");

        bw.write(String.valueOf(new No11720().solution_1(str)));
        bw.write("\n");

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String strNum = st.nextToken();

        bw.write(String.valueOf(new No11720().solution_2(n, strNum)));
        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }
    // Arrays.stream 사용
    private int solution_1(String[] str){
        int[] temp = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(temp).sum();
    }

    // String.charAt 사용
    private int solution_2(int n, String strNum){
        int sum = 0;
        for(int i=0; i<n; i++){
            char ch = strNum.charAt(i);
            sum += ch -'0';
            System.out.println(ch + " 의 아스키코드 값 : " + (int)ch); // ch : 49
            System.out.println("sum = " + sum); // sum = 1
        }
        return sum;
    }
    // 반복문으로 문자열의 문자마다 아스키 코드 값을 구한다
    // 0 부터 9 까지 아스키 코드 값은 48 ~ 57
    // ch -'0' 은 ch 의 아스키 코드 값에서 48 을 뺀 값이므로
    // '2' 의 경우, 50 - 48 로 2가 나온다.

    // sum += Integer.parseInt(strNum.charAt(i)+"");
    //   -> 41,42 line 과 동일함.



}
