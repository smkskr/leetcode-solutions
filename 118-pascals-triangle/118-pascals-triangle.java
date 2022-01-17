class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList(Arrays.asList(1)));
        
        for(int i = 1; i < numRows;i++){
            
            List<Integer> currList = new ArrayList<>();
            
            List<Integer> prevList = result.get(i - 1);
            int prevListLength =prevList.size();
            
            currList.add(1);
            
            for(int j = 1;j < prevListLength;j++){
                currList.add(prevList.get(j - 1) + prevList.get(j));
            }
            
            currList.add(1);
            result.add(currList);
            
        }
        
        return result;
    }
}