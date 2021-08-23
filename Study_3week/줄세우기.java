import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer> line = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		line.add(a, 1);
		for(int i=1;i<n;i++) {
			a = Integer.parseInt(st.nextToken());
			line.add(i-a, i+1);
		}
		for(int i=0;i<n;i++) {
			System.out.print(line.get(i)+" ");
		}
	}

	
}
