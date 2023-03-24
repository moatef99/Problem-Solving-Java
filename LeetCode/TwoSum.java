package LeetCode;

import Helpers.ArrayPrintHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int missing = target - nums[i];
            if(numsMap.containsKey(missing)){
                return new int[]{i , numsMap.get(missing)};
            }
            else{
                numsMap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] res= new TwoSum().twoSum(new int[]{2,7,11,15},9);
        new ArrayPrintHelper<Integer>().print(res);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(1);

    }
}
