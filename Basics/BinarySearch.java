package Basics;

public class BinarySearch {
    public static Integer getIndexBinarySearch(int [] nums, int number){
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = (end + start)/2;
            if(nums[mid] == number){
                return mid;
            }
            else if(nums[mid] > number){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {2, 4, 6, 8, 10, 12, 14};
        System.out.println(getIndexBinarySearch(nums,14));
    }
}
