import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res=0;
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		for(int i=0;i<n;i++) {
			stack[i] = Integer.parseInt(br.readLine());
		}
		int max = stack[n-1];
		for(int i=n-2;i>=0;i--) {
			if(stack[i]>max) {
				max = stack[i];
				res ++ ;
			}
		}
		System.out.println(res+1);
	}
}
