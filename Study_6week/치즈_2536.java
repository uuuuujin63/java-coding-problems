import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		int last_c = 0;
		while(true) {			
			Queue<Integer[]> q = new LinkedList<>();
			//바깥공기를 표시해주기 위해서 bfs 진행
			//(0,0)은 무조건 바깥공기
			
			q.add(new Integer[]{0,0});
			map[0][0] = -1;
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
			while(!q.isEmpty()) {
				Integer[] nxy = q.poll();
				int x = nxy[0];
				int y = nxy[1];
				
				for(int i=0;i<4;i++) {
					int nowx = x+dx[i];
					int nowy = y+dy[i];
					
					if(nowx<0||nowy<0||nowx>=n||nowy>=m) continue;
					
					if(map[nowx][nowy]==0) {
						map[nowx][nowy] = -1;
						q.add(new Integer[] {nowx,nowy});
					}
				}
			}
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			Queue<Integer[]> cq = new LinkedList<>();
			//녹일 치즈들이 들어갈 q. 마지막에 한번에 없애주기 위함
			
			for(int x=0;x<n;x++) {
				for(int y=0;y<m;y++) {
					if(map[x][y]!=1) continue;
					
					boolean c = false;
					//공기와 접촉했는지 체크하는 변수
					for(int i=0;i<4;i++) {
						int nowx = x+dx[i];
						int nowy = y+dy[i];
						if(map[nowx][nowy]==-1) {
							c = true;
							break;
						}
					}
					if(c) {
						cq.add(new Integer[] {x,y});
					}
				}
			}
			
			if(cq.isEmpty()) {
				//녹일 치즈가 더이상 존재하지 않으면 break
				break;
			}
			
			int cnt = 0;
			while(!cq.isEmpty()) {
				Integer[] poll = cq.poll();
				map[poll[0]][poll[1]] = 0;
				//치즈 녹이기
				cnt++;
			}
			last_c = cnt;
			res++;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==-1) {
						map[i][j]=0;
					}
				}
			}
			//초기화
			
		}
		System.out.println(res);
		System.out.println(last_c);
	}
}

