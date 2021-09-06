import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		//최댓값으로 초기화
		daji(n, k, dist);
		System.out.println(dist[k]);
	}
	public static void daji(int n, int k, int[] dist) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(n, 0));
		dist[n] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.time>dist[now.nowx]) continue;
			//지금 경과된 시간보다 먼저 도착한 적이 있다면 더이상 볼 필요가 없으므로 컨티뉴 해준다.
			if(now.time>dist[k]) continue;
			//도착지에 저장되어 있는 시간보다 큰 시간이라면 더 이상 보는 이유가 없으므로 컨티뉴 해준다.
			
			if(now.nowx+1<100001&&now.time+1<dist[now.nowx+1]) {
				dist[now.nowx+1] = now.time+1;
				q.add(new Node(now.nowx+1, now.time+1));
			}
			
			if(now.nowx-1>=0&&now.time+1<dist[now.nowx-1]) {
				dist[now.nowx-1] = now.time+1;
				q.add(new Node(now.nowx-1, now.time+1));
			}
			
			if(now.nowx*2<100001&&now.time<dist[now.nowx*2]) {
				dist[now.nowx*2] = now.time;
				q.add(new Node(now.nowx*2, now.time));
			}
			
		}
		
	}
}
class Node implements Comparable<Node>{
	int nowx, time;

	public Node(int nowx, int time) {
		super();
		this.nowx = nowx;
		this.time = time;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.time-o.time;
	}
	
	
}
