import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 10;
		for(int tt=1;tt<=t;tt++	) {
			int n = Integer.parseInt(br.readLine());
			int[] info = new int[n];
			// info : 건물의 높이 정보가 들어갈 배열
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				info[i] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			for(int i=2;i<n-2;i++) {
				// 양쪽 2곳은 건물이 지어지지 않으므로 2부터 시작, n-2 종료
				
				int next_h = 0;
				for(int j=1;j<=2;j++) {
					if(info[i]<info[i+j]) {
						// 오른쪽에 있는 이웃한 건물 중 큰 건물이 있다면 이웃건물 높이에 넣고 더 이상 볼 필요 없으므로 종료
						next_h = info[i+j];
						break;
					}
					if(info[i]<info[i-j]) {
						// 왼쪽도 확인
						next_h = info[i-j];
						break;
					}
					// 둘다 높지 않다면 그 중 가장 높은 건물을 넣는다.
					// 현재 건물 높이 - 이웃 건물 중 가장 높은 건물 = 조망권 보장 세대 수
					next_h = Math.max(next_h, info[i+j]);
					next_h = Math.max(next_h, info[i-j]);
				}
				if(info[i]<=next_h) {
					// 이웃 건물의 높이가 같거나 높다면 조망권 보장이 하나도 안되므로 다음 건물 조망권 검사 진행
					continue;
				}
				res += info[i]-next_h;
			}
			sb.append("#").append(tt).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
