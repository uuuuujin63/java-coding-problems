import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] info = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				info[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = 0;

			outer:for (int i = 2; i < n - 2; i++) {
				int max = 0;
				// min : 인접한 i-2~i+2의 가장 큰 값을 넣을 변수
				
				for (int j = 1; j < 3; j++) {
					// 왼쪽
					if(info[i]<=info[i-j]) continue outer;
					// 조망권이 보장되지 않는다면 다음으로
					max = Math.max(max, info[i-j]);
				}

				for (int j = 1; j < 3; j++) {
					// 오른쪽
					if(info[i]<=info[i+j]) continue outer;
					max = Math.max(max, info[i+j]);
				}
				
				// 여기까지 내려왔다면 조망권 보장!
				res += info[i]-max;
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
