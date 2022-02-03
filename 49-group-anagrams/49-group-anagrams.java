class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        int len = strs.length;
        if(len == 0)return new ArrayList<>(anagramMap.values());
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(anagramMap.containsKey(key)){
                List<String> currList = anagramMap.get(key);
                currList.add(str);
                anagramMap.put(key, currList);
            }else{
                List<String> currList = new ArrayList<>();
                currList.add(str);
                anagramMap.put(key, currList);
            }
        }
        
        return new ArrayList<>(anagramMap.values());
    }
}