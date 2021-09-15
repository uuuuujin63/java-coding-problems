import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n,m,k;
	static int[][] map;
	static boolean[][][] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		v = new boolean[n][m][k+1]; //k카운트에 대해 방문표시 할 배열. n행 m열 말의 이동을 k번 했다.
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(n==1&&m==1) {
			System.out.println("0");
			System.exit(0);
		}
		
		System.out.println(go_monkey());
	}
	
	public static int go_monkey() {
		PriorityQueue<node> q = new PriorityQueue<>();
		int[] dx = {1, 0, -1, 0, -2, -1, 1, 2, -2, -1, 1, 2};
		int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
		//4~11 : 말처럼
		
		q.add(new node(0, 0, 0, 0));
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			int k_cnt = now.k_cnt;
			if(x==n-1&&y==m-1) return time;
			for(int i=0;i<12;i++) {
				int nowx = x+dx[i];
				int nowy = y+dy[i];
				if(nowx<0||nowy<0||nowx>=n||nowy>=m) continue;
				if(map[nowx][nowy] == 1) continue;
				if(i>=4&&k_cnt>=k) break;
				if(i>=4) {
					if(!v[nowx][nowy][k_cnt+1]) {
						q.add(new node(nowx, nowy, time+1, k_cnt+1));
						v[nowx][nowy][k_cnt+1] = true;
					}
				}else {
					if(!v[nowx][nowy][k_cnt]) {
						v[nowx][nowy][k_cnt] = true;
						q.add(new node(nowx, nowy, time+1, k_cnt));
					}
				}
			}
		}
		return -1;
	}
}

class node implements Comparable<node>{
	int x,y,time,k_cnt;

	public node(int x, int y, int time, int k_cnt) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
		this.k_cnt = k_cnt;
	}

	@Override
	public int compareTo(node o) {
		if(o.time==this.time) {
			return this.k_cnt-o.k_cnt;
		}
		return this.time-o.time;
	}
	
}

