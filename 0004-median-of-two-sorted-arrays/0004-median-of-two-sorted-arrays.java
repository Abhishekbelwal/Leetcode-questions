class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int[] arr=new int[n];
        int k=0;
        for(int num:nums1){
            arr[k++]=num;

        }
        for(int num:nums2){
            arr[k++]=num;
            
        }
        Arrays.sort(arr);

        if(n%2!=0){
            return arr[n/2];
        }
        return (arr[n/2]+arr[n/2-1])/2.0;
    }
}