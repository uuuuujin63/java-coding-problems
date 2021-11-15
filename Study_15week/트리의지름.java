import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int w_max, max_idx;
	static List<node>[] g;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		g = new ArrayList[n + 1];
		for (int i = 0; i < n+1 ; i++) {
			g[i] = new ArrayList<node>();
		}

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[p].add(new node(c, w));
			g[c].add(new node(p, w));
		}

		v = new boolean[n + 1];
		v[1] = true;
		dfs(0, 1);

		v = new boolean[n + 1];
		v[max_idx] = true;
		dfs(0, max_idx);
		System.out.println(w_max);
	}

	public static void dfs(int w_sum, int p) {
		

		// 가중치 합 비교
		if (w_sum > w_max) {
			w_max = w_sum;
			max_idx = p;
		}

		// 하위 혹은 상위 node로 가기
		for (node x : g[p]) {
			if (!v[x.c]) {
				v[x.c] = true;
				dfs(w_sum + x.w, x.c);
				v[x.c] = false;
				
			}
		}
	}
}

class node {
	int c, w;
	// 연결된 자식과 가중치 값이 들어감
	// 혹은 부모와 가중치 값이 들어감

	public node(int c, int w) {
		super();
		this.c = c;
		this.w = w;
	}

}
