import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int res = 0;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		v = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		permu(n, 0, 0, arr, 0);
		System.out.println(res);
	}

	public static void permu(int n, int cnt, int sum, int[] arr, int before) {
		if (cnt == n) {
			res = Math.max(res, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			// 아직 방문하지 않았다면,
			v[i] = true;
			if (cnt == 0) { // 첫번째꺼는 sum 그대로
				permu(n, cnt + 1, sum, arr, i);
			} else {
				int tmp = Math.abs(arr[i] - arr[before]);
				permu(n, cnt + 1, sum + tmp, arr, i);
			}
			v[i] = false;

		}
	}
}
