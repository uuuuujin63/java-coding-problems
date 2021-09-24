import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ca {
	static int n, m, d, res, cnt;
	static int[][] map;
	static int[] s = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cnt++;
				// 적의 수 세놓기
			}
		}
		position(0, 0);
		System.out.println(res);
	}

	// position : 궁수의 위치에 대한 조합을 만듬
	public static void position(int cnt, int start) {
		if (cnt == 3) {
			start_game();
			return;
		}

		for (int i = start; i < m; i++) {
			s[cnt] = i;
			position(cnt + 1, i + 1);
		}
	}

	// start_game : 게임 시작
	public static void start_game() {
		int[] dx = { 0, -1, 0 };
		int[] dy = { -1, 0, 1 }; 
		int c = 0;
		// 죽인 적의 수를 카운트하는 변수 c
		// 하나의 궁수 위치 조합에 대한 죽은 적 카운트이므로 제일 위에 선언해줘야한다.
		int[][] tmp = new int[n][m];
		// map을 원상태로 돌려놓기 위한 tmp 배열
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int t = n - 1; t >= 0; t--) {
			// 적의 이동, 배열을 바꾸는 건 오래걸리니까 궁수를 위로 올린다.
			// 궁수의 위치 : t+1
			// t가 변할 때 한 턴이 시작된다.
			Queue<Node> k_list = new LinkedList<Node>();
			// 한 턴에 같은 적을 죽일 수 있으므로 큐에 담아두고 한 번에 처리

			for (int j = 0; j < 3; j++) {
				// j : 궁수 인덱스
				Queue<Node> q = new LinkedList<>();
				// bfs로 진행
				q.add(new Node(t+1, s[j]));
				//궁수의 위치를 q에 넣음
				
				outer:while (!q.isEmpty()) {
					int qn = q.size();
					// bfs로 진행할 것이므로, 처음에 존재하는 큐의 크기내에 들어있는 좌표들은 서로 궁수와의 거리가 같다.
					// 따라서 그 크기만큼씩 진행해주면 된다.
					boolean check = false;
					// 적을 죽였는지 체크하는 변수
					int cx = 0;
					int cy = 0;
					// 죽일 적의 후보 좌표
					// 만약 더 왼쪽에 있는 것이 있으면 바꿔줄 것이므로
					
					for(int qq=0;qq<qn;qq++) {
						int x = q.peek().x;
						int y = q.peek().y;
						q.poll();
						for (int i = 0; i < 3; i++) {
							int nowx = x + dx[i], nowy = y + dy[i];
							if (nowx < 0 || nowy < 0 || nowx > t || nowy >= m)
								continue;
							if (d >= (Math.abs(nowx - (t+1)) + Math.abs(nowy - s[j]))) {
								if (map[nowx][nowy] == 1) {
									if(!check) {
										cx = nowx;
										cy = nowy;
										check = true;
									} else {
										if(cy>nowy) {
											//원래 후보보다 왼쪽에 있는경우
											cy = nowy;
											cx = nowx;
										}
									}
								}else if(map[nowx][nowy]==0){
									// 방문처리
									q.add(new Node(nowx, nowy));
									map[nowx][nowy]=-1;
								}
							}
						}
					}
					if(check) {
						k_list.add(new Node(cx, cy));
						//거리 안에 든 적을 찾으면 추가 후 종료
						break outer;
					}
				}
				for(int i=0;i<n;i++) {
					for(int k=0;k<m;k++) {
						if(map[i][k]==-1) map[i][k]=0;
						//방문표시해준 것 원상복귀 시켜준다.
					}
				}
			}
			for(Node k:k_list) {
				if(map[k.x][k.y]==1) {
					map[k.x][k.y]=0;
					c++;
				}
			}
			if (c == cnt) {
				break;
				// 죽은 적과 원래 있던 적의 개수가 같으면 다 죽였으므로 그만해도 된다.
			}
		}
		res = Math.max(res, c);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = tmp[i][j];
			}
		}
		//돌려놓기
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
