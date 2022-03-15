// 3.11 시험. 긴 사다리 게임

class UserSolution {
	TreeSet<Node>[] info;
	// [가로] - 세로

	public void init() {
		info = new TreeSet[101];
		for (int i = 0; i < 101; i++) {
			info[i] = new TreeSet<Node>();
		}

	}

	public void add(int mX, int mY) {
		info[mX].add(new Node(mX + 1, mY));
		info[mX + 1].add(new Node(mX, mY));
		// 양방향 연결
	}

	public void remove(int mX, int mY) {
		info[mX].remove(new Node(mX + 1, mY));
		info[mX + 1].remove(new Node(mX, mY));
	}

	public int numberOfCross(int mID) {
		int nowx = mID;
		int nowy = 0;
		int res = 0;

		if (info[mID].size() == 0)
			return 0;

		while (nowy < 1000000000) {
			Node n = info[nowx].higher(new Node(nowx, nowy));
			// 현재 좌표와 가장 가까운 아래에 있는 가로줄 좌표 찾기
			if (n == null)
				break;
			nowx = n.nextX;
			nowy = n.y;
			res++;
		}
//		System.out.println(res);
		return res;
	}

	public int participant(int mX, int mY) {
		int nowx = mX;
		int nowy = mY;

		while (nowy >= 0) {
			Node n = info[nowx].lower(new Node(nowx, nowy));
			// 현재 좌표와 가장 가까운 위에 있는 가로줄 좌표 찾기
			if (n == null)
				break;
			nowx = n.nextX;
			nowy = n.y;
		}
//		System.out.println(nowx);
		return nowx;
	}
}

class Node implements Comparable<Node> {
	int nextX, y;

	public Node(int nextX, int y) {
		super();
		this.nextX = nextX;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		return this.y - o.y;
	}

}
