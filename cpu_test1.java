public class cpu_test1 {
    /**
     * Tests out the CPU, by creating a new computer for each test, so that changes can be applied to all
     */
    public static void runCPUTest() {
        String[] ArrayOfStrings2 = new String[2];

        System.out.println("Halt");
        HumbleComputer haltTest = new HumbleComputer();

        String haltFirstString = "0000111101010111";
        String haltSecondString = "0000111101010111";

        ArrayOfStrings2[0] = haltFirstString;
        ArrayOfStrings2[1] = haltSecondString;

        haltTest.preload(ArrayOfStrings2);
        haltTest.run();

//INTERUPT TEST
        System.out.println("Interrupt");

        String[] ArrayOfStringsInterrupt = new String[2];
        HumbleComputer InterruptTest = new HumbleComputer();
        String InterruptFirstString = "0010000000000001"; //print all memory  0010000000000001
        String InterruptSecondString = "0010000000000000"; //print all register 0010000000000000

        ArrayOfStringsInterrupt[0] = InterruptFirstString;
        ArrayOfStringsInterrupt[1] = InterruptSecondString;

        InterruptTest.preload(ArrayOfStringsInterrupt);
        InterruptTest.run();
//Move
        System.out.println("MOVE");

        String[] ArrayOfStringsMove = new String[2];
        HumbleComputer MoveTest = new HumbleComputer();
        String MoveFirstTest = "0001011011110110"; //0001001000001010      -10 = 0001001011110110
        String MoveSecondTest = "0010000000000000"; //0010000000000000

        ArrayOfStringsMove[0] = MoveFirstTest;
        ArrayOfStringsMove[1] = MoveSecondTest;

        MoveTest.preload(ArrayOfStringsMove);
        MoveTest.run();

        //ALU
        System.out.println("ALU");

        String[] ArrayOfStringsALU = new String[2];
        HumbleComputer ALUTest = new HumbleComputer();
        String ALUFirstTest = "1110001001000000"; //Does 2+4 = 6 0110
        String ALUSecondTest = "0010000000000000"; //0010000000000000

        ArrayOfStringsALU[0] = ALUFirstTest;
        ArrayOfStringsALU[1] = ALUSecondTest;

        ALUTest.preload(ArrayOfStringsALU);
        ALUTest.run();

        //if "move" String = 0001. if R1 String = 0001. if -1 String = 1111,1111
    }
}
