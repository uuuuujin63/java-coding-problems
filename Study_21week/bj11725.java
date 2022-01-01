import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] g = new LinkedList[n+1];
        for(int i=0;i<=n;i++) {
        	g[i] = new LinkedList<Integer>();
        }
        
        // 1. 연결하기
        for(int i=0;i<n-1;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	if(!g[a].contains(b)) g[a].add(b);
        	if(!g[b].contains(a)) g[b].add(a);
        }
        
        // 2. 1번 노드에서부터 부모값 구하기
        int[] p = new int[n+1];
        // p : 부모의 정점 값이 들어감
        boolean[] v = new boolean[n+1];
        // v : 양방향 연결해주었기 때문에 방문처리 해주어야 함.
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        v[1] = true; // 방문처리
        while(!q.isEmpty()) {
        	int x = q.poll();
        	for(int now:g[x]) { // x의 자식들 살펴보기
        		if(v[now]) continue; 
        		// 이미 방문했다면 넘어감
        		
        		q.add(now);
        		v[now] = true; // 방문처리
        		p[now] = x; // now의 부모는 x        		
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++) {
        	sb.append(p[i]).append("\n");
        }
        System.out.println(sb);
	}
}
