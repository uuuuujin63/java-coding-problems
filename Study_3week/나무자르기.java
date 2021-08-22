import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static long res = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //나무의 수
		int m = Integer.parseInt(st.nextToken()); //나무의 길이
		
		long[] tree = new long[n];
		
		long start = 0;
		long end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(tree[i], end); // 제일 높은 나무 높이를 end에 넣기
		}
		
		
		while(start<=end) {
			long mid = (start+end)/2; //자르는 나무 높이
			long sum=0;
			for(int i=0;i<n;i++) {
				if(tree[i]<mid) continue; //mid보다 작은 나무는 자를 수 없으니 패스
				sum += (tree[i]-mid); //mid 보다 크면 자른 조각을 sum에 더함.
			}
			if(sum>=m) { //적어도 m높이의 나무가 모였으면
				res = Math.max(res, mid);
				start = mid+1; //높이를 더 높여서 구해본다.
			}else {
				end = mid-1;
			}
		}
		System.out.println(res);
	}
	
}
