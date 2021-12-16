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
        for(int tt=0;tt<t;tt++) {
        	int n = Integer.parseInt(br.readLine());
        	int[][] info = new int[2][n+1];
        	int[][] dp = new int[2][n+1];
        	for(int i=0;i<2;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=1;j<=n;j++) {
        			info[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	for(int i=0;i<2;i++) {
        		dp[i][1] = info[i][1];
        	}
        	for(int i=2;i<=n;i++) {
        		dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+info[0][i];
        		dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+info[1][i];
        	}
        	sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(sb);
	}
}
