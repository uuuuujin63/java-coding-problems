import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		if(number<10) {
			number*=10;
		}
		int origin = number;
		int res = 0;
		
		while(true) {
			int tmp = 0;
			int numberright, sumright;
			res ++;
			
			tmp += number%10;
			number /=10;
			numberright = tmp; // 가장 오른쪽 자리 수
			
			while(number!=0) {
				tmp += number%10;
				number = number/10;
			}
			
			sumright = tmp%10;
			
			tmp = numberright*10 + sumright;
			
			if(tmp == origin) {
				break;
			}
			number = tmp;
			//System.out.println(number);
		}
		System.out.println(res);
	}
}


