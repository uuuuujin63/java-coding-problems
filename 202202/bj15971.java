// 두 로봇

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n;
	static List<node>[] g;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;
        
        // 노드 연결관계를 담을 리스트
        g = new ArrayList[n];
        
        for (int i=0;i<n;i++) {
        	g[i] = new ArrayList<node>();
        }
        
        for (int i=0;i<n-1;i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            g[x].add(new node(y, w));
            g[y].add(new node(x, w));
            // 양방향으로 넣어준다.
        }
                
        bfs(a, b);
    }
    
    // 다익스트라를 사용해 두 정점 사이의 최솟값을 구하고 가장 큰 값을 빼준다.
    public static void bfs(int a, int b) {
    	Queue<node> q = new LinkedList<node>();
    	boolean[] v = new boolean[n];
    	v[a] = true;
    	q.add(new node(a, 0, 0));
    	
    	while(!q.isEmpty()) {
    		node now = q.poll();
    		
    		// 도착했다면 최대값 빼줌
    		if(now.x == b) {
    			System.out.println(now.w-now.max);
    			break;
    		}
    		
    		for(node next : g[now.x]) {
    			if(!v[next.x]) {
    				v[next.x] = true;
    				q.add(new node(next.x, now.w+next.w, Math.max(now.max, next.w)));
    			}
    		}
    	}
    	
    }
}

class node{
	int x, w, max;

	public node(int x, int w) {
		super();
		this.x = x;
		this.w = w;
	}

	public node(int x, int w, int max) {
		super();
		this.x = x;
		this.w = w;
		this.max = max;
	}
	
	
	
}
