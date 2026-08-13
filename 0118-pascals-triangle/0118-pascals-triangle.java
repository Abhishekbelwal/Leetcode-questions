class Solution {

    public List<Integer> rows(int n){
        List<Integer> row=new ArrayList<>();
        row.add(1);
        int ans=1;
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            row.add(ans);
        }
        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll=new ArrayList<>();
        for(int j=1;j<=numRows;j++){
            ll.add(rows(j));
        }
        return ll;
    }
}