import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = 0;
			boolean c;
			
			for (int j = 0; j < n; j++) {
				c = false;
				for (int i = 0; i < n; i++) {
					// 0열부터 빨(1)->파(2)가 있는지 체크해준다.
					if(map[i][j]==0) continue;
					if(map[i][j]==1) c = true;
					// 빨강(n극) 이 나오면 체크해둠.
					else if(c && map[i][j]==2) {
						// 이미 빨강이 나왔고, 파랑이 나왔으면 교착상태므로 res++ 해줌
						res++;
						c = false;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
