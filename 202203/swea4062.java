import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			char[][] map = new char[n][n];
			for(int i=0;i<n;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<n;j++) {
					map[i][j] = map[i][j]=='0' ? '1':'0';
				}
			}
			int[][] dp = new int[n][n];
			for(int i=0;i<n;i++) {
				dp[0][i] = map[0][i]-'0';
				dp[i][0] = map[i][0]-'0';
			}
			
			int res = 0;
			for(int i=1;i<n;i++) {
				for(int j=1;j<n;j++) {
					if(map[i][j]=='0') {
						dp[i][j] = 0;
						continue;
					}
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
					res = dp[i][j] > res ? dp[i][j]	: res;
				}
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
class Node implements Comparable<Node>{
	int start,end,cost;

	public Node(int start, int end, int cost) {
		super();
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		if(this.end==o.end) {
			// 끝나는 시간이 같다면 시작시간 기준 오름차순
			return this.start-o.start;
		}
		// 끝나는 시간기준 오름차순
		return this.end - o.end;
	}

	
}
