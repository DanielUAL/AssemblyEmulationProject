package Assignment5_ICSI404_Package;
/**
 * Creates a power button, and gives space for a Computer to be made.
 * @author dnaja
 *
 */
public class HumbleComputer {
	
	private HumbleMemory member = new HumbleMemory(); 
	HumbleBit power = new HumbleBit();
/**
 * 	Establishes the constructor to make use of the member.
 * @param member The full memory alocation from HumbleMemory
 */
	public HumbleComputer(HumbleMemory member){
		
	}
/**
 * 	Runs all methods the computer needs to go through, however
 *  the methods don't need to do anything since the computer is off.
 */
	public void run() {
		while(power.getValue()) {
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	public static void fetch() {
		
	}
	
	public static void decode() {
		
	}
	
	public static void execute() {
		
	}
	
	public static void store() {
		
	}
	
}
