class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        if(n<5){
            return false;
        }
        while(n>5){
            int sum=0;
            while(n>0){
                int digit=n%10;
                sum+=digit*digit;
                n/=10;
            }if(sum==1){
                return true;
            }
            n=sum;
        }
        return false;
    }
}