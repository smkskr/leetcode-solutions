// { Driver Code Starts
import java.util.*;

class Main
{   
    
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int missing = new Solution().findMissing(arr,n);
			
			System.out.println(missing);
		}
    }
}// } Driver Code Ends




class Solution{
    
    // Function to find 
    static int findMissing(int arr[], int size)
    {
       
       int start = 0;
       // Your code here
      while(start < size){
           
           int correctIndex = arr[start] - 1;
           if((correctIndex >= 0 && correctIndex < size) && arr[correctIndex] != arr[start]){
               int temp = arr[correctIndex];
               arr[correctIndex] = arr[start];
               arr[start] = temp;
           }else{
               start++;
           }
           
       }
       
       //search
       for(int i = 0;i < size;i++){
           if(arr[i] - 1 != i){
               return i + 1;
           }
       }
       
       return size + 1;
       
    }
}