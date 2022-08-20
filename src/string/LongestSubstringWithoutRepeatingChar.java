package src.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        String pl  = "abcabcd";

        //LongestSubstringWithoutRepeatingChar a = new LongestSubstringWithoutRepeatingChar();
        //int result = a.lengthOfLongestSubstring(pl);
        int result = lengthOfLongestSubstring(pl);
        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s){

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) >= start)
                    start = map.get(c)+1;
            }

            end = Math.max(end, i-start+1);
            map.put(c,i);
        }

        return end;


    }


}
