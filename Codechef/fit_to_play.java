/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static int N = 100000;
	static long [] arr = new long [N];
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int a=0; a<t; a++){
	        Arrays.fill(arr, 0);
	        long n = sc.nextLong();
	        for(long i=0; i<n; i++){
	            arr[(int)i] = sc.nextLong();
	        }
	        
	        
	        long l = 0l;
	        long h = 0l;
	        long diff = Long.MIN_VALUE;
	        
	        while(h<n){
	            
	            if(arr[(int)h]-arr[(int)l]>=0){
	                diff = Math.max(diff, arr[(int)h]-arr[(int)l]);
	            }
	            else{
	                l = h;
	            }
	            h++;
	        }
	        
	        if(diff == 0) System.out.println("UNFIT");
	        else System.out.println(diff);
	    }
	}
	
	
	
}
