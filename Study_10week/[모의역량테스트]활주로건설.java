
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= t; tt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0;
			
			for (int i = 0; i < n; i++) {
				// 행 검사
				boolean c = true;
				boolean[] b = new boolean[n];
				//경사로가 지어져있는지 확인
				
				outer:for(int j=1;j<n;j++) {
					if(map[i][j]==map[i][j-1]) continue;
					//같으면 다음칸 비교
					
					if(Math.abs(map[i][j]-map[i][j-1])>=2) {
						c = false;
						break outer;
					}
					// 2 이상 차이가 나면 무조건 불가능하므로 검사를 종료한다.
					
					if(map[i][j]-map[i][j-1]==1) {
						//오르막길
						for(int k=2;k<=x;k++) {
							if(j-k<0||map[i][j-k+1]!=map[i][j-k]||b[j-k]) {
								// k의 길이만큼 평평하지 않으면 불가능
								c = false;
								break outer;
							}
						}
						if(c) { // 경사로 표시해주기
							for(int k=1;k<=x;k++) {
								b[j-k] = true;
							}
						}
					}else {
						//내리막길
						for(int k=1;k<x;k++) {
							if(j+k>=n||map[i][j+k-1]!=map[i][j+k]||b[j+k]) {
								// k의 길이만큼 평평하지 않으면 불가능
								c = false;
								break outer;
							}
						}
						if(c) { // 경사로 표시해주기
							for(int k=0;k<x;k++) {
								b[j+k] = true;
							}
						}
					}
				}
				if(c) {
//					System.out.println("행:"+i);
					res++;
				}
			}
			
			for (int j=0;j<n;j++) {
				// 열 검사
				boolean c = true;
				boolean[] b = new boolean[n];
				outer:for(int i=1;i<n;i++) {
					if(map[i][j]==map[i-1][j]) continue;
					//같으면 다음칸 비교
					
					if(Math.abs(map[i][j]-map[i-1][j])>=2) {
						c = false;
						break outer;
					}
					// 2 이상 차이가 나면 무조건 불가능하므로 검사를 종료한다.
					
					if(map[i][j]-map[i-1][j]==1) {
						//오르막길
						for(int k=2;k<=x;k++) {
							if(i-k<0||map[i-k+1][j]!=map[i-k][j]||b[i-k]) {
								// k의 길이만큼 평평하지 않으면 불가능
//								System.out.println("열"+j+" 아웃1");
								c = false;
								break outer;
							}
						}
						if(c) { // 경사로 표시해주기
							for(int k=1;k<=x;k++) {
								b[i-k] = true;
							}
						}
					}else {
						//내리막길
						for(int k=1;k<x;k++) {
							if(i+k>=n||map[i+k-1][j]!=map[i+k][j]||b[i+k]) {
								// k의 길이만큼 평평하지 않으면 불가능
								c = false;
								break outer;
							}
						}
						if(c) { // 경사로 표시해주기
							for(int k=0;k<x;k++) {
								b[i+k] = true;
							}
						}
					}
				}
				if(c) {
//					System.out.println("열:"+j);
					res++;
				}
			}
			sb.append("#").append(tt).append(" ").append(res).append("\n");
		}
		System.out.println(sb);

	}
}
