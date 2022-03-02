import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			char[] num = st.nextToken().toCharArray();
			int times = Integer.parseInt(st.nextToken());
			
			res = 0;
			change(times, 0, num);
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static void change(int cnt, int start, char[] num) {
		if (cnt == 0) {
			// 교환횟수 끝나면
			int tmp = Integer.parseInt(new String(num));
			res = tmp > res ? tmp : res;
			return;
		}
		int n = num.length;
		for (int i = start; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				char temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				change(cnt-1, i, num);
				num[j] = num[i];
				num[i] = temp;
			}
		}
	}
}
