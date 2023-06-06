package Assignment6_ICSI404;
/**
 * Testing class. Without testing, there is no way to know if code is actually working properly in all cases
 * @author dnaja
 *
 */
public class longword_test {
    public static void main(String[] args) {
        runLTests();

    }

/**
 * This method runs the methods created for testing HumbleLongWord methods. 
 */
    public static void runLTests(){
        HumbleLongWord test = new HumbleLongWord();
        HumbleLongWord testlongword = new HumbleLongWord();
        HumbleLongWord otherlongword = new HumbleLongWord();
        
System.out.println("------------------------------------------------Get + Set Tests-----------------------------------");
  		getBitTest(test);
  		setBitTest(2,test);
  		SetLongTest();
System.out.println("------------------------------------------------AND Testing-----------------------------------");
  		ANDlongwordTest(testlongword, otherlongword);
System.out.println("------------------------------------------------OR Testing-----------------------------------");
  		ORlongwordTest(testlongword, otherlongword);
System.out.println("------------------------------------------------XOR Testing-----------------------------------");
  		XORlongwordTest(testlongword, otherlongword);
System.out.println("------------------------------------------------NOT Testing-----------------------------------");
		NOTlongwordTest();
System.out.println("------------------------------------------------RightShift Tests-----------------------------------");
		RightShiftTest();
System.out.println("------------------------------------------------LeftShift Tests-----------------------------------");
		LeftShiftTest();
System.out.println("------------------------------------------------Unsigned Tests-----------------------------------");
  		getUnsignedTest();
System.out.println("------------------------------------------------Signed Tests-----------------------------------");
		getSignedTest();
System.out.println("------------------------------------------------Copy Test-----------------------------------");
		copyTest();  
System.out.println("------------------------------------------------Twos Compliment Test-----------------------------------");
		twosTest();
    }
    
