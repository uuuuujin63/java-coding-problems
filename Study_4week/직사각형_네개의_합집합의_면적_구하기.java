import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[100][100];
		int cnt = 0;
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
					if(map[i][j]!=0) continue;
					map[i][j] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
