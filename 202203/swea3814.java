import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = max < arr[i] ? arr[i] : max;
			}

			int res = 0;

			int start = 0, end = max+1;
			
			outer: while (start < end) {
				int mid = (start + end) / 2;
				int[] tArr = arr.clone(); // 배열의 값을 수정해야하므로 temp배열 생성
				int subCnt = 0; // 뺀 값 넣기
				for (int i = 0; i < n - 1; i++) {
					// 뒤에꺼랑 비교해보기
					int sub = tArr[i + 1] - tArr[i];
					if (mid < sub) {
						// 설정해놓은 차이값 보다 크다면
						tArr[i + 1] -= (sub - mid);
						subCnt += (sub - mid);
					}
					if (subCnt > k) {
						start = mid + 1;
						res = start;
						continue outer;
					}
				}

				for (int i = n - 1; i > 0; i--) {
					// 앞에꺼랑 비교해보기
					int sub = tArr[i - 1] - tArr[i];
					if (mid < sub) {
						// 설정해놓은 차이값 보다 크다면
						tArr[i - 1] -= (sub - mid);
						subCnt += (sub - mid);
					}
					if (subCnt > k) {
						start = mid + 1;
						res = start;
						continue outer;
					}
				}
				end = mid;

			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
