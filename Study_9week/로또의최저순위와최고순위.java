class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       int correct_cnt = 0;
        int zero_cnt = 0;
		for(int l:lottos) {
			if(l==0) { // 0이면 1등 번호와 같을 수 없으므로 0의 개수를 카운트하는 변수를 +1 해주고 컨티뉴
				zero_cnt++;
				continue;
			}
        	for(int w:win_nums) {
        		if(l==w) {
        			correct_cnt++;
        			break;
        		}
        	}
        }
		
		int[] result = {6, 6, 5, 4, 3, 2, 1};
		// 맞춘 번호가 0개 1개 일때는 6등, 2개: 5등.. 등등
		// 맞춘 번호를 인덱스, 등수를 값으로 초기화
		
		int[] answer = {result[correct_cnt+zero_cnt], result[correct_cnt]};
		
        return answer;
    }
}
