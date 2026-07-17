class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
       int[] ans=new int[n];
       int p=0,q=1;
       for(int i=0;i<n;i++){
        if(nums[i]<0){
            ans[q]=nums[i];
            q+=2;
        }else{
            ans[p]=nums[i];
            p+=2;
        }
       }
       return ans;
    }
}