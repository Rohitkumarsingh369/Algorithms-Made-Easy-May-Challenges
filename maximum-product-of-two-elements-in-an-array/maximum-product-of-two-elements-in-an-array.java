class Solution {
    public int maxProduct(int[] nums) {
       int max = 0;
        int i=0;
        int j=nums.length-1;

        while (i<j){

            if (max < (nums[i]-1) * (nums[j]-1)){
                max = (nums[i]-1) * (nums[j]-1);
            }

           else if (nums[j] <= nums[i]) {
                j--;
            }else {
                i++;
            }
        }
        return max;
    }
}