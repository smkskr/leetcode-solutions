class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int rightM = m - 1;
        int rightN = n - 1;
        int finalRightMN = m + n - 1;
        
        while(rightM >= 0 && rightN >= 0){
            
            if(nums1[rightM] <= nums2[rightN]){
                nums1[finalRightMN--] = nums2[rightN--];
            }else{
                nums1[finalRightMN--] = nums1[rightM--];
            }
        }
        
        while(rightN >= 0){
            nums1[finalRightMN--] = nums2[rightN--];
        }
    }
}