class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        // case1 when k is equal to n
        if(k==n){
            int max=0;
            for(int num:nums){
                max=Math.max(max,num);
            }
            return max;
        }
        int[] freq=new int[51];
        for(int num:nums){
            freq[num]++;
        }
        // every element ki khudki subarray or window haii
        if(k==1){
            int ans=-1;
            for(int num:nums){
                if(freq[num]==1){
                    ans=Math.max(ans,num);
                }
            }
            return ans;
        }
        // case 3 if k is  (1<K<n)

        int ans=-1;
        if(freq[nums[0]]==1){
            ans=Math.max(ans,nums[0]);
        }
        if(freq[nums[n-1]]==1){
            ans=Math.max(ans,nums[n-1]);
        }
        return ans;
    }
}