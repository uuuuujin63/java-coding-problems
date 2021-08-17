import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import jdk.internal.dynalink.linker.LinkerServices.Implementation;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Temp[] arr = new Temp[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Temp(a, b);
		}

		Arrays.sort(arr);
		Temp tmp = arr[0];
		int res = 1;
		
		for(int i=1;i<n;i++	) {
			if(tmp.high<arr[i].low) {
				tmp = arr[i];
				res++;
			}
		}
		System.out.println(res);
	}

}

class Temp implements Comparable<Temp> {
	int low;
	int high;

	public Temp(int low, int high) {
		this.low = low;
		this.high = high;
	}

	@Override
	public int compareTo(Temp o) {
		// TODO Auto-generated method stub
		return this.high - o.high; // 오름차순 정렬
	}

}
