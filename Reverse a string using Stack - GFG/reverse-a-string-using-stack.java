// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}
// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        //code here
        Stack<Character> stack = new Stack<>();
        
        int len = S.length();
        
        //first push all the characters of the string in the stack
        for(int i = 0;i < len;i++){
            stack.push(S.charAt(i));
        }
        
        String result = "";
        //pop all the elements in the stack and concatenate them in string
        //Since a stack follows the LIFO principle, the last character of the string will
        //pop out first and will be added to the result string
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        
        return result;
    }

}