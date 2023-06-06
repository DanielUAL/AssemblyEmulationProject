/**
 * Testing class. Without testing, there is no way to know if code is actually working properly in all cases. 
 * @author dnaja
 *
 */
public class bit_test {

/**
 * Runs runTests(). A main is being used for ease of testing additional sections of code.
 * @param args
 */
	public static void main(String[] args) {
       runTests();
	}	

	/**
	 * This method runs the methods created for testing TheHumbleBit methods. Instanced of TheHumbleBit, test, bit1, and bit2 
	 * were used as parameters in calls to the methods created. 
	 */
	public static void runTests() { 
		HumbleBit test = new HumbleBit();
		HumbleBit Bit1 = new HumbleBit();
	     HumbleBit Bit2 = new HumbleBit();

	    System.out.println("------------------------------------------------First Part of Testing-----------------------------------");
	       setvalueTestParam(test);
	       setValueTest(test);
	       toggleTest(test);
	       System.out.println("Expected result is true");
	       getValueTest(test);
	       clearTest(test);
	       System.out.println("Expected result is false");
	       getValueTest(test);

	        System.out.println("------------------------------------------------Second Part of Testing-----------------------------------");
	        ANDtest(Bit1,Bit2);
	        
	        System.out.println("------------------------------------------------Third Part of Testing-----------------------------------");
	        ORtest(Bit1,Bit2);
	        
	        System.out.println("------------------------------------------------Fourth Part of Testing-----------------------------------");
	        XORtest(Bit1,Bit2);

	        System.out.println("------------------------------------------------Fifth Part of Testing-----------------------------------");
	        NOTtest(Bit1);
	       
	}

	/**
	 * Tests to see if manually adding a parameter inside the setValue() method
	 * will print out the expected result.
	 * @param test, creates instance of the boolvalue from TheHumbleBit class, allows
	 * for the testing of the simple methods.
	 */
	public static void setvalueTestParam(HumbleBit test) {		
		test.setValue(true);
		System.out.println("Expected result is true");
		System.out.println("setValue(true) is being tested: " + test);
		test.setValue(false);
		System.out.println("Expected result is false");
		System.out.println("setValue(false) is being tested: " + test);
   }
	
	/**
	 * Tests to see if the overloaded setValue works. If no parameters are added, it will print true,
	 * and if the boolvalue is already true, it will stay true.
	 * @param test, creates instance of the boolvalue from TheHumbleBit class, allows
	 * for the testing of the simple methods.
	 */
	public static void setValueTest(HumbleBit test){
		test.setValue();
		System.out.println("Expected result is true");
	  	System.out.println("setValue is being tested: " + test);
	  	test.setValue();
	  	System.out.println("Expected result is true");
    	System.out.println("setValue is being tested: " + test);
	}
	
	/**
	 * Makes use of the toggle, which will change the true to false, then true to false.
	 * @param test, creates instance of the boolvalue from TheHumbleBit class, allows
	 * for the testing of the simple methods.
	 */
	public static void toggleTest(HumbleBit test) {
		test.toggle();
		System.out.println("Expected result is false");
	    System.out.println("toggle is being tested: " + test);

	    test.toggle();
	    System.out.println("Expected result is true");
	    System.out.println("toggle is being tested: " + test);
	}
	
	/**
	 * Gets current value of test, will not change value.
	 * @param test, creates instance of the boolvalue from TheHumbleBit class, allows
	 * for the testing of the simple methods. 
	 */
	public static void getValueTest(HumbleBit test) {
		test.getValue();
	    System.out.println("getValue is being tested: " + test);
	        
	}
	
	/**
	 * Tests to see if clear works. When test has a value it will lose it, printing a false result.
	 * THe value will stay false after repeat use of the clear method.
	 * @param test, creates instance of the boolvalue from TheHumbleBit class, allows
	 * for the testing of the simple methods.
	 */
	public static void clearTest(HumbleBit test) {
		test.clear();
		System.out.println("Expected result is false");
        System.out.println("clear is being tested: " + test);
        
        test.clear();
        System.out.println("Expected result is false");
        System.out.println("clear is being tested: " + test);
	}
	
