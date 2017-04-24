package btvn_09;

public class MyApp {
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1";
		
		MyBigNumber number1 = new MyBigNumber(s1);
		MyBigNumber number2 = new MyBigNumber(s2);
		System.out.println(number1);
		System.out.println(number2);
//		number1.print();
//		number2.print();
		MyBigNumber result = number1.multiple(number2);
		System.out.println("Ket qua la:");
		System.out.println(result);
		//
//		result.print();
//		System.out.println(result);
		
//		new MyBigNumber("1234");
//		new MyBigNumber("234");
//		new MyBigNumber("23");
//		new MyBigNumber("2");
	}
}
