
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] f = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			f[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			f[a].add(b);
			f[b].add(a);
		}

		boolean[] v = new boolean[n];

		v[0] = true;

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(0);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int x = q.poll();
				for (int nowx : f[x]) {
					if (v[nowx])
						continue;
					v[nowx] = true;
					res++;
					q.add(nowx);
				}
			}
			cnt++;
			if(cnt==2) break;
		}

		System.out.println(res);
	}
}
