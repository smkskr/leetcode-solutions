// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
        //add code here.
        int[] charCount = new int[26];
        int len = s.length();
        int len1 = s1.length();

        for(int i = 0;i < len;i++){
            charCount[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0;i < len1;i++){
            charCount[s1.charAt(i) - 'a']--;
        }
        
        int sum = 0;
        for(int i = 0;i < 26;i++){
            sum+=Math.abs(charCount[i]);
        }
        
        return sum;
        }
        
      
      
}