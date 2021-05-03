class Solution {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        
        while(left<=right){
            if(nums[left]==target || nums[right]==target)
                return true;
            else if(nums[left]<target){
                while(left<right && nums[left+1]==nums[left])
                    left++;
                
                left++;
            }
            else if(nums[right]>target){
                while(left<right && nums[right-1]==nums[right])
                    right--;
            
                right--;
            }   
            else
                break;
        }
        return false;
    }
}