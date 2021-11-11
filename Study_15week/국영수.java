import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<student> q = new PriorityQueue<student>();

		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			q.add(new student(kor, eng, mat, name));
		}
		while(!q.isEmpty()) {
			student tmp = q.poll();
			sb.append(tmp.name).append("\n");
		}
		System.out.println(sb);
	}
}
class student implements Comparable<student>{
	int kor, eng, mat;
	String name;
	@Override
	public int compareTo(student o) {
		if(this.kor == o.kor) {
			// 국어점수가 같으면
			if(this.eng == o.eng) {
				// 영어점수도 같으면
				if(this.mat==o.mat) {
					// 모든 점수가 같으면
					
					return this.name.compareTo(o.name);
				}
				// 수학점수가 감소하는 순서로
				return o.mat-this.mat;
			}
			
			
			// 영어 점수가 증가하는 순서로
			return this.eng-o.eng;
		}
		// 국어 점수가 감소하는 순서로
		return o.kor-this.kor;
	}
	public student(int kor, int eng, int mat, String name) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.name = name;
	}
	
}

