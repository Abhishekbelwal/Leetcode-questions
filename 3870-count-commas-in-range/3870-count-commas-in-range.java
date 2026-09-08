class Solution {
    public int countCommas(int n) {
        int m=999;
        int ans;
        if(n>m){
            ans=n-m;
        }else{
            return 0;
        }
        return ans;
    }
}