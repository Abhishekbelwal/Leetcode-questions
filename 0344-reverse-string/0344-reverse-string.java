class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb=new StringBuilder(new String (s)).reverse();
        for(int i=0;i<s.length;i++){
            s[i]=sb.charAt(i);
        }
    }
}