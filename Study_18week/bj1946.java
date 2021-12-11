import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tt=0;tt<t;tt++) {
			int n = Integer.parseInt(br.readLine());
			Score[] score = new Score[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				score[i] = new Score(a, b);
			}
			Arrays.sort(score);
			// 서류심사 성적만 가지고 오름차순으로 정렬
			// 이후에는 면접 성적만 비교해준다.
			
			int res = 1;
			// 서류심사 일등은 무조건 다른 지원자보다 적어도 한개의 시험에서 뒤떨어지지 않으므로 카운트 해주고 i=1 부터 비교해준다.
			
			int max_score = score[0].b;
			// i번째 지원자는 면접 성적의 순위가 0~i-1번째 지원자 중 면접성적 순위가 가장 높은 사람보다 높으면 된다.
			// 즉 앞 지원자들 중에 면접 성적이 가장 우수해야한다.!!!!
			// max_score : 앞 지원자들 중 면접 성적이 가장 우수한 지원자의 성적이 들어갈 변수 
			
			for(int i=1;i<n;i++) {
				if(max_score>score[i].b) {
					// 0~i-1 번째 지원자 중 면접 성적 순위가 가장 높은 사람보다 i번째 지원자의 면접 성적 순위가 높다면
					res++;
					// 선발
					max_score = score[i].b;
					// max_score 갱신
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}

class Score implements Comparable<Score>{
	int a, b;

	public Score(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	// 서류심사 성적만 가지고 오름차순 정렬
	// 이후에는 면접 성적만 비교해주면 되기 때문
	@Override
	public int compareTo(Score o) {
		if(this.a>o.a) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
}
