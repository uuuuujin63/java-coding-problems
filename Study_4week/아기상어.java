import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int s_size = 2;//현재 아기상어의 크기를 담는 변수
	static int eat_cnt = 0; //아기상어가 먹은 상어의 수를 카운트 하는 변수
	static class Hubo implements Comparable<Hubo>{
		int x,y,time;

		public Hubo(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Hubo o) {
			// TODO Auto-generated method stub
			if(this.time == o.time) {
				if(this.x==o.x) {
					return this.y-o.y;
				}
				return this.x-o.x;
			}
			return this.time-o.time;
		}

		@Override
		public String toString() {
			return "Hubo [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map= new int[n][n];
		int shark_x = 0;
		int shark_y = 0;
		
		
		int fish_cnt = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark_x = i;
					shark_y = j;
					map[i][j] = 0;
				}
				else if(map[i][j] != 0) {
					fish_cnt++;
				}
			}
		}
		if(fish_cnt==0) {
			System.out.println("0");
			System.exit(0); 
			//물고기가 존재하지 않는 것이기 때문에 더이상 보지않고 0 출력 후 끝냄
		}
		
		int res = 0;
		while(true) {
			Hubo now = bfs(shark_x, shark_y, n, map);
			if(now.x==shark_x&&now.y==shark_y) {
				//넣은 좌표와 bfs끝난 좌표가 같다면 더이상 먹을 물고기가 없는 것.
				//while문을 종료해준다.
				break;
			}
			res += now.time;
			//아기상어의 이동거리가 이동시간이므로 ! !
			shark_x = now.x;
			shark_y = now.y;
			map[shark_x][shark_y] = 0;
			fish_cnt--;
//			System.out.println("("+shark_x+", "+shark_y+") 총 이동거리:"+res+" 상어 크기:"+s_size );
			//먹었으니 0으로 해줌
			eat_cnt ++;
			if(eat_cnt == s_size) {
				//자기의 크기만큼 물고기를 먹으면 사이즈를 키워준다.
				eat_cnt = 0;
				s_size++;
			}
			if(fish_cnt==0) break;
			//더이상 먹을 물고기가 없어도 끝내준당.
		}
		System.out.println(res);
	}
	public static Hubo bfs(int a, int b, int n, int[][] map ) {
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0}; //우선순위에 따른 dx dy 설정 (상, 중(왼, 오), 하)
		boolean[][] v = new boolean[n][n];
		PriorityQueue<Hubo> hubo = new PriorityQueue<>();
		PriorityQueue<Hubo> q = new PriorityQueue<>();
		q.add(new Hubo(a, b, 0)); //시작점 넣기
		while(!q.isEmpty()) {
			Hubo xy = q.poll();
			for(int i=0;i<4;i++) {
				int nowx = xy.x+dx[i];
				int nowy = xy.y+dy[i];
				if(0>nowx||nowx>=n||0>nowy||nowy>=n) continue;
				//범위에 안맞으면 패쓰
				if(v[nowx][nowy]) continue;
				//방문했으면 패쓰
				
				if(map[nowx][nowy]>s_size) {
					v[nowx][nowy] = true;
					continue; 
				}
				//큰 물고기는 못지나가니까 큐에 담지 않는다. 팼ㅆ쓰!
				
				
				if(map[nowx][nowy]<s_size&&map[nowx][nowy]!=0) { 
					//작은 물고기를 만나면
					hubo.add(new Hubo(nowx, nowy, xy.time+1));
				}
				
				//위에 상황에서도 컨티뉴 혹은 리턴되지 않았다면 크기가 같은 물고기거나, 맵이 0임. 계속 이어가야한당
				q.add(new Hubo(nowx, nowy, xy.time+1));
				v[nowx][nowy] = true;
				//넣을때 방문표시 안하면 메모리초과 난다 !
				//ㅍ필수 ㅠㅠㅠㅠㅠ
//				System.out.println(Arrays.toString(q.peek()));
			}
			
		}
		
		if(hubo.size()==0) {
			Hubo noteat = new Hubo(a, b, 0);
			return noteat;
			//먹을 물고기가 없는 경우
		}
		
		int nowtime = hubo.peek().time;
		int nx = hubo.peek().x;
		int ny = hubo.peek().y;
		//제일 작은 시간과 같은 것들만 좌표비교해줄것임 !!
//		System.out.println(hubo.toString());
		
		while(!hubo.isEmpty()) {
			//좌표값 비교해주기.
			Hubo next = hubo.poll();
			if(nowtime != next.time) break;
			//시간이 커졌기 때문에 그만 비교해도된다.
			
			if(next.x<nx) {
				nx = next.x;
				ny = next.y;
				//제일 상단에 있는 것
				continue;
			}
			if(next.x == nx && next.y<ny) {
				//높이는 같으나 더 왼쪽에 있으면
				nx = next.x;
				ny = next.y;
				continue;
			}
			
		}
		Hubo eat = new Hubo(nx, ny, nowtime);
		return eat;
	}

}
