class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
       int value=k;
       int i=0;
       while(i<nums.length){
        if(nums[i]<value){
            i++;
        }else if(nums[i]==value){
            value+=k;
            i++;
        }else{
            return value;
        }
       }
       return value;
    }
}