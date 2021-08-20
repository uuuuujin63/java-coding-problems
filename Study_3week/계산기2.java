import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Integer> stack = new Stack<>();
			int i=0;
			while (i<n) { //곱하기 계산
				if(s.charAt(i)=='*') {
					stack.push(stack.pop()*(s.charAt(i+1)-'0'));
					i = i+2;
				}
				else {
					stack.push(s.charAt(i++)-'0');
				}
//				for(int j=0;j<stack.size();j++) {
//					System.out.print(stack.get(j));
//				}
//				System.out.println();
			}
			int tmp = stack.pop();
			while(!stack.isEmpty()) { //더하기 계산
				if(stack.peek()==('+'-'0')) {
					stack.pop();
					stack.push(stack.pop()+tmp);
				}else {
					tmp = stack.pop();
				}
				if(stack.size() == 1) break;
			}
			
			sb.append("#").append(t).append(" ").append(stack.pop()).append("\n");
		}
		System.out.println(sb);
	}

}
