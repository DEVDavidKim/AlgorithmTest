package src.array;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberString {

    public static void main(String[] args) {

        String s = "one4seveneight";

        int result = solution2(s);
        System.out.println(result);

    }

    public static int solution(String s){
        int answer =0;
        //숫자별 문자열
        ArrayList<String> numString = new ArrayList<>();
        numString.add("zero");
        numString.add("one");
        numString.add("two");
        numString.add("three");
        numString.add("four");
        numString.add("five");
        numString.add("six");
        numString.add("seven");
        numString.add("eight");
        numString.add("nine");

        char[] sArray = s.toCharArray();

        //문자열 자르기 시작 위치
        int sPoint = 0;
        StringBuilder tmpString = new StringBuilder();
        //완성된 숫자리스트
        //ArrayList<Integer> result = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<sArray.length;i++){

            //숫자 판별
            if(48<=sArray[i] && 57>=sArray[i]){
                //숫자인경우 결과 리스트에 삽입
                result.append(Character.getNumericValue(sArray[i]));
                //비교 문자열 초기화
                tmpString = new StringBuilder();
            }else{
                // 숫자가 아닌경우 문자열 비교
                tmpString.append(sArray[i]);
                for(int v=0; v<numString.size(); v++){
                    if(tmpString.toString().equals(numString.get(v))) {
                        result.append(v);
                        tmpString = new StringBuilder();
                    }
                }
            }
        }

        answer = Integer.parseInt(result.toString());

        return answer;
    }

    public static int solution2(String s){

        int len = s.length();
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }


}
