// 검색의 효율 -> hashMap 사용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	private static BufferedReader br;
	private static final UserSolution userSolution = new UserSolution();

	private final static int MAX_N = 10;
	private final static int MAX_LEN = 11;

	private final static int CMD_INIT = 100;
	private final static int CMD_JOIN = 200;
	private final static int CMD_SELECT_WORD = 300;
	private final static int CMD_FIND_WINNERS = 400;

	private static int N = 0, M = 0;
	private static char[] mWord = new char[MAX_LEN];

	private static int mstrcmp(char[] mWord, String ans_word) {
		int l = 0;
		while (l < ans_word.length() && mWord[l] == ans_word.charAt(l)) {
			l++;
		}
		if (l == ans_word.length()) {
			return mWord[l];
		}
		return mWord[l] - ans_word.charAt(l);
	}

	private static boolean run() throws Exception {
		StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");
		int query_cnt = Integer.parseInt(stdin.nextToken());
		boolean ok = true;

		for (int q = 0; q < query_cnt; q++) {
			stdin = new StringTokenizer(br.readLine(), " ");
			int query = Integer.parseInt(stdin.nextToken());

			switch (query) {
			case CMD_INIT:
				N = Integer.parseInt(stdin.nextToken());
				M = Integer.parseInt(stdin.nextToken());
				userSolution.init(N, M);
				break;
			case CMD_JOIN:
				int mID;
				char[][][] mBingo = new char[MAX_N][MAX_N][];
				mID = Integer.parseInt(stdin.nextToken());
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						String w = stdin.nextToken();
						mBingo[y][x] = new char[MAX_LEN];
						w.getChars(0, w.length(), mBingo[y][x], 0);
					}
				}
				userSolution.join(mID, mBingo);
				break;
			case CMD_SELECT_WORD:
				int mRound = Integer.parseInt(stdin.nextToken());
				String ans_word;
				userSolution.selectWord(mRound, mWord);
				ans_word = stdin.nextToken();
				if (mstrcmp(mWord, ans_word) != 0) {
					ok = false;
				}
				break;
			case CMD_FIND_WINNERS:
				int ret_total, ans_total;
				ret_total = userSolution.findWinners();
				ans_total = Integer.parseInt(stdin.nextToken());
				if (ret_total != ans_total) {
					ok = false;
				}
				break;
			}
		}
		return ok;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");

		int T, MARK;
		T = Integer.parseInt(stinit.nextToken());
		MARK = Integer.parseInt(stinit.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int score = run() ? MARK : 0;
			System.out.printf("#%d %d\n", tc, score);
		}

		br.close();
	}
}

class UserSolution {
	static int[][] garo_cnt; // m명의 참가자의 n개의 가로 줄 erased cnt
	static int[][] sero_cnt;
	static int[] right_cnt;
	static int[] left_cnt;
	static int N, M, nowRound;
	static HashMap<String, Word>[] user;

	void init(int N, int M) {
		this.N = N;
		this.M = M;
		nowRound = 0;

		garo_cnt = new int[M + 1][N];
		sero_cnt = new int[M + 1][N];
		right_cnt = new int[M + 1];
		left_cnt = new int[M + 1];
		user = new HashMap[M + 1];

		for (int i = 0; i <= M; i++) {
			user[i] = new HashMap<String, Word>();
		}
	}

