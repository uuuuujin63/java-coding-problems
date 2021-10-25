import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[] select;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		select = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		choose_team(0, 0);
		System.out.println(res);
	}
	
	public static void choose_team(int cnt, int start) {
		if(cnt == n/2) {
			cal();
			return;
		}
		
		for(int i=start;i<n;i++) {
			select[i]=true;
			choose_team(cnt+1, i+1);
			select[i]=false;
		}
	}
	public static void cal() {
		int s = 0; // 선택된 한팀
		int ns = 0; // 나머지 한팀
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(select[i]&&select[j]) {
					// 선택된 한팀에 속한다면 s에
					s += map[i][j];
					s += map[j][i];
				} else if(!select[i]&&!select[j]) {
					// 나머지 한팀에 둘다 속한다면 ns에
					ns += map[i][j];
					ns += map[j][i];
				}
			}
		}
		res = Math.min(Math.abs(s-ns), res);
		
		if(res == 0) {
			System.out.println(res);
			System.exit(0);
		}
	}
}
