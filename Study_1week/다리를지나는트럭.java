import java.util.*;

class Solution {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer =1;
		Queue<Integer> cross = new LinkedList<Integer>();
		Queue<Integer> pass = new LinkedList<Integer>();
		ArrayList<Integer> time = new ArrayList<Integer>();
		int n= truck_weights.length;
		cross.add(truck_weights[0]);
		time.add(0);
		int nowidx = 0;
		int sum = truck_weights[0];
		while(pass.size()<n) {
			int time_n = time.size();
			for(int i=0;i<time_n;i++) time.set(i, time.get(i)+1);
			answer ++;
			if(time.get(0)==bridge_length) {
				int byetruck = cross.remove();
				pass.add(byetruck);
				time.remove(0);
				sum -= byetruck;
			}
			if(nowidx+1 <n ) {//고려할 트럭이 더 있으면!
				if(sum+truck_weights[nowidx+1]<=weight) {
					cross.add(truck_weights[nowidx+1]);
					time.add(0);
					sum += truck_weights[nowidx+1];
					nowidx += 1;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int b = 100;
		int w = 100;
		int[] t = {10};
		System.out.println(solution(b, w, t));

	}

}
