import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int res, n;
	static int[] order = new int[10];
	static boolean[] v = new boolean[10];
	static int[][] e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		e = new int[n][10];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				e[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order[4] = 1;
		v[1] = true;
		permu(1);
		System.out.println(res);

	}

	public static void permu(int cnt) {
		if (cnt == 10) {
			play_game();
//			System.out.println("점수는 "+res);
			return;
		}
		if(cnt ==4) {
			permu(cnt+1);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (v[i])
				continue;
			v[i] = true;
			order[cnt] = i;
			permu(cnt+1);
			v[i] = false;
		}

	}

	public static void play_game() {
		int score = 0;
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			int out = 0; // 아웃 카운트 변수
			boolean[] ru = new boolean[4];
			// 이닝 반복
			while (out<3) {
				switch (e[i][order[cnt]]) {
				case 1: // 안타
					if (ru[3]) {
						score++;
						ru[3] = false;
					}
					if (ru[2]) {
						ru[3] = true;
						ru[2] = false;
					}
					if (ru[1]) {
						ru[2] = true;
					}
					ru[1] = true;
					break;

				case 2: // 2루타
					if (ru[3]) {
						score++;
						ru[3] = false;
					}
					if (ru[2]) {
						score++;
					}
					if (ru[1]) {
						ru[3] = true;
						ru[1] = false;
					}
					ru[2] = true;
					break;
				case 3: // 3루타
					if (ru[3]) {
						score++;
					}
					if (ru[2]) {
						score++;
						ru[2] = false;
					}
					if (ru[1]) {
						score++;
						ru[1] = false;
					}
					ru[3] = true;
					break;
				case 4: // 홈런
					if (ru[3]) {
						score++;
						ru[3] = false;
					}
					if (ru[2]) {
						score++;
						ru[2] = false;
					}
					if (ru[1]) {
						score++;
						ru[1] = false;
					}
					score++;
					break;
				case 0: // 아웃
					out++;
					break;
				}
				cnt++;
				if(cnt>9) {
					cnt = cnt%9;
				}
			}
		}
		res = Math.max(res, score);
	}
}
