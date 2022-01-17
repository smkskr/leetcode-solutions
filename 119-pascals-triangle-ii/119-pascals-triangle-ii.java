class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        
        List<List<Integer>> mainList = new ArrayList<>();
        mainList.add(new ArrayList<>(Arrays.asList(1)));
        
        if(rowIndex == 0)return mainList.get(rowIndex);
        
        for(int i = 1;i <= rowIndex;i++){
            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = mainList.get(i - 1);
            
            currList.add(1);
            for(int j = 1;j < prevList.size();j++){
                currList.add(prevList.get(j - 1) + prevList.get(j));
            }
            currList.add(1);
            mainList.add(currList);
        }
        
        return mainList.get(rowIndex);
    }
}