package Assignment5_ICSI404_Package;
/**
 * Testing class. Without testing, there is no way to know if code is actually working properly in all cases
 * @author dnaja
 *
 */
public class rippleAdder_test {

/**
 *  This method runs the methods created for testing HumbleAdder methods.     
 */
    public static void runRTests(){
System.out.println("------------------------------------------------Add Tests-----------------------------------");
    	AddTest();
System.out.println("------------------------------------------------Subtract Tests-----------------------------------");
		SubtractTest();
    }

/**
 * Adds two longwords    
 */
    public static void AddTest() {
    	HumbleLongWord result = new HumbleLongWord();
    	HumbleLongWord longword1 = new HumbleLongWord();
    	HumbleLongWord longword2 = new HumbleLongWord();
    	
    	longword1.set(28); 
    	longword2.set(21);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: 00000000000000000000000000110001");
    	System.out.println("Result     " + result);
    	System.out.println("");
    	
    	longword1.set(-28); 
    	longword2.set(-21);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: 11111111111111111111111111001111");
    	System.out.println("Result     " + result);
    	System.out.println("");

    	longword1.set(78888); 
    	longword2.set(12599);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: 00000000000000010110010101011111");
    	System.out.println("Result     " + result);
    	System.out.println("");

    	longword1.set(-999999); 
    	longword2.set(1000000);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: 00000000000000000000000000000001");
    	System.out.println("Result     " + result);
    	System.out.println("");

    	longword1.set(9); 
    	longword2.set(10);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: 00000000000000000000000000010011");
    	System.out.println("Result     " + result);
    	System.out.println("");

    	longword1.set(-6999999); 
    	longword2.set(25252525);
    	result = HumbleAdder.add(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 +" + longword2);
    	System.out.println("Expecected value is: ");
    	System.out.println("Result     " + result);
    	System.out.println("");
    }

/**
 * Subtract two longwords
 */
    public static void SubtractTest() {
    	HumbleLongWord result = new HumbleLongWord();
    	HumbleLongWord longword1 = new HumbleLongWord();
    	HumbleLongWord longword2 = new HumbleLongWord();
    	
    	longword1.set(28); 
    	longword2.set(21);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 00000000000000000000000000000111");
    	System.out.println("Result     " + result);
    	System.out.println("");
    	
    	longword1.set(-28); 
    	longword2.set(-21);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 11111111111111111111111111111001");
    	System.out.println("Result     " + result);
    	System.out.println("");
    	
    	longword1.set(78888); 
    	longword2.set(12599);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 00000000000000010000001011110001");
    	System.out.println("Result     " + result);
    	System.out.println("");
    	
    	longword1.set(-999999); 
    	longword2.set(1000000);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 11111111111000010111101110000001");
    	System.out.println("Result     " + result);
    	System.out.println("");	

      	longword1.set(9); 
    	longword2.set(10);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 11111111111111111111111111111111");
    	System.out.println("Result     " + result);
    	System.out.println("");
    	
    	longword1.set(-6999999); 
    	longword2.set(25252525);
    	result = HumbleAdder.subtract(longword1, longword2);    
    	System.out.println("Longword1  " + longword1);
    	System.out.println("Longword2 -" + longword2);
    	System.out.println("Expecected value is: 11111110000100111101110110010100");
    	System.out.println("Result     " + result);
    	System.out.println("");
    }
    
 }