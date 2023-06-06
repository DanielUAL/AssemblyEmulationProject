public class cpu_test2 {
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
        assembler_test AssemblerTest = new assembler_test();

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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Assembler Test~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        AssemblerTest.runAssemblerTest();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CPU Test 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        cpu_test2.runCPUTest2();
    }

    /**
     * Tests to see if Jump, Compare, and Branch methods work.
     */
    public static void runCPUTest2(){
        String[] ArrayOfStrings2 = new String[2];

        System.out.println("Jump");
        HumbleComputer jumpTest = new HumbleComputer();

        String jumpFirstString = "0011000000000111";   //jump to 7th register
        String jumpSecondString = "0010000000000001";  //mem print

        ArrayOfStrings2[0] = jumpFirstString;
        ArrayOfStrings2[1] = jumpSecondString;

        jumpTest.preload(ArrayOfStrings2);
        jumpTest.run();

        System.out.println("Compare");
        System.out.println("Expected output of first is a 01, because A<B");
        System.out.println("Expected output of first is a 10, because A>B");
        HumbleComputer CompareTest = new HumbleComputer();

        String CompareFirstString = "0100000011101111";   //A < B
        String CompareSecondString = "0100000011111110";  //A > B

        ArrayOfStrings2[0] = CompareFirstString;
        ArrayOfStrings2[1] = CompareSecondString;

        CompareTest.preload(ArrayOfStrings2);
        CompareTest.run();

        System.out.println("Expected output of first is a 11, because A=B");
        System.out.println("Expected output of first is a 0, because Halt");
        HumbleComputer CompareTest2 = new HumbleComputer();

        String Compare2FirstString = "0100000011111111";
        String Compare2SecondString = "0000000011111110";

        ArrayOfStrings2[0] = Compare2FirstString;
        ArrayOfStrings2[1] = Compare2SecondString;

        CompareTest2.preload(ArrayOfStrings2);
        CompareTest2.run();


        System.out.println("Branch");
        HumbleComputer BranchTest = new HumbleComputer();
        BranchTest.run();
    }
}
