public class cpu_test2 {
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
