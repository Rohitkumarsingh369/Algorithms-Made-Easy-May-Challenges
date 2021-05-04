class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int size=nums.length,prev=0;
        int ans[]=new int[size];
        for(int i=1;i<size;i++){
            ans[i]=ans[i-1]+(nums[i]-nums[i-1])*i;
        }
        
        for(int i=size-2;i>=0;i--){
            prev+=(nums[i+1]-nums[i])*(size-i-1);
            ans[i]+=prev;
        }
        return ans;
    }
}