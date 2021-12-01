import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		node[] unit = new node[n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			unit[i] = new node(k, s);
		}
		
		int[][] dp = new int[n+1][t+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=t;j++) {
				if(unit[i].k<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-unit[i].k]+unit[i].s);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][t]);
	}
}
class node{
	int k, s;

	public node(int k, int s) {
		super();
		this.k = k;
		this.s = s;
	}
	
}


