package access1;

public class Number {
		//1) default 멤버
		int dnum; 
		void dmethod() {
			System.out.println(pnum);
		} 
		
		//2) private 멤버
		private int pnum; 
		private void pmethod() {
			System.out.println(pnum);
			//private 변수는 같은 클래스내의 메소드에서만 사용한다
		}
		
		//3) public 멤버
		public int pubNum;
		public void pubMethod() {}
		
		//4) protected 멤버
		protected int proNum;
		protected void proMethod() {}
		
		
		
		//멤버에 접근하기 위한 getter, setter
		public int getDnum() {
			return dnum;
		}
		public int getPnum() {
			return pnum;
		}
		public void setPnum(int pnum) {
			this.pnum = pnum;
		}
		public int getPubNum() {
			return pubNum;
		}
		public void setPubNum(int pubNum) {
			this.pubNum = pubNum;
		}
		public void setDnum(int dnum) {
			this.dnum = dnum;
		}
		public int getProNum() {
			return proNum;
		}
		public void setProNum(int proNum) {
			this.proNum = proNum;
		}
		
}
