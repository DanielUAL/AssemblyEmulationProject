package Assignment6_ICSI404;
/**
 * Sets the PC, Registers, Decoding, Executing, and Storing functions needed
 * fundamentally to make a computer.
 * @author dnaja
 *
 */
public class HumbleComputer {
	
	private HumbleMemory member = new HumbleMemory(); 
	HumbleLongWord[] register; 
	
	HumbleBit power = new HumbleBit();
	HumbleLongWord PC = new HumbleLongWord();   
	HumbleLongWord currentInstruction = new HumbleLongWord();
	HumbleLongWord op1 = new HumbleLongWord();
	HumbleLongWord op2 = new HumbleLongWord();
	HumbleLongWord result = new HumbleLongWord();
	int count;

/**
 * 	Establishes the constructor to make use of the member.
 *  Also sets the register size to be 16 longwords. 
 * @param member The full memory allocation from HumbleMemory
 */
	public HumbleComputer(HumbleMemory member){
		register = new HumbleLongWord[16];
	}
/**
 * 	Runs all methods the computer needs to go through, while the computer is on
 */
	public void run() {
		while(power.getValue()) {
			fetch();
			decode();
			execute();
			store();
		}
	}
/**
 * Reads the memory using PC as an address, then used the rippleAdder as a makeshift
 * increment, for the sake of proper addresses for the PC	
 */
	public void fetch() {
		HumbleLongWord Two = new HumbleLongWord();
		Two.set(2);
		currentInstruction = member.read(PC);
		HumbleAdder.add(PC, Two);
	}
/**
 * 	Decode deals with the 2nd set and 3rd set of bits that pose as the second and third registers
 */
	public void decode() {
		op1 = currentInstruction;
		op2 = currentInstruction;
									
		op1 = op1.LeftShift(20);	
		op1 = op1.RightShift(28);	
								
		op2 = op2.LeftShift(24);	
		op2 = op2.RightShift(28);	
	}
/**
 * 	Need to make an array of HumbleBits so that it can be used in doOp. This becomes
 *  a register that keeps track of operation
 */
	public void execute() {		
		HumbleBit[] opcode = new HumbleBit[4]; 
		opcode[0] = currentInstruction.getBit(19);
		opcode[1] = currentInstruction.getBit(18);
		opcode[2] = currentInstruction.getBit(17);
		opcode[3] = currentInstruction.getBit(16);
		
		result = HumbleALU.doOp(opcode, op1, op2);
	}
/**
 * 	Stores the result of the operation on the op1, and op2. Stored into the last register. 
 */
	public void store() {
		register[count].copy(result);
		count++;
	}	
}
