import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int real_n = 0;
		int real_cnt = 0;
		int fake_n = 0;
		int fake_cnt = 0;
		
		int l = Integer.parseInt(br.readLine());
		//롤케이크의 길이
		int n = Integer.parseInt(br.readLine());
		//방청객의 수
		int[] roll = new int[l];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;
			if(fake_cnt<(k-p)) {
				fake_cnt = k-p;
				fake_n = i;
			}
			//가장 많은 조각을 받도록 예상되는 방청객
			
			int cnt = 0;
			for(int j=p;j<=k;j++) {
				if(roll[j]==0) {
					roll[j]=i;
					cnt++;
				}
			}
			if(cnt>real_cnt) {
				real_n = i;
				real_cnt = cnt;
			}
		}
		System.out.println(fake_n);
		System.out.println(real_n);
	}

}
