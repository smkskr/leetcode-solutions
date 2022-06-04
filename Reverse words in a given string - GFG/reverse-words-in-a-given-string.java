// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here
        Stack<String> stack = new Stack<>();
        int len = S.length();
        String copy = "";
        for(int index = 0;index < len;index++){
            
            char ch = S.charAt(index);
            if(ch != '.'){
                copy += ch;
            }else{
                if(!stack.isEmpty())copy += ".";
                stack.push(copy);
                copy = "";
            }
        }
        
        if(!stack.isEmpty())stack.push(copy + ".");
        else stack.push(copy);
        
        String result = "";
        
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
    }
}