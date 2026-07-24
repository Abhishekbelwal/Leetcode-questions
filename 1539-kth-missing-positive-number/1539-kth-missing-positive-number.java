class Solution {
    public int findKthPositive(int[] arr, int k) {
       int low=0,high=arr.length-1;

       while(low<=high){
        int mid=low+(high-low)/2;
        int miss=arr[mid]-(mid+1);
        if(miss<k){
            low=mid+1;
        }else{
            high=mid-1;
        }
       }
       return high+1+k;
    }
}