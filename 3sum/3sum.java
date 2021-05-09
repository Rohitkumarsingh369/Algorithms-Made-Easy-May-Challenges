class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        
        if(nums==null || nums.length<3)
        {
            return result;
        }
        
        Arrays.sort(nums);
               
        for(int i=0;i<nums.length-1;i++){
            if (i-1 >= 0 && nums[i] == nums[i-1])
                continue;

            int left=i+1;
            int right=nums.length-1;
            
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < right && nums[left] == nums[left+1])
                    left++;
                    while (left < right-1 && nums[right] == nums[right-1])
                        right--;

                    left++;
                    right--;
                    
                }
                else if(nums[i]+nums[left]+nums[right]<0)
                    left++;
                else
                    right--;
            }
            
        }
        return result;
    }
}