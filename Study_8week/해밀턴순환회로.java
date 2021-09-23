import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, sum = Integer.MAX_VALUE;
	static int[][] g;
	static boolean[] v;
	static int[] vi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine().trim());
		g = new int[n][n];
		v = new boolean[n];
		vi = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(sum);
	}

	public static void dfs(int s, int cnt, int x) {
		if (s > sum) {
			// 기존의 합보다 크다면 break
			return;
		}
		if (cnt == n - 1) {
			if(g[x][0]!=0) {
				sum = Math.min(sum, s+g[x][0]);
			}
		}
		for (int i = 1; i < n; i++) {
			if(i==x) continue;
			if (!v[i]) {
				if (g[x][i] != 0) {
					v[i] = true;
					vi[cnt+1] = i;
					dfs(s + g[x][i], cnt + 1, i);
					v[i] = false;
				}
			}
		}
	}

}
