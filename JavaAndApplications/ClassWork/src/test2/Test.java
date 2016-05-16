package test2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EngStudent a = new EngStudent("John", 50, 45);
		EngStudent b = new EngStudent("Matt", 45, 45);
		
		a.setScore(a.getMath(),a.getEng());
		b.setScore(b.getMath(),b.getEng());
		
		b.compareScore(a);
	}

}
