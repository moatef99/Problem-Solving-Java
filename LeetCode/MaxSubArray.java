package LeetCode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int [] sums = new int[nums.length];
        sums[0] = nums[0];
        int sum = nums[0];
        for(int index = 1; index < nums.length; index++){
            sums[index] = sum + nums[index];
            sum = sums[index];
        }

        int maxSubArraySum = nums[0];
        for(int numsIndex = 1; numsIndex <nums.length; numsIndex++){
            maxSubArraySum = Math.max(maxSubArraySum, sums[numsIndex]);
            for(int current = 1; current <= numsIndex; current++){
                int currentSubArraySum = sums[numsIndex] - sums[current-1];
                maxSubArraySum = Math.max(maxSubArraySum,currentSubArraySum);
            }
        }

        return maxSubArraySum;
    }

    public static void main(String[] args) {
        MaxSubArray mas = new MaxSubArray();
    }
}
