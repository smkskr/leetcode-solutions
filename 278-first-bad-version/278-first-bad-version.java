/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start = 1;
        int end = n;
        int ansIndex = 0;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            boolean badVersion = isBadVersion(mid);
            if(badVersion == true){
                ansIndex = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ansIndex;
    }
    
      
            
}