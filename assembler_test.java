public class assembler_test {
    /**
     *  This method runs the methods created for testing all methods.
     */
    public static void main(String[] args) {
        longword_test LongTest = new longword_test();
        bit_test BitTest = new bit_test();
        rippleAdder_test AdderTest = new rippleAdder_test();
        multiplier_test MultiplierTest = new multiplier_test();
        ALU_test ALUTest = new ALU_test();
        memory_test MemoryTest = new memory_test();
        cpu_test1 CpuTest = new cpu_test1();
        bonus_test LexicalSyntaxTest = new bonus_test();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Bit Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        BitTest.runTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Longword Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        LongTest.runLTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RippleAdder Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        AdderTest.runRTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Multiply Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        MultiplierTest.runMTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ALU Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ALUTest.runALUTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Memory Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        MemoryTest.runMemTests();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CPU Test~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        cpu_test1.runCPUTest();
        runAssemblerTest();
    }

    /**
     * Tests out the Assembler, creates new Strings for each tested operation
     */
    public static void runAssemblerTest() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LexicalAnalyzer + SyntaxAnalyzer Tests~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        bonus_test ParserInfo = new bonus_test();
        ParserInfo.runBonus();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Assembler Test~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        /**
         * An input of one string was put into the parser. After leaving the parser, the one string is now three that can be read by the assembler in pieces.
         */
        String HaltTest[] = new String[]{ParserInfo.haltinstruct};
        String MoveTest[] = new String[]{ParserInfo.moveinstruct1, ParserInfo.moveinstruct2, ParserInfo.moveinstruct3};
        String MoveNegTest[] = new String[]{ParserInfo.negmoveinstruct1, ParserInfo.negmoveinstruct2, ParserInfo.negmoveinstruct3};
        String InterruptMemTest[] = new String[]{ParserInfo.interruptmeminstruct1, ParserInfo.interruptmeminstruct2};
        String InterruptRegTest[] = new String[]{ParserInfo.interruptreginstruct1, ParserInfo.interruptreginstruct2};

        String ANDTest[] = new String[]{ParserInfo.ANDinstruct1, ParserInfo.ANDinstruct2, ParserInfo.ANDinstruct3};
        String ORTest[] = new String[]{ParserInfo.ORinstruct1, ParserInfo.ORinstruct2,  ParserInfo.ORinstruct3};
        String XORTest[] = new String[]{ParserInfo.XORinstruct1, ParserInfo.XORinstruct2, ParserInfo.XORinstruct3};
        String NOTTest[] = new String[]{ParserInfo.NOTinstruct1, ParserInfo.NOTinstruct2, ParserInfo.NOTinstruct3};
        String leftShiftTest[] = new String[]{ParserInfo.leftshiftinstruct1, ParserInfo.leftshiftinstruct2, ParserInfo.leftshiftinstruct3};
        String rightShiftTest[] = new String[]{ParserInfo.rightshiftinstruct1, ParserInfo.rightshiftinstruct2, ParserInfo.rightshiftinstruct3};
        String addTest[] = new String[]{ParserInfo.addinstruct1, ParserInfo.addinstruct2, ParserInfo.addinstruct3};
        String subTest[] = new String[]{ParserInfo.subtractinstruct1, ParserInfo.subtractinstruct2, ParserInfo.subtractinstruct3};
        String multTest[] = new String[]{ParserInfo.multiplyinstruct1, ParserInfo.multiplyinstruct2, ParserInfo.multiplyinstruct3};

        String Command = "";

        Command = HumbleAssembler.assemble(HaltTest);
        System.out.println("Expected Value: 0000000000000000");
        System.out.println("Halt Command:   " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(MoveTest);
        System.out.println("Expected Value: 0001001000001010");
        System.out.println("Move Command:   " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(MoveNegTest);
        System.out.println("Expected Value:        0001111111111111");
        System.out.println("Move Negative Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(InterruptMemTest);
        System.out.println("Expected Value:       0010000000000000");
        System.out.println("InterruptMem Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(InterruptRegTest);
        System.out.println("Expected Value:       0010000000000001");
        System.out.println("InterruptReg Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(ANDTest);
        System.out.println("Expected Value: 1000010011000000");
        System.out.println("AND Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(ORTest);
        System.out.println("Expected Value: 1001010100110000");
        System.out.println("OR Command:     " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(XORTest);
        System.out.println("Expected Value: 1010001101100000");
        System.out.println("XOR Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(NOTTest);
        System.out.println("Expected Value: 1011100001110000");
        System.out.println("NOT Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(leftShiftTest);
        System.out.println("Expected Value:    1100001101100000");
        System.out.println("LeftShift Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(rightShiftTest);
        System.out.println("Expected Value:     1101110011100000");
        System.out.println("RightShift Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(addTest);
        System.out.println("Expected Value: 1110111100100000");
        System.out.println("Add Command:    " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(subTest);
        System.out.println("Expected Value:   1111110001100000");
        System.out.println("Subtract Command: " + Command);
        System.out.println("");

        Command = HumbleAssembler.assemble(multTest);
        System.out.println("Expected Value:   0111001000100000");
        System.out.println("Multiply Command: " + Command);
        System.out.println("");
    }
}
