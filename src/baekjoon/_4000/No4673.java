package baekjoon._4000;

public class No4673 { // 백준 셀프 넘버
    // https://www.acmicpc.net/problem/4673
    public static void main(String[] args){
        // 10000 보다 작거나 같은 셀프 넘버를 구해야 하므로 양의 정수 1부터 반복한다.
        int n = 10000;
        // 1부터 10000 까지의 숫자 중에서 셀프 넘버인 수를 구분하기 위해 배열을 사용한다.
        boolean[] isNotSelf = new boolean[n+1];
        // 숫자 값을 넣지 않고 boolean 타입을 활용한다.
        // boolean 은 default 가 false 이기 때문에
        // 셀프넘버인 정수의 인덱스에 true 값을 넣어주면 된다.
        // 0을 제외하므로 헷갈리지 않게 1을 더해주고 반복문도 1부터 시작한다.

        for(int i = 1; i < n+1; i++){
            int temp = d(i); // 셀프 넘버를 구하는 메소드를 호출 한다.
            // d(i) 메소드를 통해 구한 생성자가 10000 보다 크면 안되므로 조건문을 추가한다.

            if(temp < n+1){ // if 조건문이 참일때 temp 는 생성자다.
                // 1부터 10000 까지의 숫자 중 temp 를 true 로.
                isNotSelf[temp] = true;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int j = 1; j<n+1; j++){
            if(!isNotSelf[j]){
                sb.append(j).append("\n");
            }
        }
        System.out.println(sb);

    }
    public static int d(int num){
        // 인자 num 의 각 자리수 값을 구해 더해야 한다.
        int a = num;
        // d(75) = 75 + 7+ 5 = 87
//        int b = num % 10; // num 이 10보다 작을 수 있으므로 1의 자리를 먼저 구한다.
//        a = a + b; // 75 +5 = 80
        // 주어진 num 의 자릿수를 미리 알 수 없으므로 반복문을 이용해야 한다.
        while(num != 0){
            a += (num%10);
            num /= 10;
            // num 의 1의 자리 값은 a 에 더해졌으므로 10으로 나누고
            // num 이 0 이 될때까지 반복한다.
        }
        return a;
    }
}


