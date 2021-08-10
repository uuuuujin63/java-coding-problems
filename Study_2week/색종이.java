import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		for(int t=0;t<n;t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(i<=100&&j<=100&&paper[i][j]==0) {
						paper[i][j] = 1;
						res ++;
					}
				}
			}
		}
		System.out.println(res);
	}

}
