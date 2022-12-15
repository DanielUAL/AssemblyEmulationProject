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

    /**
     * Writes the entire value to a given address. But at the end of the given array
     * @param address This is one of 256 potential longwords that the read can be
     * @param value The entire LongWord that will be written at a given address.
     */
    public void stackwrite(HumbleLongWord address, HumbleLongWord value) {
        int MemAddress;
        MemAddress = address.getSigned()*8;

        for(int count = 0; count < value.length(); count++) {
            computermem[MemAddress] = value.getBit(count);
            MemAddress++;
        }
    }
    /**
     * Needed for interrupt so that 0s and 1s can be printed instead of just an object.
     * @return all contents of the memory
     */
    public String toString(){
        String memprint = "";
//make 0 the sp.getsigned*8
        for (int count = computermem.length - 1; count >= 0; count--) {
            if(computermem[count].getValue()) {
                memprint+="1";
            }else {
                memprint+="0";
            }
        }
        return memprint;
    }

    /**
     * This writes to memory from left to right, starting at the end of the array. This will go backwards
     * until it reaches the stopping point which is the stackpointer value.
     * @return
     */
    public String StackToString(){
        String stackprint = "";
        HumbleComputer CrossOverComputer = new HumbleComputer();

        for (int count = computermem.length - 1; count >= CrossOverComputer.StackPointer.getSigned()*8; count--) {
            if(computermem[count].getValue()) {
                stackprint+="1";
            }else {
                stackprint+="0";
            }
        }
        return stackprint;
    }
}
