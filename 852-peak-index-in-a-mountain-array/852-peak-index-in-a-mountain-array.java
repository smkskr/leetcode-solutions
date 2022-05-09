class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr);
    }
    
    public int binarySearch(int[] arr){
        
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        
        while(low < high){
            
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid + 1]){
               // you are in dec part of array
                // this may be the ans, but look at left
                // this is why high != mid - 1
                high = mid;
            }else{
                //it means you are in the ascending part
                low = mid + 1;// because we know that mid+1 element > mid element
            }
        }
        // in the end, low == high and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return low;//or return high because both of them will point to the single element at the end
        
    }
}