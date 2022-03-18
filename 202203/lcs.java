import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr1 = br.readLine().toCharArray();
			char[] arr2 = br.readLine().toCharArray();
			int n = arr1.length;
			int m = arr2.length;

			int[][] dp = new int[n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if(arr1[i-1]==arr2[j-1]) {
						dp[i][j] = dp[i-1][j-1]+1;
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			int res = dp[n][m];
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
