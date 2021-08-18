import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int m,a;
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };
	static int[] moving_a;
	static int[] moving_b;
	static ArrayList<BC> ap; //bc 정보

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			int res = 0;

			moving_a = new int[m];
			moving_b = new int[m];
			
			XY A = new XY(0, 0);
			XY B = new XY(9, 9);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moving_a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moving_b[i] = Integer.parseInt(st.nextToken());
			}
			
			ap = new ArrayList<>();
			for (int i = 0; i < a; i++) {
				
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap.add(new BC(x,y, c,p));
			}
			
			res += find_maxsum(A, B);
			for(int i=0;i<m;i++) {
				A.x = A.x+dx[moving_a[i]];
				A.y = A.y+dy[moving_a[i]];
				B.x = B.x+dx[moving_b[i]];
				B.y = B.y+dy[moving_b[i]];
				res += find_maxsum(A, B);
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	
	public static int find_maxsum(XY aa, XY bb) {
		int[][] sum_info = new int[2][a]; //각각 bc에 대한 합계 구하기 0:a 1:b
		for(int i=0;i<a;i++) {
			
			if((Math.abs(ap.get(i).x-aa.x)+Math.abs(ap.get(i).y-aa.y))<=ap.get(i).c) {
				sum_info[0][i] = ap.get(i).p;
			}
			
			if((Math.abs(ap.get(i).x-bb.x)+Math.abs(ap.get(i).y-bb.y))<=ap.get(i).c) {
				sum_info[1][i] = ap.get(i).p;
			}
		}
		int max = 0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				int now_sum = 0;
				if(i==j&&sum_info[0][i]==sum_info[1][j]) { //같은 bc 사용 시 하나만 해준다.
					now_sum = sum_info[0][i];
				}
				else {
					now_sum = sum_info[0][i]+sum_info[1][j];
				}
				max = Math.max(max, now_sum);
			}
		}
		return max;
	}
}
class BC {
	int x;
	int y;
	int c;
	int p;

	BC(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}


class XY {
	int x;
	int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
