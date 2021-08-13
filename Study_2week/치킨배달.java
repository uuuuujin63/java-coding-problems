import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int m, c_size, h_size;
	static ArrayList<int[]> c, h;
	static int res = Integer.MAX_VALUE;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		c = new ArrayList<>();
		h = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c_size = 0;
		h_size = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0)
					continue;
				else if (tmp == 1) {
					h.add(new int[] { i, j });// 집 좌표 추가
					h_size++;
				} else if (tmp == 2) {
					c.add(new int[] { i, j }); // 치킨집 좌표 추가
					c_size++;
				}
			}
		}
		visit = new int[m];

		select_c(0, 0);
		System.out.println(res);
	}

	public static void select_c(int select_cnt, int start) {
		if (select_cnt == m) {
			int count = 0, tmp = 0;
			for (int i = 0; i < h_size; i++) {
				int r = h.get(i)[0];
				int cc = h.get(i)[1]; // 집 하나당 치킨집 구하깅
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					tmp = Math.abs(r - c.get(visit[j])[0]) + Math.abs(cc - c.get(visit[j])[1]);
					min = Math.min(tmp, min);
				}
				count += min;
			}
			res = Math.min(res, count);
			return;
		}
		for (int i = start; i < c_size; i++) {
			visit[select_cnt] = i;
			select_c(select_cnt + 1, i+1);
		}
		return;
	}
}
