//이분탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] home = new int[n];
		for(int i=0;i<n;i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home); //오름차순 정렬
		
		int start = 1; //시작점
		int end = home[n-1]-home[0]; //공유기의 최대거리
		int res = 0;
		while(start<=end) {
			int cnt = 1;
			int mid = (start+end)/2;
			int now = home[0]+mid; //첫번째 공유기 설치+거리
			for(int i=0;i<n;i++) {
				if(now<=home[i]) { //만약에 인접한 공유기와 mid 이상의 차이가 나면
					now = home[i]+mid;
					cnt ++; //공유기 설치 !
				}
			}
			boolean flg = cnt>=c? true: false;
			if(flg) {//c이상 설치가 가능할 때 mid값 들 중 최댓값을 구하자!
				res = Math.max(res, mid);
				//최댓값을 찾는 것이므로
				start = mid+1;
			}else {//공유기 너무 적게 설치 ㅠ 간격을 줄이자.
				end = mid-1;
			}
		}
		System.out.println(res);
	}
	
}
