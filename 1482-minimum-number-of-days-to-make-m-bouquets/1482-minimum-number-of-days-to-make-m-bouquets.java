class Solution {
    public boolean Possible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int bouqet=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                count++;
                if(count==k){
                    bouqet++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return bouqet>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;
        if (required > bloomDay.length) return -1; 

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for(int bloom:bloomDay){
            minDay=Math.min(minDay,bloom);
            maxDay=Math.max(maxDay,bloom);

        }
        int low=minDay,high=maxDay,result=-1;
        while(low<=high){
            int mid = (low + high) / 2;
            if (Possible(bloomDay, mid, m, k)) {
                result = mid; 
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }

        return result;
        
    }
}