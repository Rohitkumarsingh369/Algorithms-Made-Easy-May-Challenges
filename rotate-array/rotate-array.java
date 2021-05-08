class Solution {
    public void rotate(int[] nums, int k) {
    int n = nums.length;
        k%=n;
		if(n!=1){
			reverse(nums,0,n-1);
			reverse(nums,k,n-1);
			reverse(nums,0,k-1);
        }
    }
	
    public void reverse(int[] nums,int left,int right) {
		while(left<right) {
			int temp=nums[left];
			nums[left]=nums[right];
			nums[right]=temp;
			left++;
			right--;
		}
	}
    
}