 /**
  * Gets the value of a bit, this value can only be true or false, since it returns a bit value,
  * which is a boolean. True prints 1, false prints 0.
  * @param test 
  */
    public static void getBitTest (HumbleLongWord test){

        try {
            test.setBit(4, new HumbleBit(true));
            test.getBit(4);
            System.out.println("Expected value is a 1. ");
            System.out.println("getBit is being tested: " + test.getBit(4));
        }
        catch(ArrayIndexOutOfBoundsException E){
            System.out.print("^ error in getBit");
        }
    }

/**
 * Needed to set specific value in the array to a true or a false. Helpful for testing   
 * @param i takes in the index, that will be set to the given false or true value
 * @param test holds the truth value
 */
    public static void setBitTest (int i,HumbleLongWord test) {

        test.setBit(i, new HumbleBit(true));
        System.out.println("Expected value is a 1 at the 5th and 3rd index. ");
        System.out.println("setBit is being tested: " + test);
    }

/**
 * This method has two basic long arrays. These long arrays are able to test for each of the
 * 4 difference cases AND could have.    
 */
    public static void ANDlongwordTest(HumbleLongWord testlongword, HumbleLongWord otherlongword) {

        testlongword.setBit(3, new HumbleBit(true));
        testlongword.setBit(2, new HumbleBit(true));
        otherlongword.setBit(3, new HumbleBit(true));
        otherlongword.setBit(1, new HumbleBit(true));
        
        System.out.println("1st longword  " + testlongword);
        System.out.println("2nd longword  " + otherlongword);
        System.out.println("Expected value is 1000, as last 4 bit.");
        System.out.println("AND result is " + testlongword.ANDlongword(otherlongword));
    }

/**
  * This method has two basic long arrays. These long arrays are able to test for each of the
  * 4 difference cases OR could have.    
  */
     public static void ORlongwordTest(HumbleLongWord testlongword, HumbleLongWord otherlongword) {
      
         System.out.println("1st longword  " + testlongword);
         System.out.println("2nd longword  " + otherlongword);
         System.out.println("Expected value is 1110, as last 4 bit.");
         System.out.println("OR result is  " + testlongword.ORlongword(otherlongword));
        }    
    
/**
 * This method has two basic long arrays. These long arrays are able to test for each of the
 * 4 difference cases XOR could have.    
 */
    public static void XORlongwordTest(HumbleLongWord testlongword, HumbleLongWord otherlongword) {
      	 
         System.out.println("1st longword  " + testlongword);
         System.out.println("2nd longword  " + otherlongword);
         System.out.println("Expected value is 0110, as last 4 bit.");
         System.out.println("XOR result is " + testlongword.XORlongword(otherlongword));
        }   
/**
 * NOT will give the inverse value of every bit in the 32 bit array.     
 */
    public static void NOTlongwordTest() {
        HumbleLongWord testlongword = new HumbleLongWord();
    	
    	testlongword.setBit(15, new HumbleBit(true));
        testlongword.setBit(14, new HumbleBit(true));
        testlongword.setBit(13, new HumbleBit(true));
        testlongword.setBit(3, new HumbleBit(true));
        testlongword.setBit(2, new HumbleBit(true));
        testlongword.setBit(1, new HumbleBit(true));
 
        System.out.println("The longword    " + testlongword);
        System.out.println("Expected value: 11111111111111110001111111110001");
        System.out.println("NOT result is   " + testlongword.NOTlongword());  
    }
    
/**
 * Shifts entire array by however many spaces to the right specified   
 */
    public static void RightShiftTest(){
        HumbleLongWord RightShiftlong = new HumbleLongWord();

        RightShiftlong.setBit(6, new HumbleBit(true));
        RightShiftlong.setBit(3, new HumbleBit(true));
        RightShiftlong.setBit(2, new HumbleBit(true));

        System.out.println("Original longword is " + RightShiftlong);
        System.out.println("Expected value is 1001 as last 4 bits");
        System.out.println("RightShift by 3      " + RightShiftlong.RightShift(3));
        System.out.println(" ");
        
        System.out.println("Original longword is " + RightShiftlong);
        System.out.println("Default value of negative input is 32 0s");
        RightShiftlong = RightShiftlong.RightShift(-1);
        System.out.println("RightShift by -1     " + RightShiftlong.RightShift(-1));
        System.out.println(" ");

        RightShiftlong = RightShiftlong.NOTlongword();
        System.out.println("Original longword is " + RightShiftlong);
        System.out.println("Expected value is left half as 0s, right half as 1s");
        System.out.println("RightShift by 16      " + RightShiftlong.RightShift(16));        
    }
    
/**
 * Shifts entire array by however many spaces to the left specified   
 */
    public static void LeftShiftTest(){
        HumbleLongWord LeftShiftlong = new HumbleLongWord();

        LeftShiftlong.setBit(6, new HumbleBit(true));
        LeftShiftlong.setBit(3, new HumbleBit(true));
        LeftShiftlong.setBit(2, new HumbleBit(true));

        System.out.println("Original longword is " + LeftShiftlong);
        System.out.println("Expected value is ");
        System.out.println("LeftShift by 3      " + LeftShiftlong.LeftShift(3));
        System.out.println(" ");
        
        System.out.println("Original longword is " + LeftShiftlong);
        System.out.println("Expected value is 32 0s");
        LeftShiftlong = LeftShiftlong.LeftShift(1000);
        System.out.println("LeftShift by 1000     " + LeftShiftlong.LeftShift(-1));
        System.out.println(" ");

        LeftShiftlong = LeftShiftlong.NOTlongword();
        System.out.println("Original longword is " + LeftShiftlong);
        System.out.println("Expected value is left 10 as 1s, right 22 as 0s");
        System.out.println("LeftShift by 22      " + LeftShiftlong.LeftShift(22));
    }
    
/**
 * This function converts from binary to decimal assuming every bit is positive.
 */
    public static void getUnsignedTest() {
        HumbleLongWord UnSignedLong = new HumbleLongWord();

        UnSignedLong.setBit(24, new HumbleBit(true));
        UnSignedLong.setBit(31, new HumbleBit(true));
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 2164260864");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());
        System.out.println(" ");
        
        UnSignedLong = new HumbleLongWord();
        UnSignedLong = UnSignedLong.NOTlongword();
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 4294967295");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());
        System.out.println(" ");
        
        UnSignedLong = UnSignedLong.LeftShift(16);
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 4294901760");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());
        System.out.println(" ");
        
        UnSignedLong = UnSignedLong.RightShift(28);
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 15");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());
        System.out.println(" ");
        
        UnSignedLong.setBit(7, new HumbleBit(true));
        UnSignedLong.setBit(11, new HumbleBit(true));
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 2191");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());
        System.out.println(" ");
        
        UnSignedLong.setBit(31, new HumbleBit(true));
        System.out.println("Longword " + UnSignedLong);
        System.out.println("Expected result is 2147485839");
        System.out.println("Unsigned Result:   " + UnSignedLong.getUnsigned());       
    }

/**
 * This function converts from binary to decimal assuming only the first bit, the largest bit, can be negative
 */
    public static void getSignedTest() {
    	   HumbleLongWord SignedLong = new HumbleLongWord();

    	   SignedLong.setBit(24, new HumbleBit(true));
    	   SignedLong.setBit(31, new HumbleBit(true));
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is -2130706432");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());
           System.out.println(" ");
           
           SignedLong = new HumbleLongWord();
           SignedLong = SignedLong.NOTlongword();
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is -1");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());
           System.out.println(" ");
           
           SignedLong = SignedLong.LeftShift(16);
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is -65536");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());
           System.out.println(" ");
           
           SignedLong = SignedLong.RightShift(28);
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is 15");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());
           System.out.println(" ");
           
           SignedLong.setBit(7, new HumbleBit(true));
           SignedLong.setBit(11, new HumbleBit(true));
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is 2191");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());
           System.out.println(" ");
           
           SignedLong.setBit(31, new HumbleBit(true));
           System.out.println("Longword " + SignedLong);
           System.out.println("Expected result is -2147481457");
           System.out.println("Unsigned Result:   " + SignedLong.getSigned());        
    }

