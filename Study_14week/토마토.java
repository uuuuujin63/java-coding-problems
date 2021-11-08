import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int ek_cnt = 0;

		int[][][] map = new int[h][n][m];
		Queue<node> q = new LinkedList<node>();

		for (int i = h - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 0) {
						ek_cnt++;
					} else if (map[i][j][k] == 1) {
						q.add(new node(j, k, i));
						// 세로:x 가로:y 높이:z
					}
				}
			}
		}

		if (ek_cnt == 0) {
			// 다 익어있으면 0 출력
			System.out.println("0");
			System.exit(0);
		}

		int time = 0;
		int[] dx = { 0, 0, 0, 0, -1, 1 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { -1, 1, 0, 0, 0, 0 };
		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				node now = q.poll();
				int x = now.x;
				int y = now.y;
				int z = now.z;

				for (int j = 0; j < 6; j++) {
					int nowx = x + dx[j], nowy = y + dy[j], nowz = z + dz[j];
					if(nowx<0||nowy<0||nowz<0||nowx>=n||nowy>=m||nowz>=h) continue;
					// 예외처리
					
					if(map[nowz][nowx][nowy]==-1||map[nowz][nowx][nowy]==1) continue;
					// 익어있거나, 비어있으면 continue
					
					if(map[nowz][nowx][nowy]==0) {
						map[nowz][nowx][nowy] = 1;
						cnt++;
						q.add(new node(nowx, nowy, nowz));
					}
				}				
			}
			ek_cnt -= cnt;
			if(ek_cnt==0) {
				break;
			}
		}
		
		if(ek_cnt==0) {
			System.out.println(time);
		}else {
			System.out.println("-1");
		}

	}
}

class node {
	int x, y, z;

	public node(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "node [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
