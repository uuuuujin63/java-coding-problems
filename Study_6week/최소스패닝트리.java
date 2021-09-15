import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tt=1;tt<=t;tt++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ArrayList<node>[] list = new ArrayList[v+1];
			for(int i=0;i<=v;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list[x].add(new node(y, w));
				list[y].add(new node(x, w));
			}
			
			boolean[] visit = new boolean[v+1];
			PriorityQueue<node> q = new PriorityQueue<node>();
			q.add(new node(1,0));
			
			int cnt = 0;
			long res = 0;
			while(!q.isEmpty()) {
				node now = q.poll();
				
				if(visit[now.x]) continue;
				//이미 방문했으면 컨티뉴
				
				res += now.w;
				visit[now.x] = true;
				
				if (++cnt == v) {
					break;
				}
				
				for(int i=0;i<list[now.x].size();i++) {
					node next = list[now.x].get(i);
					if(visit[next.x] == true) continue;
					q.add(next);
				}
			}
			
			sb.append("#").append(tt).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

}

class node implements Comparable<node>{
	int x;
	long w;

	public node(int x, long w) {
		super();
		this.x = x;
		this.w = w;
	}

	@Override
	public int compareTo(node o) {
		return (this.w - o.w)>0? 1:-1;
	}
	
}
