class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List <Integer> ans=new ArrayList<>();
        for(int start=1;start<=8;start++){
            int num=start;
            for(int next=start+1; next<=9;next++){
                num=num*10+next;
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}