import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer to = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(to.nextToken());
		int num = Integer.parseInt(to.nextToken());
		
		StringTokenizer line = new StringTokenizer(br.readLine());
		int arr[] = new int[count];
		
		for(int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(line.nextToken());
		}
		
		for(int i=0; i<count; i++) {
			if (arr[i]<num){
				System.out.print(arr[i]+" ");
			}
		}
	}
}
