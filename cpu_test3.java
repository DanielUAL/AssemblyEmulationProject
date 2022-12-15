public class cpu_test3 {
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
        cpu_test2 CpuTest2 = new cpu_test2();

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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CPU Test 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        cpu_test3.runCPUTest3();
    }

    /**
     * Runs the Stack Testing. Push will take in the stack op code, and run push due to the 00 after opcode.
     * Then return will return the last 32 bits of the memory as a default. So due to the fact that register
     * 15 contains no value, the return will be all 0s.
     */
    public static void runCPUTest3(){
        String[] ArrayOfStrings2 = new String[2];

        System.out.println("Push");
        HumbleComputer pushTest = new HumbleComputer();

        String pushFirstString = "0110000000101111";   //push
        String pushSecondString = "0110110000000000";  //return

        ArrayOfStrings2[0] = pushFirstString;
        ArrayOfStrings2[1] = pushSecondString;

        pushTest.preload(ArrayOfStrings2);
        pushTest.run();

        System.out.println("Pop");
        HumbleComputer popTest = new HumbleComputer();

        String popFirstString = "0110010000001111";   //pop
        String popSecondString = "0110110000000000";  //return

        ArrayOfStrings2[0] = popFirstString;
        ArrayOfStrings2[1] = popSecondString;

        popTest.preload(ArrayOfStrings2);
        popTest.run();

        System.out.println("Call");
        HumbleComputer callTest = new HumbleComputer();

        String callFirstString = "0110100000001111";   //call
        String callSecondString = "0110110000000000";  //return

        ArrayOfStrings2[0] = callFirstString;
        ArrayOfStrings2[1] = callSecondString;

        callTest.preload(ArrayOfStrings2);
        callTest.run();
    }
}