import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static class Edge implements Comparable<Edge>{
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점
		int E = Integer.parseInt(st.nextToken()); // 간선

		ArrayList<Edge>[] e = new ArrayList[V]; // 인접리스트
		int k = Integer.parseInt(br.readLine()) - 1; // 시작
		boolean[] visit = new boolean[V];
		int[] wei = new int[V];
		for (int i = 0; i < V; i++) { // 초기화
			wei[i] = Integer.MAX_VALUE;
			e[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			e[u].add(new Edge(v, w));
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(k, 0));
		wei[k] = 0;
		// 시작
//		System.out.println(e[0].get(1)[0]);
	
		while (!q.isEmpty()) { // 큐가 비기 전까지 반복
			Edge now = q.poll();
			
			if(visit[now.v]) continue;
			visit[now.v] = true;
			for (int i = 0; i < e[now.v].size(); i++) {
				// now의 i번째 인접 정점인 v가 아직 방문되지 않았다면,
				if(wei[e[now.v].get(i).v]>wei[now.v] + e[now.v].get(i).w) {
					//현재의 경로가 최단거리라면 wei 값을 갱신해주고 큐에 넣어준다.
					wei[e[now.v].get(i).v] = wei[now.v] + e[now.v].get(i).w;
					q.offer(new Edge(e[now.v].get(i).v, wei[e[now.v].get(i).v]));
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			if(wei[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(wei[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
