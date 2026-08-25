class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet <Integer> hs= new HashSet<>();
        for(int num:nums){
            hs.add(num);
        } 
        int value=k;
        while(hs.contains(value)){
            value+=k;
        }
        return value;
    }
}