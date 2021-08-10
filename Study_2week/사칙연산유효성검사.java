import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String[] four_cal = { "+", "-", "*", "/" };
		int t = 10;
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int hn = n % 2 == 0 ? n / 2-1 : n / 2 ;
			String[] arr = new String[n + 1];
			int res = 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				if(res == 0 ) continue;
				if (i < hn) { // 자식이 두개
					for (int j = 0; j < 4; j++) {
						if (j == 1)
							arr[i + 1] = st.nextToken();
						else
							st.nextToken();
					}
					int flg = 0;
					for (int j = 0; j < 4; j++) {
						if (arr[i + 1].equals(four_cal[j])) {
							flg = 1;
							break;
						}
					}
					if (flg == 0) {
						res = 0;
					}
				} else {
					if (n % 2 == 0 && i == hn) { // 자식이 하나밖에 없다.
						for (int j = 0; j < 3; j++) {
							if (j == 1)
								arr[i + 1] = st.nextToken();
							else
								st.nextToken();
						}
						for (int j = 0; j < 4; j++) {
							if (arr[i + 1].equals(four_cal[j])) {
								res = 0;
								break;
							}
						}
					} else {
						for (int j = 0; j < 2; j++) {
							if (j == 1)
								arr[i + 1] = st.nextToken();
							else
								st.nextToken();
						}
						for (int j = 0; j < 4; j++) {
							if (arr[i + 1].equals(four_cal[j])) {
								res = 0;
								break;
							}
						}
					}

				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");

		}
		System.out.println(sb);

	}

}
