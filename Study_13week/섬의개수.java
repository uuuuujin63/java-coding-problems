import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			// w : 너비
			int h = Integer.parseInt(st.nextToken());
			// h : 높이
			if(w==0&&h==0) break;
			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<node> q = new LinkedList<node>();
			int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
			int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
			int res = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0)
						continue;

					q.add(new node(i, j));
					map[i][j] = 0;
					res++;
					while(!q.isEmpty()) {
						node xy = q.poll();
						for(int k=0;k<9;k++) {
							int nowx = xy.x+dx[k];
							int nowy = xy.y+dy[k];
							if(0>nowx||0>nowy||h<=nowx||w<=nowy) continue;
							if(map[nowx][nowy]!=0) {
								q.add(new node(nowx, nowy));
								map[nowx][nowy] = 0;
							}
						}
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);

	}
}

class node {
	int x, y;

	public node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
