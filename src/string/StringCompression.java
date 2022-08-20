package src.string;

import java.util.Arrays;

public class StringCompression {

    public static void main(String[] args) {

        String s = "zabcabc";
        //3a3bc-> 5

        int reult = stringZip(s);

        System.out.println(reult);

    }

    public static int stringZip(String s){

        //문자열길이로 초기화
        int answer = s.length();

        for(int i=1; i<s.length() / 2;i++){

            //비교문자
            String preTxt = s.substring(0,i);
            //압축기준수
            int zipCount = 1;
            //압축결과
            StringBuilder resultTxt = new StringBuilder();

            for(int j=i; j<=s.length(); j+=i){

                String next = s.substring(j, j+i >s.length() ? s.length() : j+i);

                if(preTxt.equals(next)){
                    zipCount++;
                }else{

                    resultTxt.append((zipCount !=1? zipCount:"")+ preTxt);
                    //전환
                    preTxt = next;
                    //초기화
                    zipCount = 1;

                }
            }

            resultTxt.append(preTxt);
            System.out.println(resultTxt);
            answer = Math.min(answer, resultTxt.length());
        }


        return answer;
    }

}