 /**
  * Creates an Original longword, then Copies the contents into the other longword   
  */
    public static void copyTest() {
    		HumbleLongWord OriginalLong = new HumbleLongWord();
    		HumbleLongWord CopyLong = new HumbleLongWord();
    		
    		OriginalLong.setBit(1, new HumbleBit(true));
    		OriginalLong.setBit(7, new HumbleBit(true));
    		OriginalLong.setBit(8, new HumbleBit(true));
    		OriginalLong.setBit(9, new HumbleBit(true));
    		OriginalLong.setBit(15, new HumbleBit(true));
    		OriginalLong.setBit(16, new HumbleBit(true));

    		System.out.println("Original before copy  " + OriginalLong);
    		System.out.println("Otherlong before copy " + CopyLong);

    		CopyLong.copy(OriginalLong);
    		
    		System.out.println("Original after copy  " + OriginalLong);
    		System.out.println("Expected aesult is : 00000000000000011000001110000010");
    		System.out.println("Otherlong after copy " + CopyLong); 		
    }

/**
 *  Allows for user to input decimal, to create a new longword   
 */
    public static void SetLongTest() {
        HumbleLongWord SETTER = new HumbleLongWord();
        SETTER.set(-1);
        System.out.println("Expected Value is all ones");
        System.out.println("Set longword is being tested:" + SETTER);
    }
    
/**
 *  This code tests to see if applying TwosCompliment works. Which allows for negative
 *  numbers in binary.    
 */
    public static void twosTest() {
    	HumbleLongWord twos = new HumbleLongWord();
    	twos.setBit(0, new HumbleBit(true));
    	System.out.println("Before TwosCompliment: 1 in binary: " + twos);
    	twos.twoscompliment();
        System.out.println("Expected Value is all ones");
    	System.out.println("After TwosCompliment: -1 in binary: " + twos);
    	
    }
    
}