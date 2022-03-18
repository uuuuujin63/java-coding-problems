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
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Node[] info = new Node[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				info[i] = new Node(start, end, cost);
			}
			
			Arrays.sort(info);
			// 정렬
			
			int[] dp = new int[n];
			dp[0] = info[0].cost;
			
			for(int i=1;i<n;i++) {
				int idx = -1;
				for(int j=0;j<i;j++) {
					if(info[j].end >= info[i].start) {
						// 일정이 겹치면
						break;
					}
					idx = j;
				}
				
				int bCost = idx>=0 ? dp[idx] : 0;
				dp[i] = bCost+info[i].cost > dp[i-1] ? bCost+info[i].cost : dp[i-1];
			}
			
			int res = dp[n-1];
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