	void join(int mID, char[][][] mBingo) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String str = "";
				for (int k = 0; k < 10; k++) {
					if (mBingo[i][j][k] == '\0')
						break;
					str += mBingo[i][j][k];
				}
				int d_cnt = 0;
				if (i == j)
					d_cnt++; // \대각선
				if (N - 1 - i == j)
					d_cnt++; // /대각선
				user[mID].put(str, new Word(str, i, j, d_cnt));
			}
		}
	}

	String playround(int mRound) {
		PriorityQueue<Word> pq = new PriorityQueue<>();
		int playUser = mRound % M == 0 ? M : mRound % M;

		for (Word w : user[playUser].values()) {
			pq.add(w);
		}

		Word w = pq.poll();
		String word = w.word;

		// 빙고세기
		garo_cnt[playUser][w.x]++;
		sero_cnt[playUser][w.y]++;
		if (w.x == w.y)
			left_cnt[playUser]++;
		if (N - 1 - w.x == w.y)
			right_cnt[playUser]++;

		// 해당 빙고판 삭제
		user[playUser].remove(word);

		for (Word ww : user[playUser].values()) {
			if (ww.x == w.x) {
				ww.e_garo_cnt++;
			}else if(ww.y==w.y) {
				ww.e_sero_cnt++;
			} else if (w.x == w.y && ww.x == ww.y)
				ww.e_left_cnt++;
			else if (N - 1 - w.x == w.y && N - 1 - ww.x == ww.y)
				ww.e_right++;

			user[playUser].put(ww.word, ww);
		}

		// 나머지 유저들도 해당 단어가 있으면 삭제
		for (int i = 1; i <= M; i++) {
			if (user[i].containsKey(word)) {
				w = user[i].get(word);
				garo_cnt[i][w.x]++;
				sero_cnt[i][w.y]++;
				if (w.x == w.y)
					left_cnt[i]++;
				if (N - 1 - w.x == w.y)
					right_cnt[i]++;

				user[i].remove(word);

				for (Word ww : user[i].values()) {
					if (ww.x == w.x) {
						ww.e_garo_cnt++;
						
					}else if(ww.y==w.y) {
						ww.e_sero_cnt++;
					} else if (w.x == w.y && ww.x == ww.y)
						ww.e_left_cnt++;
					else if (N - 1 - w.x == w.y && N - 1 - ww.x == ww.y)
						ww.e_right++;
					
					user[i].put(ww.word, ww);
				}

			}
		}

		return word;
	}

	void selectWord(int mRound, char[] mWord) {
		for (int i = nowRound + 1; i < mRound; i++) {
			playround(i);
		}
		String word = playround(mRound);
		for (int i = 0; i < word.length(); i++) {
			mWord[i] = word.charAt(i);
		}
		mWord[word.length()] = '\0';
		nowRound = mRound;
//		System.out.println(word);
	}

	int findWinners() {
		int res = 0;
		int[] bingo_cnt = new int[M + 1];
		int max_cnt = 0;
		// 라운드 돌리면서 우승자 판별
		while (true) {
			boolean tc = false;
			for (int i = 1; i <= M; i++) {
				for (int j = 0; j < N; j++) {
					if (garo_cnt[i][j] == N) {
						tc = true;
						bingo_cnt[i]++;
					}
					if (sero_cnt[i][j] == N) {
						tc = true;
						bingo_cnt[i]++;
					}
				}
				if (left_cnt[i] == N) {
					tc = true;
					bingo_cnt[i]++;
				}
				if (right_cnt[i] == N) {
					tc = true;
					bingo_cnt[i]++;
				}
				max_cnt = max_cnt >= bingo_cnt[i] ? max_cnt : bingo_cnt[i];
			}
			// 현재 라운드에서 빙고가 나온 참가자가 나왔으면 종료.
			if (tc) {
				break;
			}
			// 아니라면 게임 이어서하기
			playround(++nowRound);
		}

		for (int i = 1; i < M + 1; i++) {
			if (max_cnt == bingo_cnt[i]) {
				res += i;
			}
		}
//		System.out.println(res);
		return res;
	}
}

class Word implements Comparable<Word> {
	String word;
	int x, y;
	int d_cnt; // 대각선의 갯수
	int e_garo_cnt, e_sero_cnt, e_left_cnt, e_right; // 같은 라인에서 지워진 빙고칸 갯수

	public Word(String word, int x, int y, int d_cnt) {
		super();
		this.word = word;
		this.x = x;
		this.y = y;
		this.d_cnt = d_cnt;
		this.e_garo_cnt = 0;
		this.e_sero_cnt = 0;
		this.e_left_cnt = 0;
		this.e_right = 0;
	}

	@Override
	public int compareTo(Word o) {
		int this_e_cnt = Math.max(this.e_garo_cnt, this.e_sero_cnt) > Math.max(this.e_left_cnt, this.e_right) ? Math.max(this.e_garo_cnt, this.e_sero_cnt) : Math.max(this.e_left_cnt, this.e_right);
		int o_e_cnt = Math.max(o.e_garo_cnt, o.e_sero_cnt) > Math.max(o.e_left_cnt, o.e_right) ? Math.max(o.e_garo_cnt, o.e_sero_cnt) : Math.max(o.e_left_cnt, o.e_right);
		if (o_e_cnt == this_e_cnt) {
			if (o.d_cnt == this.d_cnt) {
				if (this.x == o.x)
					return this.y - o.y; // x 좌표로 오름차순
				return this.x - o.x; // y좌표로 오름차순
			}
			return o.d_cnt - this.d_cnt; // 대각선의 개수로 내림차순
		}
		return o_e_cnt - this_e_cnt; // 지워진 단어로 내림차순
	}

}
