import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		// h : 세로
		int w = Integer.parseInt(st.nextToken());
		// w : 가로
		
		int[] info = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			info[i]= Integer.parseInt(st.nextToken());
		}
		
		int wall = info[0];
		int wall_idx = 0;
		int res = 0;
		
		for(int i=1;i<w;i++	) {
			int left = 0;
			int right = 0;
			for(int j=i-1;j>=0;j--) {
				left = Math.max(left, info[j]);
			}
			// 왼쪽 큰 벽 찾기
			
			for(int j=i+1;j<w;j++) {
				right = Math.max(right, info[j]);
			}
			// 오른쪽 큰 벽 찾기
			
			if(left<info[i]||right<info[i]) continue;
			// 양쪽 하나라도 현재 위치보다 작은 곳이 있다면 물을 채울 수 없음
			
			res += Math.min(left, right)-info[i];
		}
		System.out.println(res);
	}
}


