package Assignment6_ICSI404;
/**
 * Establishes the methods for reading and writing, and creates memory for
 * the computer.
 * @author dnaja
 *
 */
public class HumbleMemory {

	private HumbleBit[] computermem;
/**
 * The constructor is filled, creating an array that can hold 8192 bits.
 * These bits are then all set to 0.	
 */
	public HumbleMemory() {
		computermem = new HumbleBit[8192];
		
        for(int count = 0; count < computermem.length; count++) {
            computermem[count] = new HumbleBit(false);
        }
	}

/**
 * Multiples by 32 to avoid all the unneeded bits.
 * @param address This is one of 256 potential longwords that the read can be
 * @return The entire longword at the given address
 */
	public HumbleLongWord read(HumbleLongWord address) {
        HumbleLongWord resultLong = new HumbleLongWord();   
        int i = 0;
        int MemAddress;
        MemAddress = address.getSigned()*32;
        
        for(int count = 0; count < resultLong.length(); count++) {
        	resultLong.setBit(count, computermem[MemAddress + i]);
        	i++;
        }
	return resultLong;
	}
	
/**
 * Writes the entire value to a given address.	
 * @param address This is one of 256 potential longwords that the read can be
 * @param value The entire LongWord that will be written at a given address.
 */
	public void write(HumbleLongWord address, HumbleLongWord value) {
		int MemAddress;
		MemAddress = address.getSigned()*32;
		
        for(int count = 0; count < value.length(); count++) {
		computermem[MemAddress] = value.getBit(count);
		MemAddress++;
        }		
	}
	        	
}
