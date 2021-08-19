import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1 };
	static int r, c, res;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			connect_pipe(i, 0);
		}
		System.out.println(res);
	}

	public static boolean connect_pipe(int x, int y) {
		if (y == c - 1) {
			res++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nowx = x + dx[i];
			int nowy = y + 1;
			if (!((0 <= nowx && nowx < r) && (0 <= nowy && nowy < c)))
				continue;
			if (map[nowx][nowy] == '.') {
				map[nowx][nowy] = 'x';
				if (connect_pipe(nowx, nowy))
					return true;
			} 
		}
		return false;
	}

}
