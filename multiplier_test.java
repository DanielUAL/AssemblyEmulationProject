package Assignment4_HumbleALU;
/**
 * Testing class. Without testing, there is no way to know if code is actually working properly in all cases
 * @author dnaja
 *
 */
public class multiplier_test {
/**
 *  This method runs the methods created for testing HumbleALU multiplier method.     
 */
	 public static void runMTests(){
	     HumbleLongWord number1 = new HumbleLongWord();
	     HumbleLongWord number2 = new HumbleLongWord();
	 
	     number1.set(35);
	     number2.set(12);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 420");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
	     number1.set(12);
	     number2.set(35);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 420");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
	     number1.set(-1);
	     number2.set(5200);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: -5200");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");

	     number1.set(999);
	     number2.set(528);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 527472");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
		 number1.set(0);
	     number2.set(5288868);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 0");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
		 number1.set(-52);
	     number2.set(-42);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 2184");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
		 number1.set(4201);
	     number2.set(133);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 558733");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");
		 
		 number1.set(15);
	     number2.set(1074);
	     System.out.println(" " + number1.getSigned());
	     System.out.println("*" + number2.getSigned());
	     System.out.println("Expected value: 16110");
		 System.out.println("Product: " + HumbleALU.multiply(number1, number2).getSigned());
		 System.out.println(" ");

	}
}
