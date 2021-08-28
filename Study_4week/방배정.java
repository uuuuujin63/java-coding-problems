import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] s = new int[6][2]; //학생. 1학년부터 6학년까지 0:여자 1:남자
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int res = 0;
		
		for(int t=0;t<n;t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			if(s[b][a]==0) { //처음으로 방이 정해질 때
				res++;
				s[b][a]++;
			}else if(s[b][a]==k) { //방이 꽉찼을 때 새로 만들어준다.
				res++;
				s[b][a]=1;
			}else {
				s[b][a]++;
			}
		}
		System.out.println(res);
	}

}
