import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		p[x] = y;
		
		return true;
	}
	public static int find(int x) {
		if(p[x]==x) return x;
		
		return p[x]=find(p[x]);
		
	}
	public static void make_set(int n) {
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
	}
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		p = new int[n+1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			q.add(new Node(x, y, w));
		}
		int res = 0;
		make_set(n);
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			int x = find(now.x);
			int y = find(now.y);
			
			if(x==y) continue;
			//부모가 같으면 합칠 수 없으므로 컨티뉴
			
			union(x, y);
			//아니면 합치고 가중치 값 더해주기
			res += now.w;
			
			
			boolean c = true;
			for(int i=1;i<=n;i++) {
				int flg = find(1);
				if(flg != find(i)) {
					c = false;
				}
			}
			if(c) break;
			//모두의 부모가 같다면 break 끝
		}
		System.out.println(res);
		
		
	}
}
class Node implements Comparable<Node>{
	int x, y, w;

	public Node(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.w-o.w;
	}
	
	
}
