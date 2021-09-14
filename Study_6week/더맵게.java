import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
      int answer = 0;
        PriorityQueue<Integer> s = new PriorityQueue<>();
        int n = scoville.length;
        
        for(int i=0;i<n;i++) {
        	s.add(scoville[i]);
        }
        if(s.peek()>=K) return 0;
        
        boolean c = false;
        while(true) {
        	int n1 = s.poll();
        	int n2 = s.poll();
        	int k = n1+n2*2;
        	s.add(k);
        	answer ++;
        	if(s.peek()>=K) {
        		c = true;
        		break;
        	}
        	if(s.size()==1) {
        		c = s.peek()>=K ? true:false;
        		break;
        	}
        }
        answer = c == true ? answer:-1;
        return answer;
    }
}
