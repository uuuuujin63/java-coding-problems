
import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			char[] line = br.readLine().toCharArray();
			int n = line.length;
			if (n == 1 && line[0] == '.')
				break;
			Stack<Character> stack = new Stack<>();

			int flg = 1;
			for (int i = 0; i < n; i++) {
				if (line[i] == '(' || line[i] == '[') {
					stack.push(line[i]);
				} else if (line[i] == ']' || line[i] == ')') {
					if (stack.empty()) {
						flg = 0;
						break;
					}
					char pop_stack = stack.pop();
					if (line[i] == ']' && pop_stack!='[') {
						flg = 0;
						break;
					} else if (line[i] == ')' && pop_stack!='(') {
						flg = 0;
						break;
					}
				}
			}
			if (stack.empty() && flg == 1)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.println(sb);
	}
}
