import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Sets the PC, Registers, Decoding, Executing, and Storing functions needed
 * fundamentally to make a computer.
 * @author dnaja
 *
 */
public class HumbleComputer {

    private HumbleMemory member = new HumbleMemory();
    HumbleLongWord[] register = new HumbleLongWord[16];
    HumbleBit power = new HumbleBit();
    HumbleLongWord PC = new HumbleLongWord();
    HumbleLongWord currentInstruction = new HumbleLongWord();
    HumbleLongWord op1ALU = new HumbleLongWord();
    HumbleLongWord op2ALU = new HumbleLongWord();
    HumbleLongWord Compare1 = new HumbleLongWord();
    HumbleLongWord Compare2 = new HumbleLongWord();
    HumbleLongWord SelectedRegister = new HumbleLongWord();
    HumbleBit[] opcode = new HumbleBit[4];
    HumbleLongWord result = new HumbleLongWord();
    HumbleLongWord MoveLongValue = new HumbleLongWord();
    HumbleLongWord compare = new HumbleLongWord();
    boolean JumpHappen = false;
    boolean BranchHappen = false;
    int RegisterNumber;
    int MoveIntValue;
    int count;
    String AssembleBranchString;
    String AsssembleSignedString;

    /**
     * 	Establishes the constructor to make use of the member.
     */
    public HumbleComputer(){
        for(int count = 0; count < register.length; count++) {
            register[count] = new HumbleLongWord();
        }
    }
    /**
     * 	Runs all methods the computer needs to go through, while the computer is on. Then does a shift
     * 	to go through both registers of the 32 bit longword. Since each register is 16 bits long.
     */
    public void run() {
        while(!power.getValue()) {
            fetch();
            decode();
            execute();
            store();
            currentInstruction = currentInstruction.LeftShift(16);
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
        HumbleLongWord TwoBytes = new HumbleLongWord();
        TwoBytes.set(16);

        if(JumpHappen) { //make a JUMP boolean
            PC.set((RegisterNumber*16));
            JumpHappen = false;
        }else if(BranchHappen){
            HumbleLongWord branchlong = new HumbleLongWord();
            branchlong.set(RegisterNumber);
            PC = HumbleAdder.add(PC,HumbleALU.multiply(branchlong,TwoBytes));
            BranchHappen = false;
        }
        else{
            currentInstruction = member.read(PC);
            PC = HumbleAdder.add(PC, TwoBytes);
        }
    }
    /**
     * 	Decode organizes the currentInstruction bits, that pose as the current register the computer is on.
     */
    public void decode() {
        op1ALU = currentInstruction;
        op2ALU = currentInstruction;
        Compare1 = currentInstruction;
        Compare2 = currentInstruction;

        op1ALU = op1ALU.LeftShift(4);
        op1ALU = op1ALU.RightShift(28); //this takes third register

        op2ALU = op2ALU.LeftShift(8);
        op2ALU = op2ALU.RightShift(28);

        Compare1 = Compare1.LeftShift(8);
        Compare1 = Compare1.RightShift(28);

        Compare2 = Compare2.LeftShift(12);
        Compare2 = Compare2.RightShift(28);
    }
    /**
     * 	Sets opCode, and checks opCode to perform the correct operations on the register
     */
    public void execute() {
        opcode[0] = currentInstruction.humblelong[31];
        opcode[1] = currentInstruction.humblelong[30];
        opcode[2] = currentInstruction.humblelong[29];
        opcode[3] = currentInstruction.humblelong[28];

        System.out.println(opcode[0]);
        if(!opcode[0].getValue() && !opcode[1].getValue() && !opcode[2].getValue() && !opcode[3].getValue()) { //if opcode = 0000
            HALT();
        }
        if(!opcode[0].getValue() && !opcode[1].getValue() && !opcode[2].getValue() && opcode[3].getValue()) { //if opcode = 0001
            MOVE();
        }
        if(!opcode[0].getValue() && !opcode[1].getValue() && opcode[2].getValue() && !opcode[3].getValue()) { //if opcode = 0010
            INTERRUPT();
        }
        if(!opcode[0].getValue() && !opcode[1].getValue() && opcode[2].getValue() && opcode[3].getValue()) { //if opcode = 0011
            JUMP();
        }
        if(!opcode[0].getValue() && opcode[1].getValue() && !opcode[2].getValue() && !opcode[3].getValue()) { //if opcode = 0100
            COMPARE();
        }
        if(!opcode[0].getValue() && opcode[1].getValue() && !opcode[2].getValue() && opcode[3].getValue()) { //if opcode = 0101
            BRANCH();
        }

    }
    /**
     *  Inputs value into the register, then increments to go onto the next register
     */
    public void store() {
        if(opcode[0] == null){
            register[count] = result;
        }
        else if(opcode[0].getValue() && !opcode[1].getValue() && !opcode[2].getValue() && !opcode[3].getValue()) {
            register[count].copy(SelectedRegister);
            count++;
        } else {
            result = HumbleALU.doOp(opcode, op1ALU, op2ALU);
            register[count].copy(result);
            member.write(PC, result);
            count++;
        }
    }
    /**
     *  If opcode is 0000, turn off computer
     */
    public void HALT() {
        power.setValue(true);
    }
    /**
     * opCode is first checked in execute, then makes use of the move code. Move will then identify the register, acting as a moveExecute. This Selected
     * Register will have SignExtension done to it, and in that method the calculated final result exists.
     */
    public void MOVE() {
        //int RegisterNumber;
        SelectedRegister.humblelong[0] = currentInstruction.getBit(24) ;
        SelectedRegister.humblelong[1] = currentInstruction.getBit(25) ;
        SelectedRegister.humblelong[2] = currentInstruction.getBit(26) ;
        SelectedRegister.humblelong[3] = currentInstruction.getBit(27) ;

        RegisterNumber = SelectedRegister.getSigned();
        //int MoveIntValue;

        MoveLongValue.humblelong[7] = currentInstruction.getBit(23);
        MoveLongValue.humblelong[6] = currentInstruction.getBit(22);
        MoveLongValue.humblelong[5] = currentInstruction.getBit(21);
        MoveLongValue.humblelong[4] = currentInstruction.getBit(20);
        MoveLongValue.humblelong[3] = currentInstruction.getBit(19);
        MoveLongValue.humblelong[2] = currentInstruction.getBit(18);
        MoveLongValue.humblelong[1] = currentInstruction.getBit(17);
        MoveLongValue.humblelong[0] = currentInstruction.getBit(16);

        MoveIntValue = MoveLongValue.getSigned();

        //Set the value that was just gotten to the correctly indicated register.
        register[RegisterNumber].set(MoveIntValue);

        SignedExtension();
    }
    /**
     * 	 Third Part using a getter on the register, to see if the 8th bit is a 1 or 0, then does Signed extension based on result. This SelectedRegister value  is what is now put into
     *   the computer in the store function
     */
    public void SignedExtension() {
        HumbleLongWord ArbitraryLongWord = new HumbleLongWord();
        ArbitraryLongWord.set(255);
        ArbitraryLongWord = ArbitraryLongWord.NOTlongword();

        if(!MoveLongValue.getBit(7).getValue()) {
            MoveLongValue.LeftShift(24);
            MoveLongValue.RightShift(24);
            register[RegisterNumber].set(MoveIntValue);
        }else {
            MoveLongValue.LeftShift(24);
            MoveLongValue.RightShift(24);
            MoveLongValue = HumbleAdder.add(MoveLongValue, ArbitraryLongWord);
            MoveIntValue = MoveLongValue.getSigned();
            register[RegisterNumber].set(MoveIntValue);
        }
    }

    /**
     * This interrupt is used if the opcode is 0010, then the last bit is checked to see if it will print all the contents of member, or all the registers.
     */
    public void INTERRUPT() {
        if(!currentInstruction.getBit(16).getValue()) { //16 instead? read ending of the first register
            System.out.println(registerToString());
        }else {
            System.out.println(member.toString());
        }
    }

    /**
     * This method will take the selected reigster bits at the end. Reading them for the Register
     * Then the JumpHappen boolean is set to true, so that when going through fetch, the PC will go to the
     * RegisterNumber. This is done by setting the value of PC to RegisterNumber.
     */
    public void JUMP() {
        SelectedRegister.humblelong[0] = currentInstruction.getBit(16) ;
        SelectedRegister.humblelong[1] = currentInstruction.getBit(17) ;
        SelectedRegister.humblelong[2] = currentInstruction.getBit(18) ;
        SelectedRegister.humblelong[3] = currentInstruction.getBit(19) ;

        RegisterNumber = SelectedRegister.getSigned(); //number 0-15
        JumpHappen = true;
        fetch();
    }

    /**
     * Compare will check two sets of 4 bits to see if they are equal, or less than, or greater than,
     * or not equal to. This Comparison value will give an output of a longword that contains only two
     * bits ever. These two bits can be used to compare with any branch input in the future.
     */
    public void COMPARE(){
        int Compare1IntValue;
        int Compare2IntValue;
        Compare1IntValue = Compare1.getSigned();
        Compare2IntValue = Compare2.getSigned();

        if(Compare1IntValue == Compare2IntValue){
            compare.set(3);
        }
        else if(Compare1IntValue > Compare2IntValue){
            compare.set(2);
        }
        else if(Compare1IntValue < Compare2IntValue){
            compare.set(1);
        }
        else{
            compare.set(0);
        }
        System.out.println(compare);
    }

    /**
     * To in this Branch we start out similarly to Jump, setting the Branch Boolean to true. Because
     * fetch will be called at the end of the function to increment the PC by the given branch value
     * in assembler multiplied by 16. The branch uses the HumbleAssembler input, so it uses a crossover
     * variable that goes across classes. Depending the input in Assembler, we will get a 11, 10, 01, or 00
     * that gets put into Assembler later. Then we do a sign extension similar to move, but this time based on
     * the 10th bit.
     */
    public void BRANCH(){
        BranchHappen = true;
        HumbleAssembler CrossOverAssembler = new HumbleAssembler();
        HumbleLongWord ConditionalCode = new HumbleLongWord();
        ConditionalCode = currentInstruction;

        ConditionalCode = ConditionalCode.LeftShift(4);
        ConditionalCode = ConditionalCode.RightShift(30);

            if(ConditionalCode.getSigned() == 3){
                AssembleBranchString = "11";
            }
            if(ConditionalCode.getSigned() == 2){
                AssembleBranchString = "10";
            }
            if(ConditionalCode.getSigned() == 1){
                AssembleBranchString = "01";
            }
            if(ConditionalCode.getSigned() == 0){
                AssembleBranchString = "00";
            }

        HumbleLongWord ArbitraryLongWord = new HumbleLongWord();
        HumbleLongWord ValueSignExtension = new HumbleLongWord();
        ArbitraryLongWord.set(1023);
        ArbitraryLongWord = ArbitraryLongWord.NOTlongword();
        ValueSignExtension = currentInstruction;
        ValueSignExtension = ValueSignExtension.RightShift(16);

        RegisterNumber = HumbleAssembler.BranchRegister;
        if(!ValueSignExtension.getBit(9).getValue()) {
            AsssembleSignedString = "0";
            ValueSignExtension = ValueSignExtension.LeftShift(22);
            ValueSignExtension = ValueSignExtension.RightShift(22);
        }else {
            AsssembleSignedString = "1";
            ValueSignExtension = ValueSignExtension.LeftShift(22);
            ValueSignExtension = ValueSignExtension.RightShift(22);
            ValueSignExtension = HumbleAdder.add(ValueSignExtension, ArbitraryLongWord);
        }
        register[RegisterNumber].set(ValueSignExtension.getSigned()); //This RegisterNumber is given by the assembler
        fetch();
    }

    /**
         * Needed for interrupt so that 0s and 1s can be printed instead of just an object.
         * @return
         */
    public String registerToString(){
        String regprint = "";

        for (int count = register.length - 1; count >= 0; count--) {
           regprint += register[count].toString() + '\n';
        }
        return regprint;
    }

    /**
     * Preload will take in two different Strings. These two strings will be inputted as 16 long arrays. It will iterate through the 2 String Arrays
     * Then iterate through the contents of the String arrays, to get all 32 characters. These 32 characters are converted to meet the requirements to be
     * put into a longword called NumbersContained. Address is what contains the value of the register address. This Longword is then inputted to be the
     * value of currentAddress so that any operator can be manually tested in the cpu_test1.
     * @param RegisterAsString
     */
    public void preload(String[] RegisterAsString) {
        HumbleLongWord NumbersContained= new HumbleLongWord();
        HumbleLongWord Address = new HumbleLongWord();

        for(int i = 0; RegisterAsString.length > i ; i++) {

            for(int StringIterator16Length = 0; NumbersContained.length() > StringIterator16Length ; StringIterator16Length++) {
                char[] IndexedCharacterInString = RegisterAsString[i].toCharArray();
                    int IndexedCharacterAsInt;
                if(StringIterator16Length >= 16){
                     IndexedCharacterAsInt = Character.getNumericValue(IndexedCharacterInString[StringIterator16Length - 16]);

                }else{
                     IndexedCharacterAsInt = Character.getNumericValue(IndexedCharacterInString[StringIterator16Length]);
                     if(StringIterator16Length == 15){
                         i++;   //changes the String being used
                     }
                }
                int compensate = NumbersContained.length() - StringIterator16Length;
                if(IndexedCharacterAsInt == 1) {
                    NumbersContained.setBit(compensate-1, new HumbleBit(true));
                }else {
                    NumbersContained.setBit(compensate-1, new HumbleBit(false)); //StringIterator16Length
                    }
            }
            member.write(Address, NumbersContained);

            HumbleLongWord FourBytes = new HumbleLongWord();
            FourBytes.set(32);
            Address = HumbleAdder.add(Address, FourBytes);
          }
    }
}