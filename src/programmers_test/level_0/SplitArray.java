package programmers_test.level_0;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitArray { // 프로그래머스 연습문제 배열 자르기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120833

    //  반복문 사용
    private int[] solution_1(int[] numbers, int num1, int num2){
        int[] answer = {};
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int i = num1; i<=num2; i++){
            tempList.add(numbers[i]);
        }
        Integer[] tempArr = tempList.toArray(new Integer[0]);
        answer = Arrays.stream(tempArr).mapToInt(Integer::intValue).toArray();
        return answer;
    }

    // Arrays 클래스의 copyOfRange() 를 활용하는 방법
    private int[] solution_2(int[] numbers, int num1, int num2){
        return Arrays.copyOfRange(numbers, num1, num2);
    }
    // copyOfRange(int[] original, int from, int to)
    // original 배열을 from 인덱스 부터 to 인덱스 까지 범위를 지정해서 복사한다.


    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5};
        int num1 = 1;
        int num2 = 2;
        int[] result = new SplitArray().solution_1(numbers, num1, num2);
        System.out.println(Arrays.toString(result)); // [2, 3]

        numbers = new int[]{1, 3, 5, 7, 9};
        num1 = 2;
        num2 = 4;
        result = new SplitArray().solution_2(numbers, num1, num2);
        System.out.println(Arrays.toString(result)); // [5, 7]


    }
}
