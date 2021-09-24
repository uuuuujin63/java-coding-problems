import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		Node am = new Node(0, 0);
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					am = new Node(i, j);
					//공기청정기 좌표 넣기
				}
			}
		}
		int[] dx1 = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] dx2 = {1, 0, -1, 0};
		
		int time = 0;
		while(true) {
			
			//1. 미세먼지 확산
			int[][] c_map = new int[n][m];
			//확산된 공기를 계산해서 담는 배열
			for(int x=0;x<n;x++) {
				for(int y=0;y<m;y++) {
					if(map[x][y]==0||map[x][y]==-1) continue;
					int cnt = 0;
					//확산 시키고, 확산될 방향의 개수를 구하는 for문
					for(int i=0;i<4;i++) {
						int nowx = x+dx1[i], nowy = y+dy[i];
						if(0>nowx||0>nowy||nowx>=n||nowy>=m) continue;
						if(map[nowx][nowy]==-1) continue;
						c_map[nowx][nowy]+=map[x][y]/5;	
						cnt++;						
					}
					if(cnt!=0) {
						c_map[x][y] += (map[x][y]-map[x][y]/5*cnt);
					}
				}
			}
			//확산 된 결과를 원래 배열에 담는 for문
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j] = c_map[i][j];
				}
			}
			
			map[am.x][am.y] = -1;
			map[am.x-1][am.y] = -1;

			//2. 공기청정기 작동
			int x1 = am.x-2;
			int y1 = am.y;
			//공기청정기 윗칸은 위에서부터 시작
			int x2 = am.x+1;
			int y2 = am.y;
			//공기청정기 아랫칸의 아래부터 시작
			//공기청정기에 들어가면 미세먼지가 사라지므로 공기청정기에 들어가는 부분부터 해주면된다.
			for(int i=0;i<4;i++) {
				while(true) {
					int nowx1 = x1+dx1[i], nowy1 = y1+dy[i];
					if(nowx1<0||nowy1<am.y||nowx1>am.x-1||nowy1>=m) break;
					if(map[nowx1][nowy1]==-1) {
						map[am.x-1][am.y+1] = 0;
						break;
					}
					map[x1][y1] = map[nowx1][nowy1];
					x1 = nowx1;
					y1 = nowy1;
				}
				
				while(true) {
					int nowx2 = x2+dx2[i], nowy2 = y2+dy[i];
					if(nowx2<am.x||nowy2<am.y||nowx2>=n||nowy2>=m) break;
					if(map[nowx2][nowy2]==-1) {
						map[am.x][am.y+1] = 0;
						break;
					}
					map[x2][y2] = map[nowx2][nowy2];
					x2 = nowx2;
					y2 = nowy2;

				}
			}
			
			time++;

			if(time == t) break;
			//t초후 종료
		}
		int res =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0&&map[i][j]!=-1) {
					res+=map[i][j];
				}
			}
		}
		System.out.println(res);
	}
}

class Node{
	int x,y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

