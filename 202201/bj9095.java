// 1,2,3 더하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i=4;i<=10;i++) {
        	dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        
        
        for(int tt=0;tt<t;tt++) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(dp[n]).append("\n");
        }
        
        System.out.println(sb);
	}
}
