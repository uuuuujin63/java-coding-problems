import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][1001];
		int max_x = 0;
		int max_y = 0;
		for(int t=1;t<=n;t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			max_x = Math.max(max_x, x+w);
			max_y = Math.max(max_y, y+h); 
			//이따가 1001칸 다 돌기 싫으니까 색종이 있는 부분만 돌자 !
			
			
			for(int i=y;i<y+h;i++) {
				for(int j=x;j<x+w;j++) {
					arr[i][j] = t;
					//t로 하면 이후단계에서 색종이가 덮히면서 가려지는 부분을 알아서 없앨 수 있다.
				}
			}
		}
		for(int t=1;t<=n;t++) {
			int cnt = 0;
			for(int i=0;i<max_y;i++	) {
				for(int j=0;j<max_x;j++) {
					if(t == arr[i][j]) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
