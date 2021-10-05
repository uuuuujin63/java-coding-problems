
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h, res;
	static int[] s;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			s = new int[n];

			res = Integer.MAX_VALUE;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			put_ball(0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static void put_ball(int cnt) {
		if (cnt == n) {
			game_start();
			return;
		}
		for (int i = 0; i < w; i++) {
			s[cnt] = i;
			put_ball(cnt + 1);
		}
	}

	public static void game_start() {
		int[][] tmp = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		// 복사

		for (int i = 0; i < n; i++) {
			int x = -1; // 행
			int y = s[i]; // 열
			for (int j = 0; j < h; j++) {
				if (tmp[j][y] != 0) {
					x = j;
					break;
				}
			}
			if (x == -1)
				continue;
			// 깰 벽돌이 없다면 컨티뉴

			breaking(x, y, tmp);
			down_bricks(tmp);
		}
		// 깨고 아래로 내리기
		
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (tmp[i][j] != 0)
					cnt++;
			}
		}
		res = Math.min(cnt, res);
	}

	public static void breaking(int x, int y, int[][] tmp) {
		int n = tmp[x][y];
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		tmp[x][y] = 0;
		if (n == 1)
			return;

		for (int i = 0; i < 4; i++) {
			int nowx = x, nowy = y;
			for (int nn = 0; nn < n - 1; nn++) { // 벽돌에 써있는 수만큼 반복
				nowx += dx[i];
				nowy += dy[i];
				if (0 > nowx || 0 > nowy || h <= nowx || w <= nowy)
					break;
				if (tmp[nowx][nowy] == 0)
					continue;
				if (tmp[nowx][nowy] == 1) {
					tmp[nowx][nowy] = 0;
				} else {
					breaking(nowx, nowy, tmp);
				}
			}
		}
	}

	public static void down_bricks(int[][] tmp) {
		Queue<Integer> q;

		for (int i = 0; i < w; i++) {
			q = new LinkedList<>();
			for (int j = h - 1; j >= 0; j--) {
				if (tmp[j][i] != 0) {
					q.add(tmp[j][i]);
					tmp[j][i] = 0;
				}
			}
			int x = h - 1;
			while (!q.isEmpty()) {
				tmp[x--][i] = q.poll();
			}
		}
		
	}
}
