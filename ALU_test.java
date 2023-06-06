package Assignment4_HumbleALU;

public class ALU_test {

	public static void main(String[] args) {
		 longword_test LongTest = new longword_test(); 
	     bit_test BitTest = new bit_test(); 
	     rippleAdder_test AdderTest = new rippleAdder_test();
	     multiplier_test MultiplierTest = new multiplier_test();
	     
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Bit Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	       BitTest.runTests();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Longword Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	       LongTest.runLTests();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RippleAdder Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		   AdderTest.runRTests();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Multiply Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
	   	   MultiplierTest.runMTests();
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ALU Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
	       runALUTests();   
	}

	 public static void runALUTests(){
		 HumbleLongWord number1 = new HumbleLongWord();
		 HumbleLongWord number2 = new HumbleLongWord();
		
		 HumbleBit[] operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(false) ,new HumbleBit(false) ,new HumbleBit(true)}; //1000
		 number1.set(15);
		 number2.set(7); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("AND Operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(false) ,new HumbleBit(false) ,new HumbleBit(true)}; //1001
		 number1.set(15);
		 number2.set(7); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("OR operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(true) ,new HumbleBit(false) ,new HumbleBit(true)}; //1010
		 number1.set(15);
		 number2.set(7); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("XOR operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		
		 operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(false) ,new HumbleBit(true)}; //1011
		 number1.set(15);
		 number2.set(7); 
		 System.out.println(number1);
		 System.out.println("Expected value: ");
		 System.out.println("NOT operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(false) ,new HumbleBit(true) ,new HumbleBit(true)}; //1100
		 number1.set(88888888);
		 number2.set(4); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("Left Shift operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(false) ,new HumbleBit(true) ,new HumbleBit(true)}; //1101
		 number1.set(88888888);
		 number2.set(4); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("Right Shift operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(false),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(true)}; //1110
		 number1.set(15);
		 number2.set(4); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("Add operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(true)}; //1110
		 number1.set(15);
		 number2.set(4); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("Subtract operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
		 
		 operation = new HumbleBit[] {new HumbleBit(true),new HumbleBit(true) ,new HumbleBit(true) ,new HumbleBit(false)}; //0111
		 number1.set(15);
		 number2.set(4); 
		 System.out.println(number1);
		 System.out.println(number2);
		 System.out.println("Expected value: ");
		 System.out.println("Multiplier operator: " + HumbleALU.doOp(operation, number1, number2));
		 System.out.println(" ");
	 }
}