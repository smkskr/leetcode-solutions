class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        //swapping the arrays if the length of first array is greater than length of second array
        if(len1 > len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int start = 0;
        int end = len1;
        
        while(start <= end){
            int part1 = (start + end)/2;
            int part2 = (len1 + len2 +1)/2 - part1;
            
            int maxLeft1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int minRight1 = (part1 == len1) ? Integer.MAX_VALUE : nums1[part1];
            
            int maxLeft2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minRight2 = (part2 == len2) ? Integer.MAX_VALUE : nums2[part2];
            
            
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((len1+len2)%2 == 0)
                    return (double)(Math.max(maxLeft1,maxLeft2) + Math.min(minRight2,minRight1))/2;
                else 
                    return (Math.max(maxLeft1,maxLeft2));
            }
            else if(maxLeft1 > minRight2) end = part1 - 1;
            else start = part1 + 1;
        }
        return -1;
    }
}

/**
NOTE : The length of first array should always be smaller than or equal to the length of second array

we only need to find the maximum element in the left half of the merged array.
For finding the median, it is not necessary to merge both the arrays. All we need is
to find the position of the element.
We know that merged array will consist of elements of both the arrays so we need to partition both the arrays
in such a way that the partitioning would contain the left half of the elements in the hypothetical merged array.


*/