	/**
	 * This method has two different Bits being compared. So there are 4 possible outcomes
	 * relying on the true or false value of each Bit. This test should havae 3 falses, and 
	 * 1 true when both Bits are true. 
	 * @param Bit1,Bit2 This method compares two bits, so there needs to be two different instances
	 * of TheHumbleBit so that all cases can be tested.
	 */
	public static void ANDtest(HumbleBit Bit1, HumbleBit Bit2) {
		    System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is false");
	        System.out.println("AND is being tested: " + Bit1.AND(Bit2));

	        Bit1.toggle();     
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is false");
	        System.out.println("AND is being tested: " + Bit1.AND(Bit2));
	        
	        Bit1.toggle();
	        Bit2.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is false");
	        System.out.println("AND is being tested: " + Bit1.AND(Bit2));

	        Bit1.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is true");
	        System.out.println("AND is being tested: " + Bit1.AND(Bit2));
	}
	
	/**
	 * This method has two different Bits being compared. So there are 4 possible outcomes
	 * relying on the true or false value of each Bit. This test should havae 3 trues, and 
	 * 1 false when both Bits are false. 
	 * @param Bit1,Bit2 This method compares two bits, so there needs to be two different instances
	 * of TheHumbleBit so that all cases can be tested.
	 */
	public static void ORtest(HumbleBit Bit1, HumbleBit Bit2) {
		 Bit1.toggle();
	        Bit2.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is false");
	        System.out.println("OR is being tested: " + Bit1.OR(Bit2));
	        
	        Bit1.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is true");
	        System.out.println("OR is being tested: " + Bit1.OR(Bit2));
	        
	        Bit1.toggle();
	        Bit2.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is true");
	        System.out.println("OR is being tested: " + Bit1.OR(Bit2));

	        Bit1.toggle();
	        System.out.println("Bit1 : " + Bit1);
	        System.out.println("Bit2 : " + Bit2);
	        System.out.println("Expected result is true");
	        System.out.println("OR is being tested: " + Bit1.OR(Bit2));
	}
	
	/**
	 * This method has two different Bits being compared. So there are 4 possible outcomes
	 * relying on the true or false value of each Bit. This test should have 2 falses when the Bits
	 * are the same value, and 2 trues when they are different. 
	 * 1 true when both Bits are true. 
	 * @param Bit1,Bit2 This method compares two bits, so there needs to be two different instances
	 * of TheHumbleBit so that all cases can be tested.
	 */
	public static void XORtest(HumbleBit Bit1, HumbleBit Bit2) {
        Bit1.toggle();
        Bit2.toggle();
        System.out.println("Bit1 : " + Bit1);
        System.out.println("Bit2 : " + Bit2);
        System.out.println("Expected result is false");
        System.out.println("XOR is being tested: " + Bit1.XOR(Bit2));
        
        Bit1.toggle();
        System.out.println("Bit1 : " + Bit1);
        System.out.println("Bit2 : " + Bit2);
        System.out.println("Expected result is true");
        System.out.println("XOR is being tested: " + Bit1.XOR(Bit2));
        
        Bit1.toggle();
        Bit2.toggle();
        System.out.println("Bit1 : " + Bit1);
        System.out.println("Bit2 : " + Bit2);
        System.out.println("Expected result is true");
        System.out.println("XOR is being tested: " + Bit1.XOR(Bit2));

        Bit1.toggle();
        System.out.println("Bit1 : " + Bit1);
        System.out.println("Bit2 : " + Bit2);
        System.out.println("Expected result is false");
        System.out.println("XOR is being tested: " + Bit1.XOR(Bit2));
	}

	/**
	 * Simple NOT method, it is similar to the getter and toggle. Since it gets a toggled value, but wont change
	 * the value of the Bit itself. 
	 * @param Bit1, This method only checks one Bit's value, then prints true if false, and false if true.
	 */
	public static void NOTtest(HumbleBit Bit1) {
		System.out.println("Bit1 : " + Bit1);
        System.out.println("Expected result is false");
	    System.out.println("NOT Bit1 : " + Bit1.NOT());
	    Bit1.toggle();
	    System.out.println("Bit1 : " + Bit1);
        System.out.println("Expected result is true");
	    System.out.println("NOT Bit1 : " + Bit1.NOT()); 
	}
}
