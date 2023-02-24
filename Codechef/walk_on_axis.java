/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		for(long i=0; i<t; i++){
		    long n = sc.nextLong();
		    
		    long ans = (2*n) + (n*n) - (n*(n+1))/2;
		    
		    System.out.println(ans);
		}
	}
}
