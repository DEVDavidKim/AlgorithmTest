package src.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] sums = {2,2,8,10,21,25,30};
        int target = 46;

        TwoSum a = new TwoSum();
        //int[] result = a.twoSum1(sums,target);
        int[] result =a.twoSum2(sums, target);

        System.out.println(Arrays.toString(result));

    }

    //map
    private int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int subVal = target - nums[i];
            if(map.containsKey(subVal)) {
                return new int[] {map.get(subVal),i};
            }
            map.put(nums[i],i);
        }

        return  null;


    }

    //brute force
    private int[] twoSum1(int[] nums, int target) {

        for(int i=0; i<nums.length; i++) {

            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }

        }
        return null;
    }

}
