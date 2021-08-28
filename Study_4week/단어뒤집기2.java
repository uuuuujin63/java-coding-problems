import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int n = s.length();
		Stack<Character> stack = new Stack<>();
		
		int now = 0;
		while(true) {
			//출력되는 뭉탱이의 끝 두가지 : <와 공백
			if(s.charAt(now)=='<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				} //스택에 있던 걸 다 넣어준다.
				
				while(true) {
					sb.append(s.charAt(now));
					now++;
					if(s.charAt(now)=='>') {
						sb.append(s.charAt(now));
						now++;
						break;
						//만약 >가 나오면 sb에 추가하고 반복문 종료
					}
				}
			}
			else if(s.charAt(now)==' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				} //스택에 있던 걸 다 넣어준다.
				sb.append(' ');
				now++;
			}else {
				stack.add(s.charAt(now));
				now++;
			}
			if(now==n) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				} //스택에 있던 걸 다 넣어준다.
				break;
			}
		}
		System.out.println(sb);
	}

}
