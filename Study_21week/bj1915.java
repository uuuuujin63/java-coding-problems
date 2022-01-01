// 가장 큰 정사각형
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열
        
        char[][] map = new char[n+1][m+1];
        
        for(int i=0;i<n;i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        int[][] dp = new int[n+1][m+1];

        int max = 0;
        
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=m;j++) {
        		// 1. 현재 값이 0일 때 0 그대로 입력
        		if(map[i-1][j-1]=='0') {
        			dp[i][j] = 0;
        			continue;
        		}

        		dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;

        		max = Math.max(max, dp[i][j]);
        	}
        }
        System.out.println(max*max);
	}
}
