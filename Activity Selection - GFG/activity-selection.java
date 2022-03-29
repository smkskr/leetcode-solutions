// { Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int[][] intervals = new int[n][2];
        
        for(int i = 0;i < n;i++){
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        
        int prevFinishTime = intervals[0][1];
        int count = 1;
        
        for(int i = 1;i < n;i++){
            
            // if prev finish time is less than the next start time
            // then increase the counter
            if(prevFinishTime < intervals[i][0]){
                count++;
                prevFinishTime = intervals[i][1];
            }
        }
        
        return count;
    }
    
}