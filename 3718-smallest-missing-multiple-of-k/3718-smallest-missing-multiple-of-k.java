class Solution {
    public int missingMultiple(int[] nums, int k) {
       int value=k;
       while(true){
        boolean found=false;
        for(int num:nums){
            if(num==value){
                found=true;
                break;
            }
           
        }
         if(!found){
                return value;
            }
        value+=k;
       }
    }
}