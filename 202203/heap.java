import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br;
    private static UserSolution userSolution = new UserSolution();

    static final int CLEAR = 100;
    static final int PUSH = 200;
    static final int POP = 300;
    static final int TOP = 400;

    private static void String2Char(char[] buf, String str) {
        for (int i = 0; i < str.length(); ++i) {
            buf[i] = str.charAt(i);
        }
        buf[str.length()] = '\0';
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int ret = 0;
        int idx = 0;
        for (int TC = 1; TC <= T; TC++) {
            userSolution.init();
            int score = 100;
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int cmd = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case CLEAR:
                        userSolution.clear();
                        break;
                    case PUSH:
                        idx = Integer.parseInt(st.nextToken());
                        char[] name = new char[11];
                        String2Char(name, st.nextToken());
                        userSolution.push(idx, name);
                        break;
                    case POP:
                        idx = Integer.parseInt(st.nextToken());
                        ret = userSolution.pop();
                        if (ret != idx) {
                            score = 0;
                        }
                        break;
                    case TOP:
                        idx = Integer.parseInt(st.nextToken());
                        ret = userSolution.top();
                        if (ret != idx) {
                            score = 0;
                        }
                        break;
                }
            }
            System.out.println(String.format("#%d %d", TC, score));
        }
    }
}

class UserSolution {
	static data[] heap;
	static int heap_size;
    void init(){
    	heap = new data[1000001];
    	heap_size = 0;
    }

    void clear(){
    	heap_size = 0;
    }

    void push(int idx, char[] name){
    	String sb = "";
    	for(int i=0;i<name.length;i++) {
    		sb += name[i];
    	}
    	heap[++heap_size] = new data(idx, sb);
    	// 맨 끝에 값 추가
    	
    	if(heap_size == 1) {
    		return;
    	}
    	
    	int c = heap_size;
    	
    	while(c>1) {
    		int comp = heap[c].name.compareTo(heap[c/2].name);
    		if(comp > 0) {
    			// 자식이 우선순위가 더 크면
    			data tmp = heap[c];
    			heap[c] = heap[c/2];
    			heap[c/2] = tmp;
    		}
    		else if(comp == 0) {
    			// 자식과 우선순위가 같다면 idx 비교
    			if(heap[c].idx<heap[c/2].idx) {
    				data tmp = heap[c];
        			heap[c] = heap[c/2];
        			heap[c/2] = tmp;
    			}
    		}else break;
    		c /= 2;
    	}
    }

    int pop(){
    	int res = heap[1].idx;
    	heap[1] = heap[heap_size--];
    	int c = 1;
    	
    	while(c*2<= heap_size) {
    		int child;
    		if(c*2 == heap_size) {
    			child = c*2;
    		}else {
    			int comp = heap[c*2].name.compareTo(heap[c*2+1].name);
    			if(comp < 0) {
    				child = c*2+1;
    			}else if(comp > 0) {
    				child = c*2;
    			}else {
    				child = heap[c*2].idx < heap[c*2+1].idx ? c*2 : c*2+1;
    			}
    		}
    		int comp = heap[c].name.compareTo(heap[child].name);
    		// 현재와 자식 비교
    		
    		if(comp > 0 ) break;
    		else if(comp == 0) {
    			if(heap[c].idx < heap[child].idx) break;
    		}
    		data tmp = heap[c];
			heap[c] = heap[child];
			heap[child] = tmp;
			c = child;
    	}
        return res;
    }

    int top() {
        return heap[1].idx;
    }

}

class data {
	int idx;
	String name;
	
	public data(int idx, String name) {
		super();
		this.idx = idx;
		this.name = name;
	}
	
}
