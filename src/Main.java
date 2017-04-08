
public class Main {

	
	public void testMultipleTryCatch() {
		
		try {
			System.out.println("throwing illegal argument exception");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegalArgumentException" ); e.printStackTrace();
		}
		
		System.out.println("printing this after exception");
	}
	
	public void test() {
		System.out.println("hello there");
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.testMultipleTryCatch();
		m.test();
	}
	
}
