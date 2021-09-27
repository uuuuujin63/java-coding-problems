import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		//숫자를 영어로 바꾼 것을 미리 배열에 담아둠
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		//한 줄 읽어오기
		int m = Integer.parseInt(st.nextToken());
		//공백을 기준으로 구분해서 하나씩 가져와 정수로 변환 : m과 n
		int n = Integer.parseInt(st.nextToken());
		
		//우선순위큐를 사용함으로써 자동정렬
		PriorityQueue<Comp> q = new PriorityQueue<>();
		
		//m부터 n까지 반복
		for(int i=m;i<=n;i++) {
			String s="";
			if(i<10) { //숫자를 영어로 변환하는 작업
				s = num[i];
			}else {
				s += num[i/10];
				s += " "; //10 이상이면 가운데에 공백을 포함시켜준다.
				s += num[i%10];
			}
			q.add(new Comp(s, i)); //큐에 담는다.
		}
		int cnt =0;// cnt : 한줄에 10개씩 출력하기 위한 변수
		while(!q.isEmpty()) { //큐가 비면 멈추도록 한다.
			Comp c = q.poll(); //큐에서 하나씩 뺀다.
			cnt++;
			//넣을 때는 영어, 숫자 둘 다 넣어주지만 출력할 때는 숫자만 출력해주면 된다.
			//정렬은 이미 영어순(사전순)으로 되어있다.
			sb.append(c.n).append(" ");
			if(cnt%10==0) { 
				sb.append("\n");
			}
		}
		System.out.println(sb); //마지막으로 출력해준다.
	}


}

class Comp implements Comparable<Comp>{ //comparable을 implements 해줌으로써 내가 원하는 방식으로 정렬할 수 있도록 한다.
	String s;
	int n;
	public Comp(String s, int n) {
		super();
		this.s = s;
		this.n = n;
	}
	@Override
	public int compareTo(Comp o) {
		//string만 가지고 사전순 정렬
		return s.compareTo(o.s);
	}
	
}
