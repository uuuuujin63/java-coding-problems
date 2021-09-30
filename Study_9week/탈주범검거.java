
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][m];
			boolean[][] v = new boolean[n][m];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			if(l==1) {
				sb.append("#").append(tt).append(" ").append("1").append("\n");
				continue;
			}
			int[][] dx = {{0}, {0, 0, -1, 1}, {-1, 1}, {0, 0}, {-1,0}, {1, 0}, {1, 0}, {-1, 0}};
			int[][] dy = {{0}, {-1, 1, 0, 0}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};
			
			Queue<node> q = new LinkedList<node>();
			v[r][c] = true;
			q.add(new node(r, c));
			int time = 1; //경과하는 시간을 담는 변수
			int cnt =1; //탈주범이 위치할 수 있는 장소의 개수를 담는 변수
			while(!q.isEmpty()) {
				int s = q.size(); //bfs로 돌리기 위해. 현재 시간에 봐야할 터널의 개수
				for(int ss=0;ss<s;ss++) {
					node now = q.poll();
					int x=now.x, y=now.y;
					int t_case = map[x][y];
					for(int i=0;i<dx[t_case].length;i++) {
						int nowx = x+dx[t_case][i], nowy = y+dy[t_case][i];
						if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
						//범위를 벗어나면 패스
						
						if(map[nowx][nowy]==0) continue;
						//터널이 없으면 패스
						
						if(!v[nowx][nowy]) {
							boolean check = false;
							//연결된 터널인지 확인하는 것
							
							if(map[nowx][nowy]==1) {
								check= true;
							}else {
								for(int j=0;j<dx[map[nowx][nowy]].length;j++) {
									int nx = nowx+dx[map[nowx][nowy]][j], ny = nowy+dy[map[nowx][nowy]][j];
									if(0>nx||0>ny||n<=nx||m<=ny) continue;
									if(nx == x && ny==y) {
										check = true;
										break;
									}
								}
							}
							if(check) {
								v[nowx][nowy]= true;
								q.add(new node(nowx, nowy));
								cnt++;	
							}
//							for(int a=0;a<n;a++) {
//								for(int b=0;b<m;b++) {
//									System.out.print(v[a][b]+" ");
//								}
//								System.out.println();
//							}
//							System.out.println();
						}
						
					}
				}
				time++; //시간이 1 경과됨
				if(time==l) break;
			}
			sb.append("#").append(tt).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}

class node{
	int x,y;

	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
