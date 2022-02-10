class Solution {
    public int findTheWinner(int n, int k) {
        
        List<Integer> friends = new ArrayList<>();
        
        for(int i = 1;i <= n;i++){
            friends.add(i);
        }
        
        return solve(friends, 0, k - 1);
    }
    
    public int solve(List<Integer> friends, int index, int k){
        
        if(friends.size() == 1)return friends.get(0);
        
        index = ( index + k ) % friends.size();
        
        friends.remove(index);
        
        return solve(friends, index, k);
    }
}