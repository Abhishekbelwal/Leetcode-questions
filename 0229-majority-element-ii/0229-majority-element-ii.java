class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List <Integer> ll=new ArrayList<>();
        int n=nums.length;
        Map <Integer,Integer> map=new HashMap<>();
        int min=n/3+1;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i])==min){
                ll.add(nums[i]);
            }
            // if(ll.size()==2) break;
        }
        return ll;
    }
}