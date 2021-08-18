import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Time[] room = new Time[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			room[i] = new Time(a, b);
		}
		Arrays.sort(room);
		
		int res = 1;
		int tmp = room[0].end;
		for(int i=1;i<n;i++) {
			if(tmp <= room[i].start) {
				res+=1;
				tmp = room[i].end;
			}
		}
		System.out.println(res);
		
	}
}
class Time implements Comparable<Time>{
	int start;
	int end;
	
	public Time(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if(this.end - o.end > 0 || this.end - o.end < 0){
			return this.end - o.end; //양수면 바뀜 오름차순.
		}
		else {
			return this.start - o.start;
		}
		// TODO Auto-generated method stub
	}
	
	
}
