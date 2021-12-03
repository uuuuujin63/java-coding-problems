import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static boolean v[];
	static int n;
	static double[][] p;
	static double res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tt=1;tt<=t;tt++) {
			n = Integer.parseInt(br.readLine());
			v = new boolean[n];
			p = new double[n][n];
			res = 0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					p[i][j] = Double.parseDouble(st.nextToken())/100.0;
				}
			}
			select_p(0, 1);
			sb.append("#").append(tt).append(" ").append(String.format("%.6f", res)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void select_p(int cnt, double sum) {
		if(res>=sum*100) return;
		if(cnt == n) {
			if(sum*100>res) {
				res = sum*100;
				return;
			}
			return;
		}
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i] = true;
				select_p(cnt+1, sum*p[cnt][i]);
				v[i]  = false;
			}
		}
	}
}
