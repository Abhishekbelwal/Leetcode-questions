class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int totalPushes=0;
        int pushesPer=1;
        for(int i=0;i<n;i++){
            if(i>0 && i%8==0){
                pushesPer++;
            }
            totalPushes+=pushesPer;
        }
        return totalPushes;
    }
}