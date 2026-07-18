class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        // Arrays.toString(nums);
        if(nums.length==0) return 0;
        int n=nums.length;
        int lastSmall=Integer.MIN_VALUE;
        int cnt=0;
        int longest=1;
        for(int i=0;i<n;i++){
            if(nums[i]-1==lastSmall){
                cnt++;
                lastSmall=nums[i];
            }else if(nums[i]!=lastSmall){
                cnt=1;
                lastSmall=nums[i];
            }
            longest=Math.max(longest,cnt);
        }
        return longest;
    }
}