// 뉴스피드

class UserSolution {
	PriorityQueue<News>[] pq = new PriorityQueue[10];
	HashMap<Integer, Integer> user = new HashMap<>();
	// 유저번호, 유저관심분야
	HashMap<Integer, News> news = new HashMap<>();
	// 기사번호, 기사정보
	void init() {
		for(int i=0;i<10;i++) {
			pq[i] = new PriorityQueue<News>();
		}
		user.clear();
		news.clear();
	}

	void addNews(int mSection, int mNewsId) {
		// 기사정보에 기사 추가
		News n = new News(mSection, 0, mNewsId);
		news.put(mNewsId, n);
		
		// 관심분야 pq에 기사 추가
		pq[mSection].add(n);
	}

	void eraseNews(int mNewsId) {
		News n = news.get(mNewsId);
		pq[n.section].remove(n);
	}

	void readNews(int mUserId, int mNewsId) {
		// 조회수 +1
		News n = news.get(mNewsId);
		pq[n.section].remove(n);
		n.cnt ++ ;
		pq[n.section].add(n);
		
		// 유저의 관심분야 바꾸기
		user.put(mUserId, news.get(mNewsId).section);
	}

	void changeSection(int mNewsId, int mSection) {
		// 기존 관심분야목록에서 삭제
		News n = news.get(mNewsId);
		pq[n.section].remove(n);
		
		// 관심분야 수정
		n.section = mSection;
		
		// 다시 넣기
		pq[n.section].add(n);

	}

	int getList(int mUserId, int mList[]) {
		int size = 0;
		int userSection = user.get(mUserId)==null? -1:user.get(mUserId);
		PriorityQueue<News> res = new PriorityQueue<>();
		for(int i=0;i<10;i++) {
			PriorityQueue<News> tmp = new PriorityQueue<>();
			int n = pq[i].size()>10 ? 10:pq[i].size();
			for(int j=0;j<n;j++) {
				// 각 섹션별 최대 10개씩 뽑는다.
				News ne = pq[i].poll();
				if(i == userSection) {
					// 관심분야면 +10
					res.add(new News(ne.cnt+10, ne.newsId));
				}else {
					res.add(new News(ne.cnt, ne.newsId));
				}
				tmp.add(ne);
			}
			while(!tmp.isEmpty()) {
				pq[i].add(tmp.poll());
			}
		}
		
		while(!res.isEmpty()) {
			mList[size++] = res.poll().newsId;
			if(size==10) break;
		}
		
		return size;
	}

	class News implements Comparable<News> {
		int section, cnt, newsId;

		public News(int section, int cnt, int newsId) {
			super();
			this.section = section;
			this.cnt = cnt;
			this.newsId = newsId;
		}
		
		
		public News(int cnt, int newsId) {
			super();
			this.cnt = cnt;
			this.newsId = newsId;
		}


		@Override
		public String toString() {
			return "News [section=" + section + ", cnt=" + cnt + ", newsId=" + newsId + "]";
		}

		@Override
		public int compareTo(News o) {
			if (o.cnt == this.cnt) {
				return o.newsId - this.newsId;
			}
			return o.cnt - this.cnt;
		}

	}
}
