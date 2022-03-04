import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			// v : 정점
			int e = Integer.parseInt(st.nextToken());
			// e : 간선
			
			List<Integer>[] g = new LinkedList[v];
			
			for(int i=0;i<v;i++) {
				g[i] = new LinkedList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			int[] searchStart = new int[v];
			
			for(int i=0;i<e;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a-1].add(b-1);
				searchStart[b-1]++;
			}
			
			boolean[] visit = new boolean[v];
			
			Queue<Integer> q = new LinkedList<>();
			
			sb.append("#").append(t).append(" ");
			
			for(int i=0;i<v;i++) {
				if(searchStart[i]!=0) continue;
				q.add(i);
			}
			
			while(!q.isEmpty()) {
				int p = q.poll();
				sb.append((p+1)+" ");
				visit[p] = true;
				for(int c:g[p]) {
					searchStart[c]--;
					if(searchStart[c]==0) q.add(c);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
