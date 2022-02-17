// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int val = findRepeatingNumber(arr);
        
        int xor = 1;
        for(int i = 2;i <= n;i++){
            xor = xor ^ i;
        }
        
        for(int i = 0;i < n;i++){
            
            if(i == val)continue;//skip the repeating element
            xor = xor ^ Math.abs(arr[i]);
        }
        
        int[] result = new int[2];
        result[0] = Math.abs(arr[val]);
        result[1] = xor;
        return result;
    }
    
    int findRepeatingNumber(int arr[]){
        
        int len = arr.length;
        int result = -1;
        for(int i = 0;i < len;i++){
            
            int val = Math.abs(arr[i]);
            if(arr[val - 1] < 0){
                result = i;
                break;
            }
            arr[val - 1] = -1*arr[val - 1];
        }
        
        return result;
    }
}