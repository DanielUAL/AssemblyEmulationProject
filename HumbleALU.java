package Assignment4_HumbleALU;

public class HumbleALU {

/**
 * This multiplier makes use of shifting and the adder to multiply two longwords.
 * By copying the first longword every time there is a 1 bit in the second longword, then
 * shifting based on the index, then adding all these instances. The product is given.	
 * @param longword1 First input longword
 * @param longword2 Second input longword
 * @return The product of the two inputed longwords
 */
public static HumbleLongWord multiply(HumbleLongWord longword1, HumbleLongWord longword2) {
    HumbleLongWord resultLong = new HumbleLongWord();
    HumbleLongWord value = new HumbleLongWord();

    for (int count = 0; count < longword1.length(); count++) {

    	if(longword2.getBit(count).getValue()) {
    		value.copy(longword1);
    		value = value.LeftShift(count); 
    		resultLong = HumbleAdder.add(resultLong, value);
    	}    	
    } 
    return resultLong;	
}

/**
 * This method makes use of many of the previously created methods, so that it can creatue a functional calculator
 * based on what the user needs. 
 * @param operation First 4 bits that will tell the calculator which operation to do
 * @param longword1 The first input
 * @param longword2 The second input
 * @return
 */
public static HumbleLongWord doOp(HumbleBit[] operation, HumbleLongWord longword1, HumbleLongWord longword2) {
	 HumbleLongWord resultLong = new HumbleLongWord();

	 if(!operation[0].getValue() && !operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) { //1000 - and
		 resultLong = longword1.ANDlongword(longword2);
	 }
	 if(operation[0].getValue() && !operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) { //1001 - or
		 resultLong = longword1.ORlongword(longword2);
	 }
	 if(!operation[0].getValue() && operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) { //1010 - xor
		 resultLong = longword1.XORlongword(longword2);
	 }	 
	 if(operation[0].getValue() && operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) { //1011 - not
		 resultLong = longword1.NOTlongword();
	 }
	 if(!operation[0].getValue() && !operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) { //1100 - left shift
		 longword2.LeftShift(27);
		 longword2.RightShift(27);
		 resultLong = longword1.LeftShift(longword2.getSigned());
	 } 
	 if(operation[0].getValue() && !operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) { //1101 - right shift
		 longword2.LeftShift(27);
		 longword2.RightShift(27);
		 resultLong = longword1.RightShift(longword2.getSigned());
	 }
	 if(!operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) { //1110 - add
		 resultLong = HumbleAdder.add(longword1, longword2);
	 } 
	 if(operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) { //1111 - subtract
		 resultLong = HumbleAdder.subtract(longword1, longword2);
	 }
	 if(operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && !operation[3].getValue()) { //0111 - multiply
		 resultLong = HumbleALU.multiply(longword1, longword2);
	 }
	return resultLong;	
}
}
