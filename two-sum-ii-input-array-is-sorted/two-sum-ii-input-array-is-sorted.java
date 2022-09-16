class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer,Integer> indexMap = new HashMap<>();
        int[] indices = new int[2];
        for(int index = 0;index < numbers.length;index++){
            if(indexMap.containsKey(target - numbers[index])){
                indices[0] = indexMap.get(target - numbers[index]) + 1;
                indices[1] = index + 1;
                break;
            }
            indexMap.put(numbers[index], index);
        }
        
        return indices;
    }
}