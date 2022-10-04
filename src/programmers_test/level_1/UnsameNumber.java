package programmers_test.level_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnsameNumber {// 프로그래머스 연습문제 같은 숫자는 싫어
    //https://school.programmers.co.kr/learn/courses/30/lessons/12906
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int[] arr = Stream.of(str).mapToInt(Integer ::parseInt).toArray();

        int[] result = new UnsameNumber().solution_1(arr);
        bw.write(Arrays.toString(result));
        bw.write("\n");

        result = new UnsameNumber().solution_2(arr);
        bw.write(Arrays.toString(result));
        bw.write("\n");

        result = new UnsameNumber().solution_3(arr);
        bw.write(Arrays.toString(result));
        bw.write("\n");

        result = new UnsameNumber().solution_4(arr);
        bw.write(Arrays.toString(result));
        bw.write("\n");

        result = new UnsameNumber().solution_5(arr);
        bw.write(Arrays.toString(result));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
    private int[] solution_1(int[] arr){

        // answer = Arrays.stream(arr).distinct().toArray();
        // -> 마지막으로 들어오 숫자가 처음의 숫자와 중복되는 경우 제거됨.

        //List<Integer> arrToList = Arrays.asList(arr);
        // int 배열의 경우 Arrays.asList()를 사용할 수 없다.
        // Arrays.asList() 를 사용하게 된다면 List<Integer> 가 아닌 List<int[]> 형태임.
        // int (primitive 타입) 가 Integer 로 형변환 되지 않는다.

        // 반복문 사용하기
        List<Integer> list_1 = new ArrayList<>();
        for(int element : arr){
            list_1.add(element);
        }
        // Stream 사용하기
        List<Integer> list_2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // boxed() 메소드는 primitive stream 값들을 wrapper class로 바꿔준다.
        // 그 다음 collect(Collectors.toList()) 로 stream 을 List 로 변경할 수 있다.
        // int 뿐만 아니라 double, long 도 사용 가능.

        for(int i=0; i<list_1.size(); i++){
            if(i+1 < list_1.size()) {
                if (list_1.get(i).equals(list_1.get(i + 1))) {
                    list_1.remove(i);
                    i--;
                }
            }
        }

        int[] answer = new int[list_1.size()];
        for(int j=0; j<list_1.size(); j++){
            answer[j] = list_1.get(j);
        }

        return answer;
    }
    // 이 방법은 테스트 예제에 대한 해결은 가능하지만,
    // 배열의 크기가 길어질수록 remove 연산 후 작업에 리소스가 낭비된다는 단점이 있다.

    // remove 를 사용하지 않고 해봤을 때
    private int[] solution_2(int[] arr){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(i == 0){ // 배열 arr 의 0번째 인덱스 값은 무조건 넣게 되므로 반복문 밖으로 빼는것이 효율적임.
                list.add(arr[i]);
            }else if( i+1 < arr.length){
                if(arr[i] != arr[i-1]){
                    list.add(arr[i]);
                }
            }else{
                if(list.size() > 1){ // arr 의 마지막 인덱스는 list 의 마지막 값과 비교
                    if(!list.get(list.size()-1).equals(arr[i])){
                        // 리스트의 마지막 인자를 받는 getLast() 메소드도 있다.
                        list.add(arr[i]);
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        return answer;
    }

    // 배열 arr 의 원소의 크기는 0 보다 크거나 같고 9보다 작거나 같은 정수임을 활용하는 방법
    private int[] solution_3(int[] arr){
        // 배열 arr 에는 10이라는 값이 존재할 수 없다.
        int tempNum = 10;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : arr){
            if(tempNum != num){
                list.add(num);
            }
            tempNum = num; // 이전에 list 에 넣은 수와 다음 수가 같으면 list 에 넣을 수 없게 된다.
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // solution_2() 를 간소화 한 방식
    private int[] solution_4(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]); // 배열 arr 의 0번째 값은 무조건 넣는다.

        for(int i=1; i<arr.length; i++){ // 0 번째는 이미 넣었으니 그 다음부터 반복하면 된다.
            if(arr[i] != arr[i-1]){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for(int j=0; j<answer.length; j++){
            answer[j] = list.get(j);
        }
        return answer;
    }

    // ArrayList 대신 LinkedList 를 활용하는 방법
    private int[] solution_5(int[] arr){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(arr[0]);
        for(int e : arr){
            if(e != list.getLast()){ // list 의 마지막 값을 가져와서 비교
                list.add(e);
            }
        }
        // Integer -> int 로 변경하기
        Integer[] temp = list.toArray(new Integer[list.size()]);

        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }
    // LinkedList 는 인덱스가 없기 때문에 중간 요소를 삭제하더라도 전체의 인덱스에 변화가 없음.
    // 노드라는 것이 데이터와 포인터를 가지고 한줄로 연결되어있는 형태.
    // 데이터를 담은 노드들이 연결되어 있고, 노드의 포인터가 앞 뒤 노드와의 연결을 담당함.
    // 중간 노드가 삭제 되면 앞 뒤 노드의 연결만 변경되기 때문에 데이터의 추가나 삭제가 용이함.
    // 대신 인덱스가 없어 탐색이나 정렬에는 비효율적임.





}
