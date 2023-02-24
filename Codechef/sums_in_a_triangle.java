/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int N = 1000;
    static ArrayList<Integer> [] a = new ArrayList[N];
    static int [][] dp = new int [N][N];
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int h=0; h<t; h++){
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		            dp[i][j] = -1;
		        }
		    }
		    // Taking input
		    int n = sc.nextInt();
		    for(int i=0; i<N; i++){
		        a[i] = new ArrayList<Integer>();
		    }
		    for(int i=0; i<n; i++){
		        for(int j=0; j<=i; j++){
		            int x = sc.nextInt();
		            a[i].add(x);
		        }
		    }
		    
		    System.out.println(sum(0,0, n));
		}
	}
	
	static int sum(int i, int j, int n){
	   
	        if(i==n) return 0;
	        if(dp[i][j]!= -1) return dp[i][j];
	        
	        int down = a[i].get(j) + sum(i+1, j, n);
	        int diag = a[i].get(j) + sum(i+1, j+1, n);
	        
	        return dp[i][j] = Math.max(down, diag);
	    
	}
}
