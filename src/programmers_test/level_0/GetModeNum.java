package programmers_test.level_0;

import java.io.*;
import java.util.*;



public class GetModeNum { // 프로그래머스 연습문제 최빈값 구하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120812
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int[] array = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int result = new GetModeNum().solution_1(array);
        bw.write(String.valueOf(result));

        bw.write("\n");
        result = new GetModeNum().solution_2(array);
        bw.write(String.valueOf(result));

        bw.write("\n");
        result = new GetModeNum().solution_3(array);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
    // HashMap 과 LinkedList 활용
    private int solution_1(int[] array){
        int answer;
        if(array.length == 1){ // 배열 array의 길이가 1이면 최빈값 계산을 할 필요가 없음.
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(array[0],1); // 배열의 길이는 최소 1 이상이므로 첫번째 값은 바로 넣는다.

        for(int i=1; i<array.length; i++){
            if(map.containsKey(array[i])){ // map 에 key가 이미 있는 경우
                int temp = map.get(array[i])+1; // map 의 해당 key value+=;
                map.replace(array[i], temp);
            }else{
                map.put(array[i], 1);
            }
        }
        List<Map .Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        // HashMap 형태의 데이터 전체를 LinkedList 에 담는다.
        // map.entrySet() 의 형태 ex) [1=1, 2=1, 3=3, 4=1]

        // LinkedList 의 노드들을 정렬하기 위해 비교하는데
        // 객체를 정렬하는 기준을 만들 수 있는 두 방법(Comparable, Comparator) 중
        // Comparator 사용했다.
        // Comparator 객체는 메소드가 하나뿐인 인터페이스를 구현하므로 람다식으로 작성가능.

        // list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        // 위처럼 작성 가능하나 좀더 풀어서 작성.
        list.sort((e1, e2) -> Objects.equals(e1.getValue(), e2.getValue())
                ? e1.getKey() - e2.getKey()
                : e2.getValue() - e1.getValue());
        // 음수 리턴 : e1 보다 e2가 더 크다고 판별해서 정렬을 유지.
        // 양수 리턴 : e1이 e2보다 더 크다고 판별해서 e1 과 e2의 순서가 교체된다.
        // 결과적으로 getValue 값이 큰 객체가 앞으로 오게 됨.

        // sort 후 출력 해보면 [3=3, 1=1, 2=1, 4=1] 으로 출력된다.
        System.out.println(Arrays.toString(list.toArray()));

        // 최빈값이 여러개일 경우 -1을 반환한다.
        answer = Objects.equals(list.get(0).getValue(), list.get(1).getValue()) ?
                -1 : list.get(0).getKey();

        return answer;
    }

    // HashMap.forEach() 활용
    private int solution_2(int[] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int value : array){
            map.putIfAbsent(value, 0); // map 에 먼저 value 가 없으면 value=0 을 넣는다.
            map.put(value, map.get(value)+1); // 그다음엔 value 가 있으므로 value=1
        }
        System.out.println(map.entrySet());

        List<Integer> modeList = new ArrayList<>();

        int mode = Collections.max(map.values()); // map 의 값들 중에서 가장 큰 값을 넣는다.
        // max(map.values()); 로 작성하려면 import static java.util.Collections.*; 를 해야 함.

        // map을 반복문으로 접근해서 mode 값과 동일한 값을 가진 Key 를 modeList 에 넣는다.
        map.forEach((key, value) -> {
            if(value == mode) modeList.add(key);
        });

        if(modeList.size() > 1){ // 1보다 클 경우 최빈값이 여러개.
            return -1;
        }
        return modeList.get(0);
    }

    // 배열과 반복문 사용
    private int solution_3(int[] array){
        int mode = array[0]; // 최빈값을 가질 객체
        int cnt = 1; // mode 횟수
        int equalCnt = 0; // 최빈값이 여러개인지 판별하기 위한 객체

        Arrays.sort(array); // 배열 오름차순 정렬
        System.out.println(Arrays.toString(array));
        for(int i = 1; i < array.length; i++){
            if(array[i] == array[i-1]){ // 배열 array 두개의 인덱스 값이 동일할 경우
                cnt++; // 최빈값 빈도수 증가
                if(cnt > equalCnt){
                    equalCnt = cnt;
                    mode = array[i];
                }else if(cnt == equalCnt){ // 최빈값의 빈도수와
                    mode = -1;
                }
            }else{
                cnt = 1;
            }
        }
        return mode;
    }
}
