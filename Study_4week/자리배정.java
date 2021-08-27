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
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); //가로, 열
		int n = Integer.parseInt(st.nextToken()); //세로, 행
		int k = Integer.parseInt(br.readLine());
		if(k==1) { //첫번째 관객일 경우
			System.out.println("1 1");
			System.exit(0);
		}
		if(m*n<k) { //배정할 수 없는 경우
			System.out.println("0");
			System.exit(0);
		}
		int[][] arr = new int[n][m];
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0;
		int y = 0;
		int cnt = 1;
		arr[x][y] = 1;
		outer: while(true) {
			for(int i=0;i<4;i++) {
				while(true) {
					x = x+dx[i];
					y = y+dy[i];
					if(0>x||n<=x||0>y||m<=y) {
						x = x-dx[i];
						y = y-dy[i];
						break;
					}
					if(arr[x][y]!=0) {
						x = x-dx[i];
						y = y-dy[i];
						break;
					}
					arr[x][y] = ++cnt;
					
					if(cnt==k) {
						System.out.println((y+1)+" "+(x+1));
						break outer;
					}
				}
			}
		}
	}
}
