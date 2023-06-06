package Assignment4_HumbleALU;
/**
 * HumbleLongWord class makes of the HumbleBit class created in previous assignment. These bits 
 * are put into an array so that it can be a 32 bit long. 
 * @author Daniel Najafi
 *
 */
public class HumbleLongWord {

    private HumbleBit[] humblelong;

 /**
   * Constructor for the HumbleLongWord, gives the HumbleBit array a size of 32. Also fills the
   * default state of the array as empty. For the sake of testing later
   */
    public HumbleLongWord() {
        humblelong = new HumbleBit[32];

        for(int count = 0; count < humblelong.length; count++) {
            humblelong[count] = new HumbleBit(false);
        }
    }
    
/**
 * Allows for use of the longword length, which is a private normally, in other classes
 * @return Size of the array
 */
    public int length() {
		return humblelong.length;
    }
/**
 * Getter method. This method is giving value, so it will not change the current value of the array. 
 * The array index can only be between 0 and 31.
 * @param i Given i, will get the value at the indicated index
 * @return the array of bits, at the specified index.
 */
    public HumbleBit getBit(int i){
        if(i < 0 && 31 < i){
            throw new ArrayIndexOutOfBoundsException("Error in getBit. Index invalid: " + i);
        }else
            return humblelong[i];
    }

/**
 * This method can alter specific bits in the array
 * @param i takes in a given index
 * @param value Sets the given index to a given true value, to set the specific bit to true or false
 */
    public void setBit(int i, HumbleBit value) { 
        humblelong[i] = value;
    }

/**
 * This method will compare the values of an array with the values of an other array. The result will be 1 if both
 * arrays have a one at the same index, and 0 if not. This process will be consistent for all 32 bits.
 * @param otherlong The second long array
 * @return This returns a resultLong, set as a new array of bits.
 */
    public HumbleLongWord ANDlongword(HumbleLongWord otherlong) {   
        HumbleLongWord resultLong = new HumbleLongWord();

        for(int count = 0; count < humblelong.length; count++) {
            if(humblelong[count].AND(otherlong.getBit(count)).getValue()) {
                resultLong.setBit(count, new HumbleBit(true));
            }
            else {
                resultLong.setBit(count, new HumbleBit(false));
            }
        }
        return resultLong;
    }

/**
 * This method will compare the values of an array with the values of an other array. The result will be 0 if both
 * aligned array indexes are 0. It will be 1 for all other cases. This process will be consistent for all 32 bits.
 * @param otherlong The second long array
 * @return This returns a resultLong, set as a new array of bits.
 */
    public HumbleLongWord ORlongword(HumbleLongWord otherlong) {
        HumbleLongWord resultLong = new HumbleLongWord();

        for(int count = 0; count < humblelong.length; count++) {
            if(!humblelong[count].OR(otherlong.getBit(count)).getValue()) {
                resultLong.setBit(count, new HumbleBit(false));
            }
            else {
                resultLong.setBit(count, new HumbleBit(true));
            }
        }
        return resultLong;
    }

/**
* This method will compare the values of an array with the values of an other array. The result will be 1 if both aligned 
* array indexes are different. It will be 0 for all other cases. This process will be consistent for all 32 bits.
* @param otherlong The second long array
* @return This returns a resultLong, set as a new array of bits.
*/    
    public HumbleLongWord XORlongword(HumbleLongWord otherlong) {
        HumbleLongWord resultLong = new HumbleLongWord();

        for(int count = 0; count < humblelong.length; count++) {
            if(humblelong[count].XOR(otherlong.getBit(count)).getValue()) {
                resultLong.setBit(count, new HumbleBit(true));
            }else {
                resultLong.setBit(count, new HumbleBit(false));
            }
        }
        return resultLong;
    }

/**
 * Result is based on given array. Every bit in the array will be set to the inverse.    
 * @return This returns a resultLong, set as a new array of bits.
 */
    public HumbleLongWord NOTlongword() {
        HumbleLongWord resultLong = new HumbleLongWord();

        for(int count = 0; count < humblelong.length; count++) {
            if(humblelong[count].getValue()) {
                resultLong.setBit(count, new HumbleBit(false));
            }else{
                resultLong.setBit(count, new HumbleBit(true));
            }
        }
        return resultLong;
    }

/**
 * The values in the array will shift to the right depending on the amount given. 
 * @param amount number in which the shift will occur in the bit.
 * @return This returns a resultLong, set as a new array of bits.
 */
    public HumbleLongWord RightShift(int amount) {
        HumbleLongWord resultLong = new HumbleLongWord();
if(amount >= 0) {
    amount = amount * -1;
    for (int count = 0; count < humblelong.length; count++) {
        try {
            resultLong.humblelong[amount + count] = humblelong[count];
        } catch (ArrayIndexOutOfBoundsException E) {
        }
    }
}
        return resultLong;
    }
    
/**
 * The values in the array will shift to the left depending on the amount given. 
 * @param amount number in which the shift will occur in the bit.
 * @return This returns a resultLong, set as a new array of bits.
 */    
    public HumbleLongWord LeftShift(int amount) {
        HumbleLongWord resultLong = new HumbleLongWord();
        if(amount >= 0) {
            for (int count = 0; count < humblelong.length; count++) {
                try {
                    resultLong.humblelong[amount + count] = humblelong[count];
                } catch (ArrayIndexOutOfBoundsException E) {
                }
            }
        }
        return resultLong;
    }

/**
 * This method is required  for testing, without it TheHumbleBit will be printed as an object, and will return
 * unreadable junk for the user. With the toString, if value is true, it will print "1", and it will print "0" if false.
 */
    @Override
    public String toString() {


        String longwordprint = "";

        for (int count = humblelong.length - 1; count >= 0; count--) {
            if(humblelong[count].getValue()) {
                longwordprint+="1";
            }else {
                longwordprint+="0";
            }
        }
        return longwordprint;
    }

/**
 * This method goes through the bit, and applies the 2 power for each appropriate bit. The value
 * will be added up depending on if the given bit is true in the array.
 * @return The result of the unsigned binary converted to decimal
 */
    public long getUnsigned(){
		
		long exponentresult = 0;
		long bitexponentvalue = 0;
		
        for (int count = humblelong.length - 1; count >= 0; count--) {
        	
        if(humblelong[count].getValue()) {
        	bitexponentvalue = (long) Math.pow(2, count); //1st bit = 2^31
        	exponentresult = exponentresult + bitexponentvalue; 
        }
       }
        return exponentresult;
    }
    
/**
 * For signed bit, the first bit, if 1, will be a negative value. However the value will be off by one. 
 * A subtraction of one is needed to make all the numbers accurate. 
 * @return The result of the signed binary converted to decimal
 */
    public int getSigned(){
    	int exponentresult = 0;
    	int bitexponentvalue = 0;
		
        for (int count = humblelong.length - 2; count >= 0; count--) {
        	
        	if(humblelong[count].getValue()) {
        		bitexponentvalue = (int) Math.pow(2, count); //1st bit = 2^31
        		exponentresult = exponentresult + bitexponentvalue; 
        	}
       }
        if(humblelong[humblelong.length - 1].getValue()) {
        	bitexponentvalue = (int) Math.pow(2, humblelong.length - 1); //1st bit = 2^31
        	exponentresult = exponentresult - bitexponentvalue; 
        	exponentresult = exponentresult - 1; 
        }
        return exponentresult;
    }

/**
 * Copies a longword
 * @param otherlong The copied over long
 */
    public void copy(HumbleLongWord otherlong) {
    	humblelong = otherlong.humblelong;
    }

/**
 * This function will create a longword based on the decimal value given. This method
 * works for unsigned and signed binary number outputs    
 * @param value User inputed decimal value
 */
    public void set(int value) {
        HumbleLongWord resultLong = new HumbleLongWord();
        int count = 0;
  
        if(value < 0) {  
        	value = Math.abs(value);
        	while(value != 0) {
        	      if(value%2 ==1) {
        	         resultLong.setBit(count, new HumbleBit(true));
        	      }else {
        	         resultLong.setBit(count, new HumbleBit(false));
        	      }
        	      value = value/2;
        	      count++;
        	}
        		resultLong.twoscompliment();            	

        }else {
        	while(value != 0) {
        	      if(value%2 ==1) {
        	         resultLong.setBit(count, new HumbleBit(true));
        	      }else {
        	         resultLong.setBit(count, new HumbleBit(false));
        	      }
        	      value = value/2;
        	      count++;
        	 }    
        }  
        humblelong = resultLong.humblelong;
        }	
    
/**
 *  Encodes positive and negative numbers in a binary number representation 
 */
    public void twoscompliment() {
        HumbleLongWord resultLong = new HumbleLongWord();
        HumbleLongWord xinput = this.NOTlongword();
        HumbleLongWord yinput = new HumbleLongWord();
        yinput.setBit(0, new HumbleBit(true));
        
        HumbleBit Carryout = new HumbleBit();
        HumbleBit Carryin = new HumbleBit();
        HumbleBit Sum = new HumbleBit();
        
        for (int count = 0; count < humblelong.length; count++) {
            HumbleBit xbit = xinput.getBit(count);
            HumbleBit ybit = yinput.getBit(count);	
        	
            Sum = xbit.XOR(ybit).XOR(Carryin);
            Carryout = xbit.AND(ybit).OR((xbit.XOR(ybit)).AND(Carryin));
            Carryin = Carryout;
            
            resultLong.setBit(count, Sum);   	
        }
        this.copy(resultLong);
    }
    
}