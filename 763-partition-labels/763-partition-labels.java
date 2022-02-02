class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] last = new int[26];
        int len = s.length();
        
        for(int index = 0; index < len;index++){
            char ch = s.charAt(index);
            last[ch - 'a'] = index;
        }
        
        List<Integer> result = new ArrayList<>();
        int j = 0, anchor = 0;
        for(int i = 0; i < len;i++){
            
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if(i == j){
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        
        return result;
    }
}