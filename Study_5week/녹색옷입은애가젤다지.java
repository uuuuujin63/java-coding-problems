import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int[][] arr;
	static int[][] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			arr = new int[n][n];
			dist = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			daji();
			sb.append("Problem ").append(t).append(": ").append(dist[n-1][n-1]).append("\n");
			t ++ ;
		}
		System.out.println(sb);
	}
	public static void daji() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, arr[0][0]));
		dist[0][0] = arr[0][0];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y= now.y;
			for(int i=0;i<4;i++) {
				int nowx = x+dx[i];
				int nowy = y+dy[i];
				if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue;
				if(dist[x][y]+arr[nowx][nowy]<dist[nowx][nowy]) {
					dist[nowx][nowy] = dist[x][y]+arr[nowx][nowy];
					q.add(new Node(nowx, nowy, dist[nowx][nowy]));
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int x, y, time;

	

	public Node(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}



	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.time-o.time;
	}
	
	
}
