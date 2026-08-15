class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int current =0;
        int ans=0;
        for(int i=0;i<requests.length;i++){
            ans+=Math.abs(current-requests[i]);
            current= requests[i];
        }
        return ans;
    }
}