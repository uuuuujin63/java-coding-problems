import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Solution {
	public static final int INF = 10000000;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[251];
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		int nowN = 3;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			if(nowN<=n) {
				for(int i=nowN;i<=n;i++) {
					dp[i] = dp[i-2].multiply(new BigInteger("2"));
					dp[i] = dp[i].add(dp[i-1]);
				}
				nowN = n;
			}
			sb.append("#").append(test_case).append(" ").append(dp[n]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
