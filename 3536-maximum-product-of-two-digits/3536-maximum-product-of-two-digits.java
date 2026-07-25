class Solution {
    public int maxProduct(int n) {
        int m1=-1,m2=-1;
        while(n!=0){
            int rem=n%10;
            if(m1<=rem){
                m2=m1;
                m1=rem;
            }else if(m2<rem){
                m2=rem;
            }
            n/=10;
        }
        return m1*m2;
    }
}