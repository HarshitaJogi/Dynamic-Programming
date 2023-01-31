import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Longest_Increasing_Subsequence{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	static int N = 100;
    static int [] dp = new int [N];
    static int [] a = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        Arrays.fill(dp, -1);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, lis(i));
        }

        System.out.println(ans);


	}

    static int lis(int i){
        if(dp[i] != -1) return dp[i];
        int ans = 1;
        for(int j=0; j<i; j++){
            if(a[i] > a[j]){
                ans = Math.max(ans, lis(j) + 1);
            }
        }
        return dp[i] = ans;
    }
}