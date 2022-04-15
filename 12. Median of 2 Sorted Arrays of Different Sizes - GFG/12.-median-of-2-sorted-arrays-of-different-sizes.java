// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        
        if(n > m){
           return medianOfArrays(m, n, b, a);
        }
        
        int low = 0;
        int high = n;
        while(low <= high){
            
            int part1 = (low + high)/2;
            int part2 = (n + m + 1)/2 - part1;
            
            int maxLeftA = part1 == 0 ? Integer.MIN_VALUE : a[part1 - 1];
            int minRightA = part1 == n ? Integer.MAX_VALUE : a[part1];
            
            int maxLeftB = part2 == 0 ? Integer.MIN_VALUE : b[part2 - 1];
            int minRightB = part2 == m ? Integer.MAX_VALUE : b[part2];
            
            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                
                if((n + m)%2 == 0){
                    return (double)(Math.max(maxLeftA,maxLeftB) + Math.min(minRightA, minRightB))/2;
                }else{
                    return Math.max(maxLeftA, maxLeftB);
                }
            }else if(maxLeftA > minRightB){
                high = part1 - 1;
            }else{
                low = part1 + 1;
            }
            
        }
        
        return -1;
    }
}