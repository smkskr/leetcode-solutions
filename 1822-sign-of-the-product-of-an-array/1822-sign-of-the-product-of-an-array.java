class Solution {
    public int arraySign(int[] nums) {
        
        int countSign = 0;
        for(int num : nums){
            if(num < 0)countSign++;
            if(num == 0)return 0;
        }
        
        if(countSign%2 == 1)return -1;
        return 1;
    }
}