/**
 * The HumbleBit class makes use of a boolean to imitate a single bit. True giving a bit value of 1, and false giving a bit value of 0. 
 * This single bit can be compared with an otherBit variable, that is also imitating a single bit. 
 * @author Daniel Najafi
 *
 */
public class HumbleBit {

    private boolean boolvalue;

/**
 * Empty Constructor 
 */
    public HumbleBit() {
    }

/**
 * Overloaded the empty constructor to contain the boolean value in the parameter. 
 * @param value, needed to easily change the bit to be either true or false. 
 */
    public HumbleBit(boolean boolvalue) {
    	this.boolvalue = boolvalue;
    }

/**
 * Sets the initial value of the value boolean 
 * @param value, boolean value that holds the bit value
 */
    public void setValue(boolean boolvalue) {
        this.boolvalue = boolvalue;
    }

/**
 * When the toggle method is called it will imitate a switch. If the bit is true, it will become false. 
 * If the bit is false, it will become true.
 */
    public void toggle() {
        if(boolvalue) {
        	boolvalue = false;
        }
        else{
        	boolvalue = true;
        }
    }

/**
 * Overloaded use of setValue which does not require parameters to use. When used it will automatically 
 * set the value to true.
 */
    public void setValue() {
    	boolvalue = true;
    }

/**
 *  Clears the value of the boolvalue, making it 0.
 */
    public void clear() {
    	boolvalue = false;
    }

/**
 * Getter method. This method is giving value, so it will not change the current value of the boolvalue.    
 * @return value, giving a true or false.
 */
    public boolean getValue() {
        return boolvalue;
    }

/**
 * This method will compare the value of one bit with the value of an otherBit. The result of each case
 * is based on the AND truth table. This method should print false unless both value and otherBit are true. 
 * @param otherBit The second bit 
 * @return This returns a result, set as a new bit
 */
    public HumbleBit AND(HumbleBit otherBit) {
    	HumbleBit resultBit = new HumbleBit();

        if(boolvalue)
        {
            if(otherBit.getValue()) {
                resultBit.setValue();
            }
            else {
                resultBit.clear();
            }
        }
        else {
            resultBit.clear();
        }
        return resultBit;
    }

/**
 * Result is based on given values and truth table for OR. This result should be true for every case
 * but false if both valueBit and otherBit are false.
 * @param otherBit The second bit
 * @return This returns a result, set as a new bit
 */
    public HumbleBit OR(HumbleBit otherBit) {
    	HumbleBit resultBit = new HumbleBit();

        if(!boolvalue)
        {
            if(!otherBit.getValue()) {
                resultBit.clear();
            }
            else {
                resultBit.setValue();
            }
        }
        else {
            resultBit.setValue();
        }

        return resultBit;

    }

/**
 * Result is based on given values and truth table for XOR. This result will be false if the Bits have the same
 * boolean value. But it will be true if they differ. Having two true and false results. 
 * @param otherBit The second bit 
 * @return This returns a result, set as a new bit
 */
    public HumbleBit XOR(HumbleBit otherBit) {
    	HumbleBit resultBit = new HumbleBit();

        if (boolvalue) {                         
            if (otherBit.getValue()) {       
                resultBit.clear();        
            } else {
                resultBit.setValue(); 
            }
        } else { 
                if (otherBit.getValue()) { 
                    resultBit.setValue();  
                } else {        
                    resultBit.clear(); 
                }
        }
        return resultBit;
    }

/**
 * Result is based on given value and truth table for NOT. This one is simple, if the value is true, it will
 * return false. If it is false, it will return true.
 * @return This returns a result, set as a new bit
 */
    public HumbleBit NOT() {
    	HumbleBit resultBit = new HumbleBit();
        if(boolvalue){   //if true
            resultBit.clear();     //false
        }else{
            resultBit.setValue();  //if false, true
        }
        return resultBit;
    }

/**
 * This method is required  for testing, without it TheHumbleBit will be printed as an object, and will return
 * unreadable junk for the user. With the toString, if value is true, it will print "1", and it will print "0" if false.
 */
    public String toString() {
        if (boolvalue) {
            return "1";
        } else {
            return "0";
        }
    }

}