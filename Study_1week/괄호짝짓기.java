import java.io.*;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String open = "([{<";
		String close = ")]}>";
		for(int t=1;t<=10;t++) {
			Stack<Character> stack = new Stack<>();
			int n=Integer.parseInt(br.readLine());
			String tc = br.readLine();
			int flg = 1;
			for(int i=0;i<n;i++) {
				if(tc.charAt(i)=='('||tc.charAt(i)=='<'||tc.charAt(i)=='{'||tc.charAt(i)=='[') {
					stack.push(tc.charAt(i));
				}
				else if(close.contains(Character.toString(tc.charAt(i)))){
					if(stack.empty()) {
						flg = 0;
						break;
					}
					int idx = close.indexOf(Character.toString(tc.charAt(i)));
					char tmp = stack.pop(); //비어있지 않으므로 꺼낼 수 있다.
					if (tmp != open.charAt(idx)) {
						flg = 0;
						break;
					}
				}
			}
			if(!stack.empty())
				flg = 0;
			sb.append("#"+t+" "+flg+"\n");
		}
		System.out.println(sb);
	}

}
