import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[] snack;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = -1;
			snack = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				snack[i]= Integer.parseInt(st.nextToken());
			}
			recur(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
	public static void recur(int total_w, int cnt, int select_cnt) {
		if(total_w>m) {
			return;
		}
		if(select_cnt==2||cnt == n) {
			if(m>=total_w && select_cnt>=2) {
				max = Math.max(max, total_w);
			}
			return;
		}
		recur(total_w+snack[cnt], cnt+1, select_cnt+1);
		recur(total_w, cnt+1, select_cnt);
	}

}
