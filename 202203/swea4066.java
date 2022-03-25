import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static final int INF = 10000000;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] dist = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i != j)
						dist[i][j] = INF;
				}
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[a][b] = dist[a][b] > c ? c : dist[a][b];
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						dist[i][j] = dist[i][j] > dist[i][k] + dist[k][j] ? dist[i][k] + dist[k][j] : dist[i][j];
					}
				}
			}
			sb.append("#").append(test_case).append(" ");
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) sb.append("0 ");
					else if (dist[i][j]>=INF) sb.append("-1 ");
					else sb.append(dist[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
