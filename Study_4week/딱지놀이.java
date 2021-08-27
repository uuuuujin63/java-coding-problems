import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		outer : for (int nn = 0; nn < n; nn++) {
			st = new StringTokenizer(br.readLine());
			int a_n = Integer.parseInt(st.nextToken());
			Integer[] a = new Integer[a_n];
			for (int i = 0; i < a_n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int b_n = Integer.parseInt(st.nextToken());
			Integer[] b = new Integer[b_n];
			for (int i = 0; i < b_n; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a, (i1, i2) -> i2 - i1);
			Arrays.sort(b, (i1, i2) -> i2 - i1);
			// 내림차순 정렬
			int a_cnt = 0;
			int b_cnt = 0;
			for (int i = 4; i >= 1; i--) {
				while (true) {
					if(a_cnt==a_n||b_cnt==b_n) {
						if(a_n==b_n) {
							System.out.println("D");
							continue outer;
						}else {
							char I = a_n>b_n?'A':'B';
							System.out.println(I);
							continue outer;
						}
					}
					if(i==a[a_cnt]&&a[a_cnt]==b[b_cnt]) {
						a_cnt++;
						b_cnt++;
						continue;
					}
					if(i!=a[a_cnt]&&i==b[b_cnt]) {
						System.out.println("B");
						continue outer;
					}
					if(i==a[a_cnt]&&i!=b[b_cnt]) {
						System.out.println("A");
						continue outer;
					}
					if(i!=a[a_cnt]&&i!=b[b_cnt]) {
						//둘 다 다음 것을 비교해야할 떄
						break;
					}
				}
			}
		}
	}

}
