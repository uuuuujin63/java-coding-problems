import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		outer:while(true) {
			List<String> orders = new LinkedList<String>();
			while(true) {
				String order = br.readLine();
				if(order.equals("QUIT")) {
					break outer;
				}
				if(order.equals("END")) {
					break;
				}
				else {
					orders.add(order);
				}
			}
			
			int orders_n = orders.size();
			int n = Integer.parseInt(br.readLine());
			for(int t=0;t<n;t++) {
				Long num = Long.parseLong(br.readLine());
				List<Long> stack = new LinkedList<Long>();
				stack.add(num);
				boolean c = true;
				for(int i=0;i<orders_n;i++) {
					// 프로그램 시작
					st = new StringTokenizer(orders.get(i));
					String order = st.nextToken();
					if(order.equals("NUM")) {
						Long x = Long.parseLong(st.nextToken());
						stack.add(x);
					}else if(order.equals("POP")) {
						if(stack.size()<1) {
							c = false;
							break;
						}
						stack.remove(stack.size()-1);
					}else if(order.equals("INV")) {
						if(stack.size()<1) {
							c = false;
							break;
						}
						Long nownum = stack.get(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(nownum*(-1));
					}else if(order.equals("DUP")) {
						if(stack.size()<1) {
							c = false;
							break;
						}
						Long nownum = stack.get(stack.size()-1);
						stack.add(nownum);
					}else if(order.equals("SWP")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						Long firstnum = stack.get(stack.size()-1);
						Long secnum = stack.get(stack.size()-2);
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(firstnum);
						stack.add(secnum);
					}else if(order.equals("ADD")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						long firstnum = stack.get(stack.size()-1);
						long secnum = stack.get(stack.size()-2);
						if(Math.abs(secnum+firstnum) > 1000000000) {
							c = false;
							break;
						}
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(firstnum+secnum);
					}else if(order.equals("SUB")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						long firstnum = stack.get(stack.size()-1);
						long secnum = stack.get(stack.size()-2);
						if(Math.abs(secnum-firstnum) > 1000000000) {
							c = false;
							break;
						}
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(secnum-firstnum);
					}else if(order.equals("MUL")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						long firstnum = stack.get(stack.size()-1);
						long secnum = stack.get(stack.size()-2);
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						if(Math.abs(secnum*firstnum) > 1000000000) {
							c = false;
							break;
						}
						stack.add(secnum*firstnum);
					}else if(order.equals("DIV")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						Long firstnum = stack.get(stack.size()-1);
						Long secnum = stack.get(stack.size()-2);
						if(firstnum == 0) {
							c = false;
							break;
						}
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(secnum/firstnum);
					}else if(order.equals("MOD")) {
						if(stack.size()<2) {
							c = false;
							break;
						}
						Long firstnum = stack.get(stack.size()-1);
						Long secnum = stack.get(stack.size()-2);
						if(firstnum == 0) {
							c = false;
							break;
						}
						stack.remove(stack.size()-1);
						stack.remove(stack.size()-1);
						stack.add(secnum%firstnum);
					}
				}
				if(stack.size()>1 || stack.size()==0 ) c = false;
				if(!c) {
					sb.append("ERROR").append("\n");
				}else {
					sb.append(stack.get(0)).append("\n");
				}
			}
			st = new StringTokenizer(br.readLine());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
