package src.array;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] sums = {2,8,10,21,25,30};
        int target = 46;

        TwoSum a = new TwoSum();
        int[] result = a.twoSum1(sums,target);

        System.out.println(Arrays.toString(result));

    }

    //brute force
    public int[] twoSum1(int[] nums, int target) {

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
