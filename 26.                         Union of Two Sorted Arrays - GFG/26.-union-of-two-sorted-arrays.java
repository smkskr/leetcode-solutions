// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}


// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        TreeSet<Integer> set = new TreeSet<>();
        
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        int index1 = 0;
        int index2 = 0;
        
        while(index1 < len1 && index2 < len2){
            
            if(arr1[index1] < arr2[index2]){
                addDistinctElements(result, arr1, index1);
                index1++;
            }
             else if(arr2[index2] < arr1[index1]){
                addDistinctElements(result, arr2, index2);
                index2++;
            }else{
                addDistinctElements(result, arr2, index2);
                index1++;index2++;
            }
          
        }
        
        while(index1 < len1){
            addDistinctElements(result, arr1, index1);
            index1++;
        }
        
        while(index2 < len2){
           addDistinctElements(result, arr2, index2);
           index2++;
        }
        
        
        
        return result;
    }
    
    public static void addDistinctElements(ArrayList<Integer> result, int[] array, int index){
        
                int lastIndex = result.size() - 1;
                if(lastIndex >= 0 && result.get(lastIndex) != array[index]){
                    result.add(array[index]);
                }else if(lastIndex == -1){
                   result.add(array[index]);
                }
    }
}



