class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> countMap = new HashMap<>();
       
        for(int index = 0;index < dominoes.length;index++){
            String key;
            if(dominoes[index][0] > dominoes[index][1]){
                key = String.valueOf(dominoes[index][1]) + String.valueOf(dominoes[index][0]);
            }
            else key = String.valueOf(dominoes[index][0]) + String.valueOf(dominoes[index][1]);
            countMap.put(key, countMap.getOrDefault(key,0) + 1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> entry : countMap.entrySet()){
            if(entry.getValue() > 1){
                count += (entry.getValue() * (entry.getValue() - 1))/2;
            }
        }
        
        return count;
    }
}