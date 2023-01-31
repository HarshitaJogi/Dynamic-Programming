import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Frog_1{

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

	static int N = (int)1E6;
    static int [] dp = new int [N];
    static int [] h = new int [N];

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
            h[i] = sc.nextInt();
        }

        System.out.println(func(n-1));

	}

    static int func(int i){
        int cost = Integer.MAX_VALUE;

        if(i == 0) return 0;
        if(dp[i] != -1) return dp[i];

        // way 1
        cost = Math.min(cost, func(i-1) + Math.abs(h[i] - h[i-1]));

        // way 2
        if(i > 1){
            cost = Math.min(cost, func(i-2) + Math.abs(h[i] - h[i-2]));
        }
        

        return dp[i] = cost;

    }
}