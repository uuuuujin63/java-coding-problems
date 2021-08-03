import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int[] dy = {-1, 1};
		int tcxn = 100;
		int tcyn = 100;
		for(int tc=1;tc<=10;tc++) {
			br.readLine();
			char[][] lad = new char[tcxn][tcyn];
			for(int i=0;i<tcxn;i++) {
				lad[i] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			int y = 0;
			for(int i=0;i<tcyn;i++) {
				if(lad[tcxn-1][i]=='2') {
					y = i;
					break;
				}
			}
			for(int i=tcxn-1;i>=0;i--) {
				for(int j=0;j<2;j++) {
					if((0<=y+dy[j]&&y+dy[j]<tcyn)&&lad[i][y+dy[j]]=='1') {
						while((0<=y+dy[j]&&y+dy[j]<tcyn)&&lad[i][y+dy[j]]=='1'){
							y = y+dy[j];
						}
						break;
					}
				}
			}
			sb.append("#"+tc+" "+y+"\n");
		}
		System.out.println(sb);
	}

}
