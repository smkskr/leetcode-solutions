class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int res = Integer.MAX_VALUE;
        
        if(len == 1)return triangle.get(0).get(0);
        
        for(int index = 1;index < len;index++){
            
            List<Integer> currList = triangle.get(index);
            
            
            List<Integer> prevList = triangle.get(index - 1);
            
            int size = currList.size();
            int prevListSize = prevList.size();
            
            for(int i = 0;i < size;i++){
                 
             
                    
                    int prevListAboveElement = (i == prevListSize) ? Integer.MAX_VALUE : prevList.get(i);
                    int prevListLeftDiagonalElement = (i - 1 == -1) ? Integer.MAX_VALUE : prevList.get(i - 1);
                    
                    
                    currList.set(i, currList.get(i) + Math.min(prevListAboveElement,prevListLeftDiagonalElement));
                
                 if(index == len - 1)//calculate min value of last index
                 res = Math.min(res, currList.get(i));
              
            }
            
           
        }
        
         return res;
    }
}