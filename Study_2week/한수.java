import java.io.*;
import java.util.*;


class Main {
	static int n;
	static int cnt;
	static int[] save;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		if(n<100) {
			System.out.println(n);
			System.exit(0);
		}else if(n==1000) {
			System.out.println("144");
			System.exit(0);
		}
		cnt = 99;
		save = new int[n+1];
		sub_num(100);
		System.out.println(save[n]);
	}
	public static void sub_num(int now_num) {
		if(now_num>n) {
			return;
		}
		if(save[now_num]!=0) sub_num(now_num+1);
		else {
			String tmp = Integer.toString(now_num);
			int a = tmp.charAt(0)-'0';
			int b = tmp.charAt(1)-'0';
			int c = tmp.charAt(2)-'0';
			if(a-b == b-c) {
				cnt++;
			}
			save[now_num] = cnt;
			sub_num(now_num+1);
		}
	}
}
