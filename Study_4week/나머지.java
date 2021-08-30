import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			int a = Integer.parseInt(br.readLine());
			if(!list.contains(a%42)) {
				list.add(a%42);
			}
		}
		System.out.println(list.size());
	}

}
