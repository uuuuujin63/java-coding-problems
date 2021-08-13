
import java.io.*;
import java.util.*;



class Main {
	static int n;
	static int[] num;
	static boolean[] v;
	static int[] lotto_list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			
			num = new int[n];
			v = new boolean[n];
			lotto_list = new int[6];
			for(int i=0;i<n;i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			select_num(0, 0);
			System.out.println();
		}
	}
	public static void select_num(int start, int select_cnt) {
		if(select_cnt == 6) {
			for(int j=0;j<6;j++) {
				System.out.print(lotto_list[j]+" ");
			}
			System.out.println();
			return;
		}
		if(start == n) return;
		for(int i=start; i<n;i++) {
			lotto_list[select_cnt] = num[i];
			select_num(i+1, select_cnt+1);
		}
	}
}
