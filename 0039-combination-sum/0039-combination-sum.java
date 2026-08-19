class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    void solve(int i,int[] a,int target,List<Integer>list, List<List<Integer>> ans) {
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        } 
        if(i==a.length||target<0)
            return;
        list.add(a[i]);
        solve(i,a,target-a[i],list,ans);

        list.remove(list.size()-1);
        solve(i+1,a,target,list,ans);   
    }
    
}