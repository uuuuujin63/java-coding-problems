import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] wheels = new String[4];
		for(int i=0;i<4;i++) {
			wheels[i] = br.readLine();
		}
		int k = Integer.parseInt(br.readLine());
		for(int t=0;t<k;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			// n : 톱니바퀴의 번호
			int d = Integer.parseInt(st.nextToken());
			// d : 1->시계방향, -1->반시계방향
			int tmpd = d; // tmpd : 인접 톱니 회전 시 사용할 방향 변수
			
			int status6 = Integer.parseInt(wheels[n].substring(6,7));
			// 오른쪽으로 회전을 먼저 시킬것이기 때문에 n번째 톱니바퀴의 6
			
			// n 을 기준으로 오른쪽에 존재하는 톱니바퀴 회전
			for(int i=n;i<4;i++) {
				// 회전하기 전,  2번 자리에 뭐가 오는지 체크 (다르면 다음톱니도 돌려줘야하기 때문)
				int status = Integer.parseInt(wheels[i].substring(2, 3));
				// 2번 톱니바퀴는 오른쪽 톱니들에 영향을 줌
				if(tmpd==-1) {
					// 반시계방향으로 회전 (왼쪽)
					wheels[i] = (wheels[i].substring(1, 8)+wheels[i].substring(0, 1));
				}else {
					// 시계방향으로 회전 (오른쪽)
					wheels[i] = (wheels[i].substring(7, 8)+wheels[i].substring(0, 7));
				}
				
				// 뒤에 있는 톱니 바퀴도 확인하기
				if(i+1<4&&status == Integer.parseInt(wheels[i+1].substring(6, 7))) {
					// 다음바퀴의 6번자리 톱니와 이전바퀴의 2번 자리 톱니의 상태가 같다면 더 이상 회전이 불가능하므로 종료
					break;
				}
				tmpd *= -1;
			}
			
			tmpd = d*-1;
			if(n-1>=0&&status6!=Integer.parseInt(wheels[n-1].substring(2, 3))) {
				// n의 6번 톱니바퀴와 n-1번의 2번 톱니바퀴의 상태가 같지 않다면 왼쪽방향도 회전을 시켜줘야 함.
				for(int i=n-1;i>=0;i--) {
					// n번째 톱니는 이미 회전되었기 때문에 이전에 저장해놓은 status6 변수 값을 사용함.
					int status = Integer.parseInt(wheels[i].substring(6, 7));
					// 2번 톱니바퀴는 오른쪽 톱니들에 영향을 줌
					if(tmpd==-1) {
						// 반시계방향으로 회전 (왼쪽)
						wheels[i] = (wheels[i].substring(1, 8)+wheels[i].substring(0, 1));
					}else {
						// 시계방향으로 회전 (오른쪽)
						wheels[i] = (wheels[i].substring(7, 8)+wheels[i].substring(0, 7));
					}
					
					if(i-1>=0&&status == Integer.parseInt(wheels[i-1].substring(2, 3))) {
						break;
					}
					tmpd *= -1;
				}
			}
		}
		int sum = 0;
		int score = 1;
		for(int i=0;i<4;i++) {
			sum += score*(wheels[i].charAt(0)-'0');
			score *= 2;
		}
		System.out.println(sum);
	}
}
