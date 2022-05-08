class Solution {
    public int largestAltitude(int[] gain) {
        
        int maxAltitude = gain[0];
        for(int i = 1;i < gain.length;i++){
            gain[i] += gain[i-1];
            maxAltitude = Math.max(gain[i],maxAltitude);
        }
        
        return maxAltitude < 0 ? 0 : maxAltitude;
    }
    
   

}