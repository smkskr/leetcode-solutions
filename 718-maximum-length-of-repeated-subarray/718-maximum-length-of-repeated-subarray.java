//This problem can be solved by using the same concept as of longest common substring
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        for(int row = 1;row <= len1;row++){
            for(int col = 1;col <= len2;col++){
                
                if(nums1[row - 1] == nums2[col - 1]){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                    maxLen = Math.max(maxLen, dp[row][col]);
                }
            }
        }
        
        return maxLen;
    }
}