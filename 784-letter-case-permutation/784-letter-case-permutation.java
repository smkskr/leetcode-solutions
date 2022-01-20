class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> result = new ArrayList<>();
        solve(s, "", s.length() - 1,result);
        return result;
    }
    
    public void solve(String s, String curr, int index, List<String> result){
        
        if(index == -1){
            result.add(curr);
            return;
        }
        char ch = s.charAt(index);
        if(ch >= '0' && ch <= '9'){
            solve(s, ch + curr, index - 1, result);
        }
        else{
            solve(s, Character.toUpperCase(ch) + curr, index - 1, result);
            solve(s, Character.toLowerCase(ch) + curr, index - 1, result);
        }   
    }
}