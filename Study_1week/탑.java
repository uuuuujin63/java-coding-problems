import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idx = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		stack.push(Integer.parseInt(st.nextToken()));
		idx.push(1);
		sb.append("0");
		for (int i = 1; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			while(true) {
				if (!stack.empty()) {
					if (stack.peek() >= tmp) {
						sb.append(" "+idx.peek());
						stack.push(tmp);
						idx.push(i + 1);
						break;
					} else {
						stack.pop();
						idx.pop();
					}
				}else {
					sb.append(" 0");
					stack.push(tmp);
					idx.push(i+1);
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
