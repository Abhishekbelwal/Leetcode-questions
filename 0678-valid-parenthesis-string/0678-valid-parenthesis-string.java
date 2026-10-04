class Solution {
    public boolean checkValidString(String s) {
        int l = 0, h = 0;

        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i)=='('){
            l++;
            h++;
           }else if(s.charAt(i)==')'){
                if(l>0){
                    l--;
                }
                h--;
           }else{
            if(l>0){
                l--;
            }h++;
           }

            if (h < 0) return false;

           
        }

        return l == 0;
    }
}