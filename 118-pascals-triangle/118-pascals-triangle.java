class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> first = new ArrayList<>();
        first.add(1);
        
        result.add(first);
        
        for(int row = 1;row < numRows;row++){
            
            List<Integer> prevRow = result.get(row - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int index = 1;index < prevRow.size();index++){
                currentRow.add(prevRow.get(index - 1) + prevRow.get(index));
            }
            currentRow.add(1);
            result.add(currentRow);
            
        }
        
        return result;
    }
}