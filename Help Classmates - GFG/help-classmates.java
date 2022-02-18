// { Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 

// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
         Stack<Integer> stack = new Stack<>();//storing indexes of array element
        int[] result = new int[n];
        stack.push(0);
        for(int i = 1;i < n;i++){
            
            //popping out element whenever there is any value less than or equal to the top element of the stack
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        //if the stack is not empty then the remaining values have no smaller element than itself
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
 
        return result;
	} 
}
