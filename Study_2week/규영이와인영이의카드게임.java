import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
	static int[] gy = new int[9];
	static int[] iy = new int[9];
	static boolean[] v;
	static int win_cnt, lose_cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				gy[i] = Integer.parseInt(st.nextToken());
			}
			win_cnt = 0;
			lose_cnt = 0;
			v = new boolean[19];
			int cnt = 0;
			for(int i=1;i<=18;i++) { //인영이의 값 넣기
				int num = i;
				if(!IntStream.of(gy).anyMatch(x-> x == num)) {
					iy[cnt++] = num;
				}
			}
			card_game(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(win_cnt).append(" ").append(lose_cnt).append("\n");
			
		}
		System.out.println(sb);
	}
	public static void card_game(int round, int g_sum, int y_sum) {
		if(round == 9) {
			if(g_sum>y_sum) {
				win_cnt++;
			}else if(g_sum<y_sum) {
				lose_cnt++;
			}
			return;
		}
		for(int i=0;i<9;i++) {
			if(!v[i]) {
				v[i] = true;
				if(gy[round]>iy[i]) { //규영이가 이겼으면,
					card_game(round+1, g_sum+gy[round]+iy[i], y_sum);
				}else if(gy[round]<iy[i]) {
					card_game(round+1, g_sum, y_sum+iy[i]+gy[round]);
				}else {
					card_game(round+1, g_sum, y_sum);
				}
				v[i] = false;
			}
		}
	}
}
