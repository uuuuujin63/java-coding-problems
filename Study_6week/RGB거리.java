import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+r;
			//지금의 R을 선택하는 경우의 수. i-1번째에 g, b를 선택한 값 중 최솟값에 현재 거리값을 더해주면 된다.
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+g;
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+b;
		}
		System.out.println(Math.min(dp[n][0],Math.min(dp[n][1], dp[n][2])));
		//n까지 왔을 때, 마지막에 선택한 색 중 최솟값 프린트 하면 됨.
	}

}
