import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

      for(int i=0;i<n;i++){
        if(i>0 && arr[i]==arr[i-1]) continue;

        for(int j=i+1;j<n;j++){
            if(j>i+1 && arr[j]==arr[j-1]) continue;

            int left=j+1;
            int right=n-1;
            while(left<right){
                long sum=(long)arr[i]+arr[j]+arr[left]+arr[right];
                if(sum>target){
                    
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    ans.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[left]==arr[left-1]) left++;
                    while(left<right && arr[right]==arr[right+1]) right--;
                    
                }
            }
        }
      }
        return ans;
    }
}