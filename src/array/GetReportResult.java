package src.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.HashMap;


public class GetReportResult {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k= 2;
        //result ={2,1,1,0};

        int[] result = solution(id_list, report, k);

        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        // 결과값 길이 초기화
        int[] answer = new int[id_list.length];
        //아이디리스트 순서
        LinkedHashMap<String,Integer> idMap = new LinkedHashMap<>();
        //아이디별 신고자
        HashMap<String,HashSet<String>> resultMap = new HashMap<>();

        //중복 신고 삭제
        HashSet<String> dupExcReport = new HashSet<>(Arrays.asList(report));

        for(int i =0;i < id_list.length;i++){
            //아이디리스트 순서로 입력
            idMap.put(id_list[i],i);
            resultMap.put(id_list[i],new HashSet<>());
        }

        //아이디 리스트별 신고자 정렬
        for(String a: dupExcReport){
            resultMap.get(a.split(" ")[1]).add(a.split(" ")[0]);
        }

        for(int i=0; i< resultMap.size(); i++){
            if(resultMap.get(id_list[i]).size() >= k){
                for(String s: resultMap.get(id_list[i])){
                    answer[idMap.get(s)]++;
                }
            }

        }

        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        LinkedHashMap<String,Integer> idMap = new LinkedHashMap<>();
        HashMap<String,HashSet<String>> resultMap = new HashMap<>();

        //신고 중복 제거
        HashSet<String> a = new HashSet<>(Arrays.asList(report));
        String[] dReport = a.toArray(new String[0]);

        for(int i=0;i<id_list.length;i++){
            idMap.put(id_list[i],i);
            resultMap.put(id_list[i], new HashSet<String>());
        }

        for(String s:dReport){
            String[] str = s.split(" ");
            resultMap.get(str[1]).add(str[0]);
        }

        for(int i=0; i<id_list.length;i++){
            if(resultMap.get(id_list[i]).size() >= k){
                for(String s: resultMap.get(id_list[i])){
                    answer[idMap.get(s)]++;
                }
            }
        }

        return answer;
    }

}
