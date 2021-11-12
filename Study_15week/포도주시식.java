import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] podoju = new int[n];
		int[] dp = new int[n+1];
		
		
		for(int i=0;i<n;i++	) {
			podoju[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = podoju[0];
		
		if(n == 1) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		dp[2] = podoju[1]+podoju[0];
		if(n == 2) {
			System.out.println(dp[2]);
			System.exit(0);
		}
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+podoju[i-1], dp[i-3]+podoju[i-2]+podoju[i-1]));
		}
		
		System.out.println(Math.max(dp[n], dp[n-1]));
	}
}
