import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[8];
			for (int i = 0; i < 8; i++) {
				str[i] = br.readLine();
			}
			int res = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - n+1; j++) {
					// 가로 체크
					boolean c = true;
					for (int k = n-1; k >= n/2; k--) {
						if (str[i].charAt(j+n-1-k) != str[i].charAt(j + k)) {
							c = false;
							break;
						}
					}
					if (c) 
						res++;
				}
			}

			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - n+1; i++) {
					boolean c = true;
					for (int k = n-1; k >= n/2; k--) {
						if (str[i+n-1-k].charAt(j) != str[i+k].charAt(j)) {
							c = false;
							break;
						}
					}
					if (c) 
						res++;
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
