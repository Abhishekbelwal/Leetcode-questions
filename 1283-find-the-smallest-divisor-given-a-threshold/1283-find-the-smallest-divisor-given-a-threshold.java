class Solution {
    public int smallestDivisor(int[] piles, int h) {
        int start=1;
        int end=0;
        for(int pile:piles){
            end=Math.max(end,pile);
        }
        int ans=end;
        while(start<=end){
            int mid=start+(end-start)/2;
            long hours=0;
            for(int pile:piles){
                hours=hours+(pile+mid-1)/mid;
            }
            if(hours<=h){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}