class Solution {
    public int longestSubsequence(int[] nums) {
    int n=nums.length;
    int xor=0;
    for(int i=0;i<n;i++){
        xor=xor^nums[i];
    }
    if(xor!=0){
        return n;
    }
      for(int i=0;i<n;i++){
        if(nums[i]!=0){
            return n-1;
        }
      }
    return 0;
    }
}