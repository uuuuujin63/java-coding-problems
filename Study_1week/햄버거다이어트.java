import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int n, l;
	static int[] point;
	static int[] kal;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			point = new int[n];
			kal = new int[n];
			for(int i=0;i<n;i++	) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			recur(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	public static void recur(int cnt, int k_sum, int p_sum) {
		if(k_sum>l) {
			return;
		}
		if(cnt == n) {
			res = Math.max(res, p_sum);
			return;
		}
		recur(cnt+1, k_sum+kal[cnt], p_sum+point[cnt]);
		recur(cnt+1, k_sum, p_sum);
	}

}
