import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());

		long start = 1;
		long end = k;

		while (start < end) {
			long mid = (start + end) / 2;
			long cnt = 0;

			for (int i = 1; i <= n; i++) {
				cnt += Math.min(mid / i, n);
			}
			if (k <= cnt) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
