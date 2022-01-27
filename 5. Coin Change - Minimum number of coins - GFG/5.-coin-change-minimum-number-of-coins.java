// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    //taking value
		    int value=sc.nextInt();
		    
		    //taking number of coins
		    int numberOfCoins=sc.nextInt();
		    int coins[]=new int[numberOfCoins];
		    
		    //adding coins to the array
		    for(int i=0;i<numberOfCoins;i++)
		    {
		        int x=sc.nextInt();
		        coins[i]=x;
		    }
		    
		    //creating an object of class Geeks
		    Solution obj=new Solution();
		    
		    //calling minimumNumberOfCoins() method of class Geeks
		    long answer=obj.minimumNumberOfCoins(coins,numberOfCoins,value);
		    
		    //printing "Not Possible" if answer is -1,
		    //else printing answer
		    System.out.println(answer==-1?"Not Possible":answer);
		}
	}
}


// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of coins to make the change 
    //for value using the coins of given denominations.
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        // your code here
        long[] dp = new long[value + 1];//storing minimum number of coins for a particular value(which is the index of the array)
        Arrays.fill(dp, Long.MAX_VALUE);
        
        dp[0] = 0;//since no/zero coins are needed to make zero value
        
        for(int amount = 1;amount <= value;amount++){
            for(int coin = 0;coin < numberOfCoins;coin++){
                
                //check if the value of coin is less than or equal to the amount (cause then only we will consider the coin)
                if(coins[coin] <= amount){
                     //prev result or the number of coins it needed to make the amount excluding the current coin;
                     long subRes = dp[amount - coins[coin]];
                     if(subRes != Long.MAX_VALUE){
                         dp[amount] = Math.min(dp[amount],1 + subRes);
                     }
                
                }
               
            }
        }
        
        return dp[value] == Long.MAX_VALUE ? -1 : dp[value];
    }
}