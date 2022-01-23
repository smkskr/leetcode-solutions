class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        solve(1, k, n, result, new ArrayList<>());
        return result;
    }
    
    public void solve(int start, int k, int end, List<List<Integer>> result, List<Integer> temp){
        
        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        
       
        
        for(int i = start;i <= end;i++){
            
            temp.add(i);
            solve(i + 1, k - 1, end, result, temp);
            temp.remove(temp.size() - 1);
           
        }

        
    }
}