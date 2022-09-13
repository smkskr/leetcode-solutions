class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> firstRow = Arrays.asList(1);
        pascalTriangle.add(firstRow);
        
        for(int index = 1;index < numRows;index++){
            
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            List<Integer> previousRow = pascalTriangle.get(index - 1);
            for(int i = 1;i < previousRow.size();i++){
                currentRow.add(previousRow.get(i - 1) + previousRow.get(i));
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
        }
        
        return pascalTriangle;
    }
}