class Solution {
    public int[] runningSum(int[] nums) {
        
        int length=nums.length;
        
        for(int i=1;i<length;i++){
           nums[i]=nums[i-1]+nums[i];
        }
        
        return nums;
    }
}