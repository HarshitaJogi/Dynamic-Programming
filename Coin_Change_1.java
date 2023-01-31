import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Coin_Change_1{

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

	static int N = 10000;
    static int [] dp = new int [N];
    static ArrayList<Integer> coins = new ArrayList<Integer>();

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
        int amount = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            coins.add(x);
        }


        int ans = func(amount);

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
	}

    static int func(int amount){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];

        int ans = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount - coin >= 0){
                ans = Math.min(ans , func(amount - coin) + 1);
            }
        }

        return dp[amount] = ans;
    }
}