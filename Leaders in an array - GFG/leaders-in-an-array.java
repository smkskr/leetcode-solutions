// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    
		    //appending result to a String
		    for(int i=0; i<res.size(); i++){
		        str.append(res.get(i)+" ");
		    }
		    
		    //printing the String
		    System.out.println(str);
		}
		
	}
}
// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> leadersList = new ArrayList<>();
        int leader = arr[n - 1];
        leadersList.add(leader);
        for(int index = n - 2;index >= 0;index--){
            
            if(arr[index] >= leader){
                leader = arr[index];
                leadersList.add(leader);
            }
        }
        reverse(leadersList);
        return leadersList;
    }
    
    static void reverse(ArrayList<Integer> leadersList){
        
        int left = 0;
        int right = leadersList.size() - 1;
        
        while(left < right){
            int copy = leadersList.get(left);
            leadersList.set(left, leadersList.get(right));
            leadersList.set(right, copy);
            left++;
            right--;
        }
        
    }
}
