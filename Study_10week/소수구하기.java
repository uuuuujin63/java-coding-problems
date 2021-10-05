import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		for (int i = m; i <= n; i++) {
			if(i==1) continue;
			if(i==2) {
				sb.append("2").append("\n");
				continue;
			}
			boolean c = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					c = false;
					break;
				}
			}
			if (c) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
	}
}
