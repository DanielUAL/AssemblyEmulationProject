/**
 * The HumbleAdder class makes use of the HumbleLong class, which makes use of
 * the HumbleBit class, from previous assignments. The LongWords that can be created
 * are now able to be added or subtracted by each other with the new methods this
 * project contains.  
 * @author dnaja
 *
 */
public class HumbleAdder {

/**
 * This adder makes use of a general outline of a twos compliment coding logic. To add
 * two binary longwords and output another binary longword.
 * @param xinput First input longword
 * @param yinput Second input longword
 * @return The sum of the two given longwords, printed as a longword in binary
 */
public static HumbleLongWord add(HumbleLongWord xinput,HumbleLongWord yinput){
    HumbleLongWord resultLong = new HumbleLongWord();
 
    HumbleBit Carryout = new HumbleBit();
    HumbleBit Carryin = new HumbleBit();
    HumbleBit Sum = new HumbleBit();
    
    for (int count = 0; count < xinput.length(); count++) {
        HumbleBit xbit = xinput.getBit(count);
        HumbleBit ybit = yinput.getBit(count);	
    	
        Sum = xbit.XOR(ybit).XOR(Carryin);
        Carryout = xbit.AND(ybit).OR((xbit.XOR(ybit)).AND(Carryin));
        Carryin = Carryout;
        resultLong.setBit(count, Sum);   	
    }
    return resultLong;	
}

/**
 * This adder makes use of a general outline of a twos compliment coding logic. To subtract
 * two binary longwords and output another binary longword.
 * @param xinput First input longword
 * @param yinput Second input longword
 * @return The difference of the two given longwords, printed as a longword in binary
 */
public static HumbleLongWord subtract(HumbleLongWord xinput,HumbleLongWord yinput){
    HumbleLongWord resultLong = new HumbleLongWord();
    
    HumbleBit Carryout = new HumbleBit();
    HumbleBit Carryin = new HumbleBit();
    HumbleBit Sum = new HumbleBit();
    yinput.twoscompliment();
    
    for (int count = 0; count < xinput.length(); count++) {
        HumbleBit xbit = xinput.getBit(count);
        HumbleBit ybit = yinput.getBit(count);	
    	
        Sum = xbit.XOR(ybit).XOR(Carryin);
        Carryout = xbit.AND(ybit).OR((xbit.XOR(ybit)).AND(Carryin));
        Carryin = Carryout;
        resultLong.setBit(count, Sum);   	
    }
    return resultLong;	
}
	
}