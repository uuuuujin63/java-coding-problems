import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] wei = new int[n];
			boolean[] v = new boolean[n];
			res = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				wei[i] = Integer.parseInt(st.nextToken());
			}
			permu(0, 0, 0, wei, v, n);
			bw.write("#" + tc + " " + res + "\n");
		}
		bw.flush();
		bw.close();
	}

	// 항상 sum_r<=sum_l
	public static void permu(int cnt, int sum_r, int sum_l, int[] wei, boolean[] v, int n) {
		if (cnt == n) {
				res++;
				return;
			
		}
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			
			v[i] = true;
			permu(cnt + 1, sum_r, sum_l + wei[i], wei, v, n);
			
			if (sum_r + wei[i] <= sum_l) {
				permu(cnt + 1, sum_r + wei[i], sum_l,  wei, v, n);
			}
			v[i] = false;
		}
	}

}
