import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int v = Integer.parseInt(br.readLine());
			node[] node = new node[v + 1];
			node[0] = new node();
			for (int i = 1; i <= v; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				String info = st.nextToken();
				String c1 = st.hasMoreTokens() ? st.nextToken() : null;
				String c2 = st.hasMoreTokens() ? st.nextToken() : null;
				node[i] = new node(info, c1, c2);
			}

			boolean c = true;
			for (int i = 1; i <= v; i++) {
				// 부모노드가 연산자인데 자식노드에 하나의 노드만 있을 때
				if (node[i].info.equals("/") || node[i].info.equals("*") || node[i].info.equals("+")
						|| node[i].info.equals("-")) {
					if (node[i].c1 == null || node[i].c2 == null) {
						c = false;
						break;
					}
				}
				// 부모노드가 숫자인데 자식 노드에 연산자가 없을 때
				else {
					if (node[i].c1 != null || node[i].c2 != null) {
						c = false;
						break;
					}
				}
			}
			
//			System.out.println("#"+t+" "+res);
			sb.append("#").append(t).append(" ");
			if (c) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
//			sb.append("#").append(t).append(" ").append((common_p+1)).append(" ").append(cnt).append("\n");

		}
		System.out.println(sb);
	}
}

class node {
	String info, c1, c2;

	public node() {
		super();
	}

	public node(String info, String c1, String c2) {
		super();
		this.info = info;
		this.c1 = c1;
		this.c2 = c2;
	}
}
