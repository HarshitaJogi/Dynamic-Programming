import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class zero_One_Knapsack{

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
    static int [][] dp = new int [N][N];
    static int [] wt = new int [N];
    static int [] val = new int [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dp[i][j] = -1;
            }
        }

        int n = sc.nextInt();
        int w = sc.nextInt();

        for(int i=0; i<n; i++){
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        System.out.println(Knapsack(n-1, w));


	}

    static int Knapsack(int index, int wt_left){
        int ans = Integer.MIN_VALUE;

        if(wt_left == 0) return 0;

        if(index < 0) return 0;

        if(dp[index][wt_left] != -1) return dp[index][wt_left];

        // dont choose item at index
        ans = Knapsack(index-1, wt_left);

        // choose item at index
        if(wt_left - wt[index] >= 0)
        ans = Math.max(ans, Knapsack(index-1, wt_left - wt[index])+ val[index]) ;

        return dp[index][wt_left] = ans;
    }
}