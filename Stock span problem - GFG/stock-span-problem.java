// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();//store indexes of prev greater element
        int[] prevGreaterElem = new int[n];
        prevGreaterElem[0] = -1;
        stack.push(n - 1);
        for(int index = n - 2;index >= 0;index--){
            
            while(!stack.isEmpty() && price[index] > price[stack.peek()]){
                prevGreaterElem[stack.pop()] = index;
            }
            stack.push(index);
        }
        
        while(!stack.isEmpty()){
            prevGreaterElem[stack.pop()] = -1; 
        }
        
        for(int index = 0;index < n;index++){
            if(prevGreaterElem[index] == -1)
            {
                prevGreaterElem[index] = index + 1;
            }else{
                prevGreaterElem[index] = index - prevGreaterElem[index];
            }
        }
        
        return prevGreaterElem;
    }
    
}