class Solution {
    public int[] sumZero(int n) {
        
        int[] res = new int[n];
        
        int index = 0;
        int val = 1;
        
        if(n%2 == 1){
            n--;
            index = 1;
        }
        
        
        while(n > 0){
            res[index++] = val;
            res[index++] = val * -1;
            val++;
            n -= 2;
        }
        
        return res;
    }
}