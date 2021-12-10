import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] info = new long[n];
		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<n;i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(info); // 오름차순으로 정렬하기
		
		int left = 0;
		int right = n-1; // 정답이 될 두 용액의 인덱스
		long res = Math.abs(info[left]+info[right]);
		// 왼쪽것과 오른쪽거 하나하나씩 가르키면서 특성값을 구한다.
		int now_left = left;
		int now_right = right; // 그때그때 변경해가면서 비교할 두 용액의 인덱스
		while(now_left<now_right) {
			long check = info[now_right]+info[now_left];
			// 현재 두 포인터의 특성값
			
			if(Math.abs(check)<res) {
				// 현재 두 포인터의 특성값이 저장되어있는 특성값보다 작다면 정답이 될 두 용액의 인덱스를 이것으로 바꿔준다.
				left = now_left;
				right = now_right;
				res = Math.abs(check);
				if(res == 0) { 
					// 0이면 더이상 구할필요 없으므로 종료
					break;
				}
			}
			if(check>0) {
				// 0보다 크므로 right 포인터가 가리키는 값을 좀 더 작은 숫자로 바꾸기 위해 인덱스 -1
				now_right -= 1;
			}else {
				now_left +=1;
			}
			//System.out.println(now_left + " "+now_right+" "+res);
		}
		System.out.println(info[left]+" "+info[right]);
	}
}
