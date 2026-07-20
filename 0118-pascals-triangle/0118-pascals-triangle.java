class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ll = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            if(i==0){
                List<Integer> first = new ArrayList<>();
                first.add(1);
                ll.add(first);
            }
            else if(i==1){
                List<Integer> second = new ArrayList<>();
                second.add(1);
                second.add(1);
                ll.add(second);
            }
            else{
                List<Integer> prev = ll.get(i-1);
                List<Integer> curr = new ArrayList<>();
                curr.add(1);
                for(int j=1;j<prev.size();j++){
                    curr.add(prev.get(j-1) + prev.get(j));
                }
                curr.add(1);
                ll.add(curr);
            }

        }
        return ll;
    }
}